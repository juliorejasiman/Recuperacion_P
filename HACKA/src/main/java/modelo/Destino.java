package modelo;

public class Destino {
    
  private Integer CODDEST;
    private String DIRDES;
            
    public Destino(Integer coddest , String dirdes ) {
        
        this.CODDEST = coddest;
        this.DIRDES = dirdes;
    }

    public Destino() {
    }

    public Integer getCODDEST() {
        return CODDEST;
    }

    public void setCODDEST(Integer CODDEST) {
        this.CODDEST = CODDEST;
    }

    public String getDIRDES() {
        return DIRDES;
    }

    public void setDIRDES(String DIRDES) {
        this.DIRDES = DIRDES;
    }
    

}