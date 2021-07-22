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
import modelo.Producto;
import modelo.Sucursal;
import modelo.Vendedor;


public class ProductoImpl extends Conexion implements ICRUD<Producto> {

    public boolean validacion;
    
    @Override
    public void registrar(Producto pro) throws Exception {
        // dni_per | nom_per | cel_cli | ape_cli | dir_cli | cod_ubi | (6 campos)
        String sql = "insert into Producto (CODPIZ,NOMPIZ,TIPPIZ,PREPPIZ,STOPIZ,DNIVEN,DNIJEF) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, pro.getCODPIZ()); 
            ps.setString(2, pro.getNOMPIZ()); 
            ps.setString(3, pro.getTIPPIZ());
            ps.setInt(4, pro.getPREPPIZ());
            ps.setInt(5, pro.getSTOPIZ());
                      
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Producto: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public void modificar(Producto pro) throws Exception {
        String sql = "update producto set CODPIZ=?,NOMPIZ=?,TIPPIZ=?,PREPPIZ=?,STOPIZ=? where CODPIZ=? ";      
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
           ps.setInt(1, pro.getCODPIZ()); 
            ps.setString(2, pro.getNOMPIZ()); 
            ps.setString(3, pro.getTIPPIZ());
            ps.setInt(4, pro.getPREPPIZ());
            ps.setInt(5, pro.getSTOPIZ());
//                      
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar Producto: " + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Producto pro) throws Exception {
        String sql = "delete from producto where nom_pro=?";        
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setString(1, pro.getNOMPIZ());
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
        List<Producto> listado = null;
        Producto pro;
        String sql ="  select p.CODPIZ,p.NOMPIZ,p.TIPPIZ,p.PREPPIZ ,p.STOPIZ, // PROV.CODPROV,PROV.MARPROV,\n" +
"subfam.CODSUBFAM, subfam.DESSUB,fam.CODFAM,fam.DESFAM\n" +
"                  from PRODUCTO p INNER JOIN Proveedor prov ON p.CODPROV = prov.CODPROV\n" +
"INNER JOIN SUB_FAMILIA subfam ON p.CODSUBFAM = subfam.CODSUBFAM\n" +
"INNER JOIN Familia fam ON subfam.CODFAM=fam.CODFAM";
        
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pro = new Producto();
                pro.setCODPIZ(rs.getInt("CODPIZ"));
                pro.setNOMPIZ(rs.getString("NOMPIZ"));
                pro.setTIPPIZ(rs.getString("TIPPPIZ"));
                pro.setPREPPIZ(rs.getInt("PREPPIZ"));
                pro.setSTOPIZ(rs.getInt("STOPIZ"));
                
               
             // INSTANCIA DE PROVEEDOR PARA SETEAR LS CAMPOS COD Y MARCA//   
                Sucursal suc = new Sucursal();
                suc.setCODSUC(rs.getInt("CODSUC"));
                suc.setLUGSUC(rs.getString("LUGSUC"));
                suc.setCODSUC(suc);
                
                // INSTANCIA DE FAMILIA PARA SETETAR SUBFAM Y FAM//
                Vendedor ven = new Vendedor();
                ven.setDNIVEN(rs.getInt("DNIVEN"));
                ven.setNOMVEN(rs.getString("NOMVEN"));                
                
                // INSTANCIA DE SUB_FAMILIA PARA SETETAR SUBFAM Y FAM//
                
                JefeSucursal jefsuc = new  JefeSucursal();
                jefsuc.setDNIJEF(rs.getInt("DNIJEF"));
                jefsuc.setNOMJEF(rs.getString("NOMJEF"));
       //         suc.getLUGSUC(jefsuc);
        //        pro.setCODPIZ(jefsuc);
                // AGREGANDO LA LISTA PRODUCTO//
                listado.add(pro);
                
                
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

    public void validarproducto(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}