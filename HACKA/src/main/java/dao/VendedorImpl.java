package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Vendedor;



public class VendedorImpl extends Conexion implements ICRUD<Vendedor> {
    
    @Override
    public void registrar(Vendedor ven) throws Exception {
        
        String sql = "insert into empleado (DNIEMP,NOMVEN,APEVEN,CELVEN) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);                   
            ps.setInt(1, ven.getDNIVEN()); 
            ps.setString(2, ven.getAPEVEN());
            ps.setString(3, ven.getNOMVEN());
            ps.setInt(4, ven.getCELVEN());
            
               
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Vendedor: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Vendedor ven) throws Exception {
        String sql = "update Vendedor set DNIVEN=?,NOMVEN=?,APEVEN=?,CELVEN=? where DNIVEN=? ";
       
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, ven.getDNIVEN()); 
            ps.setString(2, ven.getAPEVEN());
            ps.setString(3, ven.getNOMVEN());
            ps.setInt(4, ven.getCELVEN());
            
//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Empleado: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Vendedor emp) throws Exception {
        String sql = "update Vendedor set estemp='I' from empleado where codemp=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, emp.getDNIVEN());
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
        List<Vendedor> listado = null;
        Vendedor ven;
        String sql = "select e.CODEMP,e.NOMEMP,e.APEVEMP,e.DNIEMP,e.CELEMP,e.ESTEMP,e.CODUBI,u.DEPUBI,u.DISUBI,u.PROUBI\n" +
"                 from Empleado e INNER JOIN Ubigeo u ON e.CODUBI =u.CODUBI where estemp='A'  order by CODEMP desc";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ven = new Vendedor();
                ven.setDNIVEN(rs.getInt("DNIVEN"));
                ven.setNOMVEN(rs.getString("NOMVEN"));
                ven.setAPEVEN(rs.getString("APEVEN"));
                ven.setCELVEN(rs.getInt("DNIVEN"));              
                listado.add(ven);
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