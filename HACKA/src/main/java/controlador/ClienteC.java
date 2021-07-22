package controlador;

import dao.ClienteImpl;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import modelo.Cliente;

@Named(value = "ClienteC")
@SessionScoped
public class ClienteC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Cliente cli;
    private ClienteImpl dao;
    private List<Cliente> listadoCliente;
    public ClienteC(){
        dao=new ClienteImpl();
        listadoCliente=new ArrayList<>();
        cli =new Cliente();
    
        cli = new Cliente();
        
       
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Cliente cli) throws Exception{
        try {            
            dao.eliminar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }


    public void limpiar() {
        cli = new Cliente();
    }

//    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoCliente = dao.listarTodos();
            for (Iterator<Cliente> it = listadoCliente.iterator(); it.hasNext();) {
                Cliente listadocli = it.next();
                System.out.println(listadocli.getDNICLI());
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

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListadoCliente() {
        return listadoCliente;
    }

    public void setListadoCliente(List<Cliente> listadoCliente) {
        this.listadoCliente = listadoCliente;
    }

    public Cliente getCliMod() {
        return cli;
    }

    public void setCliMod(Cliente cliMod) {
        this.cli = cliMod;
    }
    

}
