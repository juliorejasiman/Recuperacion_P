package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Admi;




public class AdmiImpl extends Conexion implements ICRUD<Admi> {
    
    @Override
    public void registrar(Admi adm) throws Exception {
        
        String sql = "insert into Administrador ( DNIADM, NOMADM,APEADM,CELADM) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);           
            ps.setInt(1, adm.getDNIADM());            
            ps.setString(2, adm.getNOMADM());
            ps.setString(3, adm.getAPEADM());
            ps.setString(4, adm.getCELADM());
       
                        
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Administrador: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Admi adm) throws Exception {
        String sql = "update empleado set DNIADM=?,NOMADM=?,APEADM=?,CELADM=? where DNIADM=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
                      
            ps.setString(1, adm.getNOMADM());            
            ps.setString(2, adm.getAPEADM());            
            ps.setString(3, adm.getCELADM());    
            ps.setInt(4, adm.getDNIADM()); 
//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Administrador: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Admi adm) throws Exception {
        String sql = "delete from Administrador where dni_adm=?"; 
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, adm.getDNIADM());
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
        List<Admi> listado = null;
        Admi adm;
        String sql = "select e.CODEMP,e.NOMEMP,e.APEVEMP,e.DNIEMP,e.CELEMP,e.ESTEMP\n" +
                "from Empleado e INNER JOIN Destino u ON CODDEST =u.CODDEST order by CODEMP desc";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                adm = new Admi();
                adm.setDNIADM(rs.getInt("CODEMP"));
                adm.setNOMADM(rs.getString("NOMEMP"));
                adm.setAPEADM(rs.getString("APEVEMP"));
                adm.setCELADM(rs.getString("DNIEMP"));
                              
                listado.add(adm);
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