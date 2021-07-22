package controlador;

import dao.AdmiImpl;
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
import modelo.Admi;


@Named(value = "AdmiC")
@SessionScoped
@SuppressWarnings("serial")
public class AdmiC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Admi adm;
    private Admi admMod;
    private AdmiImpl dao;
    private List<Admi> listadoAdmi;
    public AdmiC(){
        dao=new AdmiImpl();
        listadoAdmi=new ArrayList<>();
        adm =new Admi();
    
        admMod = new Admi();
        
       
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(adm);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(admMod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Admi adm) throws Exception{
        try {            
            dao.eliminar(adm);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }
 

    public void limpiar() {
        adm = new Admi();
    }

//    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoAdmi = dao.listarTodos();
            for (Admi listadoadm : listadoAdmi) {
                System.out.println(listadoadm.getDNIADM());
                
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

    public Admi getEmp() {
        return adm;
    }

    public void setEmp(Admi adm) {
        this.adm = adm;
    }

    public AdmiImpl getDao() {
        return dao;
    }

    public void setDao(AdmiImpl dao) {
        this.dao = dao;
    }

    public List<Admi> getListadoAdmi() {
        return listadoAdmi;
    }

    public void setListadoAdmi(List<Admi> listadoAdmi) {
        this.listadoAdmi = listadoAdmi;
    }

    public Admi getAdmiMod() {
        return admMod;
    }

    public void setEmpMod(Admi admMod) {
        this.admMod = admMod;
    }
    

}
