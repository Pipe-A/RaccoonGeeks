package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Administrativo extends Usuario {

    private String carreraAdmin;
    private long cedulaAdmin;
    private TipoGeneral tipo;

    public Administrativo() {
    }

    public Administrativo(String usuario, String contrasenna, String nombre, String correo, String carreraAdmin, long cedulaAdmin, TipoGeneral tipo) {
        super(usuario, contrasenna, nombre, correo);
        this.carreraAdmin = carreraAdmin;
        this.cedulaAdmin = cedulaAdmin;
        this.tipo = tipo;
    }

    public String getCarreraAdmin() {
        return carreraAdmin;
    }
    public void setCarreraAdmin(String carreraAdmin) {
        this.carreraAdmin = carreraAdmin;
    }
    public long getCedulaAdmin() {
        return cedulaAdmin;
    }
    public void setCedulaAdmin(long cedulaAdmin) {
        this.cedulaAdmin = cedulaAdmin;
    }
}
