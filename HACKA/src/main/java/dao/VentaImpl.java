package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import modelo.Venta;
import modelo.Destino;

public class VentaImpl extends Conexion implements ICRUD<Venta> {
    
    @Override
    public void registrar(Venta ven) throws Exception {
        String sql = "insert into venta ( CODPIZ,CODVEDE,CODVENT) values (?,?,?)";
        try {
            PreparedStatement ps = VentaImpl.conectar ().prepareStatement(sql);            
            ps.setInt(1, ven.getCODPIZ());            
            ps.setInt(2, ven.getCODVEDE());
            ps.setInt(3, ven.getCODVENT());
            
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Venta: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Venta ven) throws Exception {
        String sql = "update venta set CODPIZ=?,CODVEDE=?,CODVENT=? where CODVENT=? ";
//        String sql = "update venta set CODCLI=?,CODEMP=?,TOTVEN=?CODUBI=?, where CODVEN=? ";        
        try {
            PreparedStatement ps = VentaImpl.conectar().prepareStatement(sql);
            ps.setInt(1, ven.getCODPIZ());            
            ps.setInt(2, ven.getCODVEDE());            
            ps.setInt(3, ven.getCODVENT());                                         
          

//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Venta: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Venta ven) throws Exception {
        String sql = "delete from venta where CODVENT=?";        
        try {
            PreparedStatement ps = VentaImpl.conectar().prepareStatement(sql);            
            ps.setInt(1, ven.getCODVENT());
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
    @SuppressWarnings("unchecked")
    public List listarTodos() throws Exception {
        List<Venta> listado = null;
        Venta ven;
        String sql = "select c.CODVENT,c.CODVEDE,c.CODPIZ" +
                      " from Venta c INNER JOIN Despachador u ON u.DNIDES =u.DNIDES;";
        
        try {
            listado = new ArrayList();
            Statement st = VentaImpl.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ven = new Venta();
                ven.setCODVENT(rs.getInt("CODVENT"));
                ven.setCODVEDE(rs.getInt("CODVEDE"));
                ven.setCODPIZ(rs.getInt("CODPIZ"));                         
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
   
