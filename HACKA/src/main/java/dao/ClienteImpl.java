package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import modelo.Cliente;

public class ClienteImpl extends Conexion implements ICRUD<Cliente> {
    
    @Override
    public void registrar(Cliente cli) throws Exception {
        // dni_per | nom_per | cel_cli | ape_cli | dir_cli | cod_ubi | (6 campos)
        String sql = "insert into cliente (DNICLI,NOMCLI,CELCLI,APECLI,DIRCLI) values (?.?,?,?,?)";
        try {
           
            PreparedStatement ps = this.conectar().prepareStatement(sql);           
            ps.setInt(1, cli.getDNICLI());
            ps.setString(2, cli.getNOMCLI());            
            ps.setString(3, cli.getAPECLI());
           
            ps.setString(4, cli.getDIRCLI());
             ps.setString(5, cli.getCELCLI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Cliente: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Cliente cli) throws Exception {
        String sql = "update cliente set DNICLI=?,NOMCLI=?,CELCLI=?,APECLI=?,DIRCLI=? where DNICLI=? ";      
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cli.getDNICLI());
            ps.setString(2, cli.getNOMCLI());            
            ps.setString(3, cli.getCELCLI());
            ps.setString(4, cli.getAPECLI());
            
            ps.setString(5, cli.getDIRCLI());
            

//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Cliente: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Cliente cli) throws Exception {
        String sql = "delete from cliente where dni_cli=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, cli.getDNICLI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarD" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    @Override
    @SuppressWarnings("unchecked")
  public List listarTodos() throws Exception {
        List<Cliente> listado = null;
        Cliente cli;
        String sql = "select c.CODCLI,c.DNICLI,c.NOMCLI,c.CELCLI,c.APECLI,c.DIRCLI";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setDNICLI(rs.getInt("DNICLI"));
                cli.setNOMCLI(rs.getString("NOMCLI"));
                cli.setCELCLI(rs.getString("CELCLI"));
                cli.setAPECLI(rs.getString("APECLI"));
                cli.setDIRCLI(rs.getString("DIRCLI"));
                listado.add(cli);
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