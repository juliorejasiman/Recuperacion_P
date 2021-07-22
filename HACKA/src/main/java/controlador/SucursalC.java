package controlador;

import dao.SucursalImpl;
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
import modelo.Sucursal;


@Named(value = "SucursalC")
@SessionScoped
@SuppressWarnings("serial")
public class SucursalC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Sucursal suc;
    private Sucursal sucMod;
    private SucursalImpl dao;
    private List<Sucursal> listadoSucursal;
    public SucursalC(){
        dao=new SucursalImpl();
        listadoSucursal=new ArrayList<>();
        suc =new Sucursal();
    
        sucMod = new Sucursal();
        
       
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(suc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(sucMod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Sucursal suc) throws Exception{
        try {            
            dao.eliminar(suc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        suc = new Sucursal();
    }

//    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoSucursal = dao.listarTodos();
            for (Sucursal listadosuc : listadoSucursal) {
                System.out.println(listadosuc.getCODSUC());
                
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

    public Sucursal getSuc() {
        return suc;
    }

    public void setSuc(Sucursal suc) {
        this.suc = suc;
    }

    public SucursalImpl getDao() {
        return dao;
    }

    public void setDao(SucursalImpl dao) {
        this.dao = dao;
    }

    public List<Sucursal> getListadoEmpleado() {
        return listadoSucursal;
    }

    public void setListadoSucursal(List<Sucursal> listadoSucursal) {
        this.listadoSucursal = listadoSucursal;
    }

    public Sucursal getSucMod() {
        return sucMod;
    }

    public void setSucMod(Sucursal sucMod) {
        this.sucMod = sucMod;
    }
    

}
