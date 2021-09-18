package model;

public class Administrativo {
    private String usuarioAdmin;
    private String contrasennaAdmin;
    private String nombreAdmin;
    private String carreraAdmin;
    private String correoAdmin;
    private long cedulaAdmin;
    private TipoGeneral tipo;

    public Administrativo(String usuarioAdmin, String contrasennaAdmin, String nombreAdmin, String carreraAdmin, String correoAdmin, long cedulaAdmin) {
        this.usuarioAdmin = usuarioAdmin;
        this.contrasennaAdmin = contrasennaAdmin;
        this.nombreAdmin = nombreAdmin;
        this.carreraAdmin = carreraAdmin;
        this.correoAdmin = correoAdmin;
        this.cedulaAdmin = cedulaAdmin;
        this.tipo = TipoGeneral.ADMINISTRATIVO;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }
    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }
    public String getContrasennaAdmin() {
        return contrasennaAdmin;
    }
    public void setContrasennaAdmin(String contrasennaAdmin) {
        this.contrasennaAdmin = contrasennaAdmin;
    }
    public String getNombreAdmin() {
        return nombreAdmin;
    }
    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }
    public String getCarreraAdmin() {
        return carreraAdmin;
    }
    public void setCarreraAdmin(String carreraAdmin) {
        this.carreraAdmin = carreraAdmin;
    }
    public String getCorreAdmin() {
        return correoAdmin;
    }
    public void setCorreAdmin(String correAdmin) {
        this.correoAdmin = correAdmin;
    }
    public long getCedulaAdmin() {
        return cedulaAdmin;
    }
    public void setCedulaAdmin(long cedulaAdmin) {
        this.cedulaAdmin = cedulaAdmin;
    }
}
