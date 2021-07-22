package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Sucursal;

public class SucursalImpl extends Conexion implements ICRUD<Sucursal> {
    
    @Override
    public void registrar(Sucursal suc) throws Exception {
        
        String sql = "insert into empleado ( CODSUC,LUGSUC) values (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, suc.getCODSUC());            
            ps.setString(2, suc.getLUGSUC());
           
            
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Sucursal: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Sucursal suc) throws Exception {
        String sql = "update Sucursal set CODSUC=?,LUGSUC=?  where CODSUC=? ";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, suc.getLUGSUC());                       
            ps.setInt(2, suc.getCODSUC());

//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Sucursal: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Sucursal suc) throws Exception {
        String sql = "update empleado set estemp='I' from empleado where codemp=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, suc.getCODSUC());
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
        List<Sucursal> listado = null;
        Sucursal suc;
        String sql = "select e.CODSUC,e.LUGSUC" +
"                 from Sucursal e INNER JOIN JefeSucursal u ON e.DNIJEF =u.DNIJEF  order by CODSUC desc";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                suc = new Sucursal(Integer.SIZE, sql);
                suc.setCODSUC(rs.getInt("CODSUC"));
                suc.setLUGSUC(rs.getString("LUGSUC"));
               
                listado.add(suc);
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