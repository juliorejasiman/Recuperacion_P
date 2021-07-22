package modelo;

public class Despachador {
    
  private Integer DNIDES;
    private String NOMDES;
    private String APEDES;
    private Integer CELDES;  

    public Despachador(Integer dnides, String nomdes, String apedes, Integer celdes ) {
      this.DNIDES = dnides;
      this.NOMDES = nomdes;
      this.APEDES = apedes;
      this.CELDES = celdes;
    }

    public Despachador() {
    }

    public Integer getDNIDES() {
        return DNIDES;
    }

    public void setDNIDES(Integer DNIDES) {
        this.DNIDES = DNIDES;
    }

    public String getNOMDES() {
        return NOMDES;
    }

    public void setNOMDES(String NOMDES) {
        this.NOMDES = NOMDES;
    }

    public String getAPEDES() {
        return APEDES;
    }

    public void setAPEDES(String APEDES) {
        this.APEDES = APEDES;
    }

    public Integer getCELDES() {
        return CELDES;
    }

    public void setCELDES(Integer CELDES) {
        this.CELDES = CELDES;
    }
    

}