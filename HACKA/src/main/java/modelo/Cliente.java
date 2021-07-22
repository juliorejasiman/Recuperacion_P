package modelo;

public class Cliente {
    
    private Integer DNICLI;
    private String NOMCLI;
    private String APECLI;
    private String CELCLI;
    private String DIRCLI;
 

    public Cliente(Integer dnicli, String nomcli, String apecli, String celcli, String dircli) {
      
        this.DNICLI = dnicli;
        this.NOMCLI = nomcli;
        this.APECLI = apecli;
        this.CELCLI = celcli;
        this.DIRCLI = dircli;
    }

    public Cliente() {
    }


    public Integer getDNICLI() {
        return DNICLI;
    }

    public void setDNICLI(Integer DNICLI) {
        this.DNICLI = DNICLI;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getAPECLI() {
        return APECLI;
    }

    public void setAPECLI(String APECLI) {
        this.APECLI = APECLI;
    }

    public String getCELCLI() {
        return CELCLI;
    }

    public void setCELCLI(String CELCLI) {
        this.CELCLI = CELCLI;
    }

    public String getDIRCLI() {
        return DIRCLI;
    }

    public void setDIRCLI(String DIRCLI) {
        this.DIRCLI = DIRCLI;
    }

}