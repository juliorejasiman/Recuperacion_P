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
import modelo.Cliente;
import modelo.Producto;
import modelo.VentaDetalle;

public class VentaDetalleImpl extends Conexion implements ICRUD<VentaDetalle> {
    
    @Override
    public void registrar(VentaDetalle vede) throws Exception {
        String sql = "insert into Venta_Detalle ( CODVEDE,CODVENT,CODPIZ,TOTVENT,CANPROVENT,FECVEN, DNIADM,"
                + "DNIJEF ,CODSUC,DNIDES ,DNICLI,CODDEST ,NOMPIZ,PREPPIZ,STOPIZ,NOMCLI,LUGDES ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, vede.getCODVEDE());            
            ps.setInt(2, vede.getCODVENT());
            ps.setInt(3, vede.getCODPIZ());
            ps.setString(4, vede.getTOTVENT());
            ps.setString(5, vede.getCANPROVENT());
            ps.setDate(6, vede.getFECVEN());
            ps.setString(7, vede.getDNIADM());            
            ps.setString(8, vede.getDNIJEF());
            ps.setInt(9, vede.getCODSUC());
            ps.setString(10, vede.getDNIDES());
            ps.setString(11, vede.getDNICLI());
            ps.setInt(12, vede.getCODDEST());          
            ps.setString(13, vede.getNOMPIZ());
            ps.setDouble(14, vede.getPREPPIZ());
            ps.setInt(15, vede.getSTOPIZ());
            ps.setString(16, vede.getNOMCLI());
            ps.setString(17, vede.getLUGDES());

    
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar VentaDetalle: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(VentaDetalle vede) throws Exception {
        String sql = "update Venta_Detalle set CODVEDE=?,CODVENT=?,CODPIZ=?,TOTVENT=?,CANPROVENT=?,FECVEN=?"
                + ",DNIADM=?,DNIJEF=?,CODSUC=?,DNIDES=?,DNICLI=?,CODDEST=? ,NOMPIZ=?,PREPPIZ=?,STOPIZ=?,NOMCLI=?,LUGDES=?  where CODVEDE=? ";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
          ps.setInt(1, vede.getCODVEDE());            
            ps.setInt(2, vede.getCODVENT());
            ps.setInt(3, vede.getCODPIZ());
            ps.setString(4, vede.getTOTVENT());
            ps.setString(5, vede.getCANPROVENT());
            ps.setDate(6, vede.getFECVEN());
            ps.setString(7, vede.getDNIADM());            
            ps.setString(8, vede.getDNIJEF());
            ps.setInt(9, vede.getCODSUC());
            ps.setString(10, vede.getDNIDES());
            ps.setString(11, vede.getDNICLI());
            ps.setInt(12, vede.getCODDEST());         
            ps.setString(13, vede.getNOMPIZ());
            ps.setDouble(14, vede.getPREPPIZ());
            ps.setInt(15, vede.getSTOPIZ());
            ps.setString(16, vede.getNOMCLI());
            ps.setString(17, vede.getLUGDES());
            

//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Venta: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(VentaDetalle vede) throws Exception {
        String sql = "delete from Venta_Detalle where COVEDE=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, vede.getCODVEDE());
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
        List<VentaDetalle> listado = null;
        VentaDetalle vede;
        String sql = "select c.CODVEDE,c.CODVENT,c.CODPIZ,c.TOTVENT,u.CANPROVENT,u.FECVEN,"
                + " c.DNIADM,c.DNIJEF,c.CODSUC,c.DNIDES,u.DNICLI,u.CODDEST"
                + ",c.NOMPIZ,c.PREPPIZ,c.STOPIZ,c.NOMCLI,u.LUGDES";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                vede = new VentaDetalle();
                vede.getCODVEDE(rs.getInt("CODVEDE"));
                vede.setCODVENT(rs.getInt("CODVENT"));
                vede.setCODPIZ(rs.getInt("CODPIZ"));
                vede.setTOTVENT(rs.getString("TOTVENT"));
                vede.setCANPROVENT(rs.getString("CANPROVENT"));
                vede.setFECVEN(rs.getDate("FECVEN"));
                vede.setDNIADM(rs.getString("DNIADM"));
                vede.setDNIJEF(rs.getString("DNIJEF"));
                vede.setCODSUC(rs.getInt("CODSUC"));
                vede.setDNIDES(rs.getString("DNIDES"));
                vede.setDNICLI(rs.getString("DNICLI"));
                vede.setCODDEST(rs.getInt("CODDEST"));
                vede.setNOMPIZ(rs.getString("NOMPIZ"));
                vede.setPREPPIZ(rs.getDouble("PREPPIZ"));
                vede.setSTOPIZ(rs.getInt("STOPIZ"));
                vede.setNOMCLI(rs.getString("NOMCLI"));
                vede.setLUGDES(rs.getString("LUGDES"));
                listado.add(vede);

                
                
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
    public VentaDetalle agregarFila (int producto, int cliente ) throws Exception{
     VentaDetalle v = null;
        String sql1 = "SELECT CODPIZ,NOMPIZ,PREPIZ,DATTECPROD FROM PRODUCTO "
                + "WHERE CODPROD =" + producto + "";
        String sql2 = "SELECT DNICLI,NOMCLI FROM CLIENTE WHERE DNICLI =" + cliente +"";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql1);
            PreparedStatement ps2 = this.conectar().prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs2.next() && rs.next())  {
                v = new VentaDetalle();
                Producto p = new Producto();
                Cliente c = new Cliente();
                v.setCODPIZ(rs.getInt("CODPIZ"));
                p.setNOMPIZ(rs.getString("NOMPIZ"));
                p.setPREPPIZ(rs.getInt("PREPIZ"));
                p.setTIPPIZ(rs.getString("DATTECPROD"));
                v.setProducto(p);
                
                v.setDNICLI(rs2.getString ("DNICLI"));
                c.setNOMCLI(rs2.getString("NOMCLI"));
                
                v.setCliente(c);
                
}
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.out.println("Error en agregarLista: " + e.getMessage());
        } finally { 
            this.cerrar();
            return v;
        
    }
  }
}
