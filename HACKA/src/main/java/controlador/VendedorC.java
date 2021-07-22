package controlador;

import dao.VendedorImpl;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import modelo.Vendedor;


@Named(value = "EmpleadoC")
@SessionScoped
@SuppressWarnings("serial")
public class VendedorC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Vendedor ven;
    private Vendedor venMod;
    private VendedorImpl dao;
    private List<Vendedor> listadoVendedor;
    public VendedorC(){
        dao=new VendedorImpl();
        listadoVendedor=new ArrayList<>();
        ven =new Vendedor();
    
        venMod = new Vendedor();
        
       
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(ven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(venMod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Vendedor ven) throws Exception{
        try {            
            dao.eliminar(ven);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }


    public void limpiar() {
        ven = new Vendedor();
    }

//    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoVendedor = dao.listarTodos();
            for (Vendedor listadoven : listadoVendedor) {
                System.out.println(listadoven.getDNIVEN());
                
            }
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    @PostConstruct
    public void construir() {
        listar();
    }
    public static void main(String[] args) {
        ProductoC C=new ProductoC();
        C.listar();
    }
    // métodos generados

    public Vendedor getVen() {
        return ven;
    }

    public void setVen(Vendedor ven) {
        this.ven = ven;
    }

    public VendedorImpl getDao() {
        return dao;
    }

    public void setDao(VendedorImpl dao) {
        this.dao = dao;
    }

    public List<Vendedor> getListadoVendedor() {
        return listadoVendedor;
    }

    public void setListadoVendedor(List<Vendedor> listadoVendedor) {
        this.listadoVendedor = listadoVendedor;
    }

    public Vendedor getVenMod() {
        return venMod;
    }

    public void setVenMod(Vendedor venMod) {
        this.venMod = venMod;
    }
    

}
