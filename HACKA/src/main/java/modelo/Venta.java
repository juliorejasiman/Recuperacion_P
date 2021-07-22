package modelo;

public class Venta {

    private Integer CODVEDE;
    private Integer CODVENT;
    private Integer CODPIZ;
 

    public Venta(Integer codvede, Integer codvent, Integer codpiz) {
        this.CODVEDE = codvede;
        this.CODVENT = codvent;
        this.CODPIZ = codpiz;
    }

    public Venta() {
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

}
