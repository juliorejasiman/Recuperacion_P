package controlador;

import dao.DestinoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Destino;

@Named(value = "DestinoC")
@SessionScoped
@SuppressWarnings("serial")
public class DestinoC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Destino dest;
    private DestinoImpl dao;
    private List<Destino> listadoDestino;
    
    public DestinoC(){
        dao=new DestinoImpl();
        listadoDestino=new ArrayList<>();
        dest =new Destino();
    }
    
    @SuppressWarnings("unchecked")
    public void listadoDestino() {
        try {
            listadoDestino = dao.listarTodos();
        
                
            
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    @PostConstruct
    public void construir() {
        listadoDestino();
    }

    public Destino getDest() {
        return dest;
    }

    public void setDest(Destino dest) {
        this.dest = dest;
    }

    public DestinoImpl getDao() {
        return dao;
    }

    public void setDao(DestinoImpl dao) {
        this.dao = dao;
    }

    public List<Destino> getListadoDestino() {
        return listadoDestino;
    }

    public void setListadoDestino(List<Destino> listadoDestino) {
        this.listadoDestino = listadoDestino;
    }

   
  
    
}