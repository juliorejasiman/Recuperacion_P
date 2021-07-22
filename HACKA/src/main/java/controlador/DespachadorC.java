package controlador;

import dao.DespachadorImpl;
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
import modelo.Despachador;

@Named(value = "DespachadorC")
@SessionScoped
@SuppressWarnings("serial")
public class DespachadorC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Despachador des;
    private Despachador desMod;
    private DespachadorImpl dao;
    private List<Despachador> listadoDespachador;
    public DespachadorC(){
        dao=new DespachadorImpl();
        listadoDespachador=new ArrayList<>();
        des =new Despachador();
    
        desMod = new Despachador();
        
       
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(des);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(desMod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Despachador des) throws Exception{
        try {            
            dao.eliminar(des);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }


    public void limpiar() {
        des = new Despachador();
    }

//    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoDespachador = dao.listarTodos();
            for (Despachador listadodes : listadoDespachador) {
                System.out.println(listadodes.getDNIDES());
                
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

    public Despachador getDes() {
        return des;
    }

    public void setDes(Despachador des) {
        this.des = des;
    }

    public DespachadorImpl getDao() {
        return dao;
    }

    public void setDao(DespachadorImpl dao) {
        this.dao = dao;
    }

    public List<Despachador> getListadoDespachador() {
        return listadoDespachador;
    }

    public void setListadoDespachador(List<Despachador> listadoDespachador) {
        this.listadoDespachador = listadoDespachador;
    }

    public Despachador getDesMod() {
        return desMod;
    }

    public void setDesMod(Despachador desMod) {
        this.desMod = desMod;
    }
    

}
