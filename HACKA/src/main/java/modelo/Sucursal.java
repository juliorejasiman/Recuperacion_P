package modelo;

public class Sucursal {
    
   private Integer CODSUC;
    private String LUGSUC;

    public Sucursal(Integer codsuc, String lugsuc ) {
       this.CODSUC = codsuc;
        this.LUGSUC = lugsuc;
    }

    public Sucursal() {
    }

    public Integer getCODSUC() {
        return CODSUC;
    }

    public void setCODSUC(Integer CODSUC) {
        this.CODSUC = CODSUC;
    }

    public String getLUGSUC() {
        return LUGSUC;
    }

    public void setLUGSUC(String LUGSUC) {
        this.LUGSUC = LUGSUC;
    }

    public void setCODSUC(Sucursal suc) {
    }

    

}