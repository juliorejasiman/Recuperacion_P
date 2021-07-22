package controlador;

import dao.ProductoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Producto;

@Named(value = "ProductoC")
@SessionScoped
@SuppressWarnings("serial")
public class ProductoC implements Serializable {

    // private static final long serialVersionUID = 1L;


    private Producto pro;
    private ProductoImpl dao;
    private List<Producto> listadoProductos;
    public ProductoC(){
        dao=new ProductoImpl();
        listadoProductos=new ArrayList<>();
        pro =new Producto();
    }
 public void registrar() throws Exception {
        try {
            dao.registrar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Producto pro) throws Exception{
        try {            
            dao.eliminar(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }


    public void limpiar() {
        pro = new Producto();
    }

//    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoProductos = dao.listarTodos();
            for (Producto listadopro : listadoProductos) {
                System.out.println(listadopro.getCODPIZ());
                
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
    public Producto getProducto() {
        return pro;
    }

    public void setProducto (Producto p) {
        this.pro = p;
    }

    public ProductoImpl getDao() {
        return dao;
    }

    public void setDao(ProductoImpl dao) {
        this.dao = dao;
    }

    public List<Producto> getListadoProd() {
        return listadoProductos;
    }

    public void setListadoProd (List<Producto> listaProductos) {
        this.listadoProductos = listaProductos;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public List<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

}
