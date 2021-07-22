package controlador;

import dao.JefeSucursalImpl;
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
import modelo.JefeSucursal;


@Named(value = "JefeSucursalC")
@SessionScoped
@SuppressWarnings("serial")
public class JefeSucursalC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private JefeSucursal jef;
    private JefeSucursal jefMod;
    private JefeSucursalImpl dao;
    private List<JefeSucursal> listadoJefeSucursal;
    public JefeSucursalC(){
        dao=new JefeSucursalImpl();
        listadoJefeSucursal=new ArrayList<>();
        jef =new JefeSucursal();
    
        jefMod = new JefeSucursal();
        
       
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(jef);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(jefMod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(JefeSucursal jef) throws Exception{
        try {            
            dao.eliminar(jef);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }


    public void limpiar() {
        jef = new JefeSucursal();
    }

//    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoJefeSucursal = dao.listarTodos();
            for (JefeSucursal listadojef : listadoJefeSucursal) {
                System.out.println(listadojef.getDNIJEF());
                
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

    public JefeSucursal getJef() {
        return jef;
    }

    public void setJef(JefeSucursal jef) {
        this.jef = jef;
    }

    public JefeSucursalImpl getDao() {
        return dao;
    }

    public void setDao(JefeSucursalImpl dao) {
        this.dao = dao;
    }

    public List<JefeSucursal> getListadoJefeSucursal() {
        return listadoJefeSucursal;
    }

    public void setListadoJefeSucursal(List<JefeSucursal> listadoJefeSucursal) {
        this.listadoJefeSucursal = listadoJefeSucursal;
    }

    public JefeSucursal getJefMod() {
        return jefMod;
    }

    public void setJefMod(JefeSucursal jefMod) {
        this.jefMod = jefMod;
    }
    

}
