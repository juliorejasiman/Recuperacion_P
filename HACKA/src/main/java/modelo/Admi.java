package modelo;

public class Admi {
    
   private Integer DNIADM;
    private String NOMADM;
    private String APEADM;
    private String CELADM;
 

    public Admi(Integer dniadm, String nomadm, String apeadm, String celadm) {
      
        this.DNIADM = dniadm;
        this.NOMADM = nomadm;
        this.APEADM = apeadm;
        this.CELADM = celadm;
    }

    public Admi() {
    }

    public Integer getDNIADM() {
        return DNIADM;
    }

    public void setDNIADM(Integer DNIADM) {
        this.DNIADM = DNIADM;
    }

    public String getNOMADM() {
        return NOMADM;
    }

    public void setNOMADM(String NOMADM) {
        this.NOMADM = NOMADM;
    }

    public String getAPEADM() {
        return APEADM;
    }

    public void setAPEADM(String APEADM) {
        this.APEADM = APEADM;
    }

    public String getCELADM() {
        return CELADM;
    }

    public void setCELADM(String CELADM) {
        this.CELADM = CELADM;
    }

    
}