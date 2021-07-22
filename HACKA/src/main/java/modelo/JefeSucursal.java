package modelo;

public class JefeSucursal {
    
   private Integer DNIJEF;
    private String NOMJEF;
    private String APEJEF;
    private String CELJEF;

    public JefeSucursal(Integer dnijef, String nomjef, String apejef, String celjef ) {
     this.DNIJEF = dnijef;
        this.NOMJEF = nomjef;
        this.APEJEF = apejef;
        this.CELJEF = celjef;
    }

    public JefeSucursal() {
    }

    public Integer getDNIJEF() {
        return DNIJEF;
    }

    public void setDNIJEF(Integer DNIJEF) {
        this.DNIJEF = DNIJEF;
    }

    public String getNOMJEF() {
        return NOMJEF;
    }

    public void setNOMJEF(String NOMJEF) {
        this.NOMJEF = NOMJEF;
    }

    public String getAPEJEF() {
        return APEJEF;
    }

    public void setAPEJEF(String APEJEF) {
        this.APEJEF = APEJEF;
    }

    public String getCELJEF() {
        return CELJEF;
    }

    public void setCELJEF(String CELJEF) {
        this.CELJEF = CELJEF;
    }

}