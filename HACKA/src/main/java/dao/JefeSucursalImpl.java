package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import modelo.JefeSucursal;

public class JefeSucursalImpl extends Conexion implements ICRUD<JefeSucursal> {
    
    @Override
    public void registrar(JefeSucursal jefsuc) throws Exception {
        // dni_per | nom_per | cel_cli | ape_cli | dir_cli | cod_ubi | (6 campos)
        String sql = "insert into JefeSucursal (DNIJEF,NOMJEF,APECJEF,CELJEF) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, jefsuc.getDNIJEF());
            ps.setString(2, jefsuc.getNOMJEF());            
            ps.setString(3, jefsuc.getAPEJEF());
            ps.setString(4, jefsuc.getCELJEF());
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Jefe de Sucursal: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(JefeSucursal jefsuc) throws Exception {
        String sql = "update JefeSucursal set DNIJEF=?,NOMJEF=?,APEJEF=?,CELJEF=? where DNIJEF=? ";      
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, jefsuc.getDNIJEF());
            ps.setString(2, jefsuc.getNOMJEF());            
            ps.setString(3, jefsuc.getAPEJEF());
            ps.setString(4, jefsuc.getCELJEF());
            

//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar JefeSucursal: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(JefeSucursal jefsuc) throws Exception {
        String sql = "delete from JefeSucursal where dni_jef=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, jefsuc.getDNIJEF());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarD" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    // dni_cli nom_cli cel_cli ape_cli dir_cli _per
    @Override
    public List listarTodos() throws Exception {
        List<JefeSucursal> listado = null;
        JefeSucursal jefsuc;
        String sql = "select c.CODJEF,c.DNIJEF,c.NOMJEF,c.APEJEF,c.CELJEF"
                + " from JefeSucursal c INNER JOIN Administrador u ON c.DNIADM=u.DNIADM";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                jefsuc = new JefeSucursal();
                jefsuc.setDNIJEF(rs.getInt("DNIJEF"));
                jefsuc.setNOMJEF(rs.getString("NOMJEF"));
                jefsuc.setAPEJEF(rs.getString("APEJEF"));
                jefsuc.setCELJEF(rs.getString("CELJEF"));
                
                listado.add(jefsuc);
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error en listarTodosD: " + e.getMessage());
        } finally {
            this.cerrar();
        }        
        return listado;        
    }
    
}