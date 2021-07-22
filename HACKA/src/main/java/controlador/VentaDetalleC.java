package controlador;

import dao.VentaDetalleImpl;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import modelo.VentaDetalle;
import modelo.Producto;


@Named(value = "VentaDetalleC")
@SessionScoped
public class VentaDetalleC implements Serializable {

    // private static final long serialVersionUID = 1L;

    
    private VentaDetalle vede;
    private VentaDetalleImpl dao;
    private List<VentaDetalle> listadoventas;
    public VentaDetalleC(){
        dao=new VentaDetalleImpl();
        listadoventas=new ArrayList<>();
        vede = new VentaDetalle();
   
    
    }
    
   
 public void registrar() throws Exception {
        try {
            dao.registrar(vede);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
          
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(vede);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(VentaDetalle vendet) throws Exception{
        try {            
            dao.eliminar(vede);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
           
        } catch (Exception e) { 
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }
    
    public void agregarFila () { 
        int c= vede.getProducto().getCODPIZ();
    System.out.println(c);
        try { System.out.println(vede.getProducto().getCODPIZ()+vede.getDNICLI());           
            VentaDetalle v = dao.agregarFila(c,vede.getCODVEDE());
            v.setCODPIZ(vede.getProducto().getCODPIZ());
            v.setTOTVENT(vede.getTOTVENT());
            v.setNOMPIZ(vede.getProducto().getNOMPIZ());
            v.setSTOPIZ(vede.getProducto().getSTOPIZ());
            v.setCODDEST(vede.getCODDEST());
            v.setDNIDES(vede.getDNIDES());
        //    v.setPrecprod(vede.getProducto().setSTOPIZ(c));
            v.setDNICLI(vede.getDNICLI());
            v.setNOMCLI(vede.getNOMCLI());
            listadoventas.add(v);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

public void obtener () throws Exception {
    
   int c= vede.getProducto().getCODPIZ();
    System.out.println(c);
    VentaDetalle v = dao.agregarFila(c,vede.getCODVEDE());
            v.setCODPIZ(vede.getProducto().getCODPIZ());
            v.setCANPROVENT(vede.getCANPROVENT());
            v.setCODPIZ(vede.getCODPIZ());
            v.setCANPROVENT(vede.getDNIDES());
            v.setCODPIZ(vede.getCODSUC());
            v.setCANPROVENT(vede.getTOTVENT());
            
            v.setPREPPIZ(vede.getPREPPIZ());
            v.setSTOPIZ(vede.getSTOPIZ());
            v.setDNICLI(vede.getDNICLI());
            v.setNOMCLI(vede.getNOMCLI());
            v.setDNICLI(vede.getLUGDES());
            listadoventas.add(v);
}


    public void limpiar() {
        vede = new VentaDetalle();
    }


    
    // métodos generados
    public VentaDetalle getVentaDetalle() {
        return vede;
    }

    public void setVede(VentaDetalle c) {
        this.vede = c;
    }

    public VentaDetalleImpl getDao() {
        return dao;
    }

    public void setDao(VentaDetalleImpl dao) {
        this.dao = dao;
    }

    public List<VentaDetalle> getListadoVede() {
        return listadoventas;
    }

    public void setListadoVede(List<VentaDetalle> listaVenta) {
        this.listadoventas = listaVenta;
    }

}
