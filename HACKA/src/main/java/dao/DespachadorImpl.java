package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Despachador;

public class DespachadorImpl extends Conexion implements ICRUD<Despachador> {
    
    @Override
    public void registrar(Despachador des) throws Exception {
        
        String sql = "insert into empleado ( DNIDES,NOMDES,APEDES,CELDES) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, des.getDNIDES());            
            ps.setString(2, des.getNOMDES());
            ps.setString(3, des.getAPEDES());
            ps.setInt(4, des.getCELDES());
  
            
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Despachador: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Despachador des) throws Exception {
        String sql = "update Despachador set DNIDES=?,NOMDES=?,APEDES=?,CELDES=? where DNIDES=? ";       
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, des.getNOMDES());            
            ps.setString(2, des.getAPEDES());            
            ps.setInt(3, des.getCELDES());                    
            ps.setInt(4, des.getDNIDES());

//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Despachador: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Despachador des) throws Exception {
        String sql = "update Despachador set estemp='I' from Despachador where codemp=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, des.getDNIDES());
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
        List<Despachador> listado = null;
        Despachador des;
        String sql = "select e.DNIDES,e.NOMDES,e.APEDES,e.CELDES" +
"                 from Despachador e INNER JOIN JefeSucursal u ON e.DNIJEF =u.DNIJEF order by DNIDES desc";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                des = new Despachador();
                des.setDNIDES(rs.getInt("DNIDES"));
                des.setNOMDES(rs.getString("NOMDES"));
                des.setAPEDES(rs.getString("APEDES"));
                des.setCELDES(rs.getInt("CELDES"));
                listado.add(des);
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