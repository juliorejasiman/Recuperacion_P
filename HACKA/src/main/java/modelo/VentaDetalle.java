package modelo;

import java.sql.Date;

public class VentaDetalle {

    private Integer CODVEDE;
    private Integer CODVENT;
    private Integer CODPIZ;
    private String TOTVENT;
    private String CANPROVENT;
    private Date FECVEN;
    private String DNIADM;
    private String DNIJEF;
    private Integer CODSUC;
    private String DNIDES;
    private String DNICLI;
    private Integer CODDEST;
    private Producto producto = new Producto();
    private Cliente cliente = new Cliente();
    private Vendedor vendedor = new Vendedor();
    private Sucursal sucursal = new Sucursal();
    private Destino destino = new Destino();
    
    private String NOMPIZ;
    private Double PREPPIZ;
    private Integer STOPIZ;
    private String NOMCLI;
    private String LUGDES;

    public VentaDetalle(Integer codvede, Integer codvent, Integer codpiz, String totvent, String canprovent, Date fecven,
             String dniadm, String dnijef, Integer codsuc, String dnides, String dnicli, Integer coddest,
             Producto producto, Cliente cliente, Vendedor vendedor, String nompiz, Double prepiz, Integer stopiz
            , String nomcli, String lugdes, Sucursal sucursal ,Destino destino ) {
        this.CODVEDE = codvede;
        this.CODVENT = codvent;
        this.CODPIZ = codpiz;
        this.TOTVENT = totvent;
        this.CANPROVENT = canprovent;
        this.FECVEN = fecven;
        this.DNIADM = dniadm;
        this.DNIJEF = dnijef;
        this.CODSUC = codsuc;
        this.DNIDES = dnides;
        this.DNICLI = dnicli;
        this.CODDEST = coddest;
        this.producto = producto;
        this.destino = destino;
        
        this.cliente = cliente;
        this.vendedor = vendedor;
       
        this.NOMPIZ = nompiz;
        this.PREPPIZ = prepiz;
        this.STOPIZ = stopiz;
        this.NOMCLI = nomcli;
        this.LUGDES = lugdes;

    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public VentaDetalle() {
    }

    public Integer getCODVEDE() {
        return CODVEDE;
    }

    public void setCODVEDE(Integer CODVEDE) {
        this.CODVEDE = CODVEDE;
    }

    public Integer getCODVENT() {
        return CODVENT;
    }

    public void setCODVENT(Integer CODVENT) {
        this.CODVENT = CODVENT;
    }

    public Integer getCODPIZ() {
        return CODPIZ;
    }

    public void setCODPIZ(Integer CODPIZ) {
        this.CODPIZ = CODPIZ;
    }

    public String getTOTVENT() {
        return TOTVENT;
    }

    public void setTOTVENT(String TOTVENT) {
        this.TOTVENT = TOTVENT;
    }

    public String getCANPROVENT() {
        return CANPROVENT;
    }

    public void setCANPROVENT(String CANPROVENT) {
        this.CANPROVENT = CANPROVENT;
    }

    public Date getFECVEN() {
        return FECVEN;
    }

    public void setFECVEN(Date FECVEN) {
        this.FECVEN = FECVEN;
    }

    public String getDNIADM() {
        return DNIADM;
    }

    public void setDNIADM(String DNIADM) {
        this.DNIADM = DNIADM;
    }

    public String getDNIJEF() {
        return DNIJEF;
    }

    public void setDNIJEF(String DNIJEF) {
        this.DNIJEF = DNIJEF;
    }

    public Integer getCODSUC() {
        return CODSUC;
    }

    public void setCODSUC(Integer CODSUC) {
        this.CODSUC = CODSUC;
    }

    public String getDNIDES() {
        return DNIDES;
    }

    public void setDNIDES(String DNIDES) {
        this.DNIDES = DNIDES;
    }

    public String getDNICLI() {
        return DNICLI;
    }

    public void setDNICLI(String DNICLI) {
        this.DNICLI = DNICLI;
    }

    public Integer getCODDEST() {
        return CODDEST;
    }

    public void setCODDEST(Integer CODDEST) {
        this.CODDEST = CODDEST;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNOMPIZ() {
        return NOMPIZ;
    }

    public void setNOMPIZ(String NOMPIZ) {
        this.NOMPIZ = NOMPIZ;
    }

    public Double getPREPPIZ() {
        return PREPPIZ;
    }

    public void setPREPPIZ(Double PREPPIZ) {
        this.PREPPIZ = PREPPIZ;
    }

    public Integer getSTOPIZ() {
        return STOPIZ;
    }

    public void setSTOPIZ(Integer STOPIZ) {
        this.STOPIZ = STOPIZ;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getLUGDES() {
        return LUGDES;
    }

    public void setLUGDES(String LUGDES) {
        this.LUGDES = LUGDES;
    }

    public void getCODVEDE(int aInt) {
    }
}
