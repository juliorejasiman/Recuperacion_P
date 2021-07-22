package modelo;

public class Vendedor{
    
    
   
    private Integer DNIVEN;
    private String NOMVEN;
    private String APEVEN;
    private Integer CELVEN;
   
    public Vendedor(Integer dniven, String nomven ,String apeven, Integer celven) {
          
        this.DNIVEN = dniven;
        this.NOMVEN = nomven;
        this.APEVEN = apeven;
        this.CELVEN = celven;
           
    }

    public Vendedor() {
    }

    public Integer getDNIVEN() {
        return DNIVEN;
    }

    public void setDNIVEN(Integer DNIVEN) {
        this.DNIVEN = DNIVEN;
    }

    public String getNOMVEN() {
        return NOMVEN;
    }

    public void setNOMVEN(String NOMVEN) {
        this.NOMVEN = NOMVEN;
    }

    public String getAPEVEN() {
        return APEVEN;
    }

    public void setAPEVEN(String APEVEN) {
        this.APEVEN = APEVEN;
    }

    public Integer getCELVEN() {
        return CELVEN;
    }

    public void setCELVEN(Integer CELVEN) {
        this.CELVEN = CELVEN;
    }

  
 
 }
