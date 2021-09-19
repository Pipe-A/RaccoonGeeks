package model;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashMap;

public class Profesor extends Usuario {
    private String carreraProfe;
    private Long cedulaProfe;
    private TipoProfesor tipoProfesor;
    private TipoGeneral tipo;

    private HashMap<String, Curso> listaCursosProfesor = new HashMap<>();

    public Profesor(String usuarioProfe, String contrasennaProfe, String nombreProfe, String carreraProfe, String correoProfe, Long cedulaProfe, TipoProfesor tipoProfesor) {
        this.carreraProfe = carreraProfe;
        super.setCorreo(correoProfe);
        super.setContrasenna(contrasennaProfe);
        super.setNombre(nombreProfe);
        super.setUsuario(usuarioProfe);
        this.cedulaProfe = cedulaProfe;
        this.tipoProfesor = tipoProfesor;
        this.tipo = TipoGeneral.PROFESOR;
    }

    public Long getCedulaProfe() {
        return cedulaProfe;
    }
    public void setCedulaProfe(Long cedulaProfe) {
        this.cedulaProfe = cedulaProfe;
    }
    public TipoProfesor getTipoProfesor() {
        return tipoProfesor;
    }
    public void setTipoProfesor(TipoProfesor tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }
    public TipoGeneral getTipo() { return tipo; }
    public void setTipo(TipoGeneral tipo) { this.tipo = tipo; }
    public HashMap<String, Curso> getListaCursosProfesor() {
        return listaCursosProfesor;
    }
    public void setListaCursosProfesor(HashMap<String, Curso> listaCursosProfesor) {
        this.listaCursosProfesor = listaCursosProfesor;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombreProfe='" + super.getNombre() + '\'' +
                "CorreoProfe='" + super.getCorreo() + '\'' +
                "UsuarioProfe='" + super.getUsuario() + '\'' +
                "contraseñaProfe='" + super.getContrasenna() + '\'' +
                "carreraProfe='" + carreraProfe + '\'' +
                ", cedulaProfe=" + cedulaProfe +
                ", tipoProfesor=" + tipoProfesor +
                ", tipo=" + tipo +
                ", listaCursosProfesor=" + listaCursosProfesor +
                '}';
    }
}
