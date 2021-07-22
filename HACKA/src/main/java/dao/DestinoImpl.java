package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Destino;


public class DestinoImpl extends Conexion implements ICRUD<Destino> {
    
    @Override
    public void registrar(Destino dest) throws Exception {
        
        String sql = "insert into empleado ( CODDEST,DIRDES) values (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, dest.getCODDEST());            
            ps.setString(2, dest.getDIRDES());
       
            
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Destino: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Destino dest) throws Exception {
        String sql = "update Destino set CODDEST=?,DIRDES=?  where CODDEST=? ";       
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, dest.getCODDEST());            
            ps.setString(2, dest.getDIRDES());            
                    
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Destino: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Destino dest) throws Exception {
        String sql = "update empleado set estemp='I' from empleado where codemp=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, dest.getCODDEST());
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
        List<Destino> listado = null;
        Destino dest;
        String sql = "select e.CODEMP,e.NOMEMP,e.APEVEMP,e.DNIEMP,e.CELEMP,e.ESTEMP,e.CODUBI,u.DEPUBI,u.DISUBI,u.PROUBI\n" +
"                 from Empleado e INNER JOIN Ubigeo u ON e.CODUBI =u.CODUBI where estemp='A'  order by CODEMP desc";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dest = new Destino(Integer.BYTES, sql);
                dest.setCODDEST(rs.getInt("CODDDEST"));
                dest.setDIRDES(rs.getString("DIRDES"));
              
                listado.add(dest);
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