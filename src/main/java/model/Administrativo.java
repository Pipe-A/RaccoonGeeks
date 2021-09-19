package model;

import jakarta.xml.bind.annotation.XmlRootElement;


public class Administrativo extends Usuario {

    private String carreraAdmin;
    private String correoAdmin;
    private long cedulaAdmin;
    private TipoGeneral tipo;

    public Administrativo(String usuario, String contrasenna, String nombre, String correo, String carreraAdmin, String correoAdmin, long cedulaAdmin, TipoGeneral tipo) {
        super(usuario, contrasenna, nombre, correo);
        this.carreraAdmin = carreraAdmin;
        this.correoAdmin = correoAdmin;
        this.cedulaAdmin = cedulaAdmin;
        this.tipo = tipo;
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
