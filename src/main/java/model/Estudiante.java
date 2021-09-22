package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Estudiante extends Usuario {
    private String carreraEstud;
    private Long documentoEstud;
    private TipoGeneral tipo;
    private Map<String, Curso> cursosPertenecenAEstudiante = new HashMap<>();

    public Estudiante(){}
    public Estudiante(String usuario, String contrasenna, String nombre, String correo, String carreraEstud, Long documentoEstud, TipoGeneral tipo, Map<String, Curso> listaCursosEstudiante) {
        super(usuario, contrasenna, nombre, correo);
        this.carreraEstud = carreraEstud;
        this.documentoEstud = documentoEstud;
        this.tipo = tipo;
        this.cursosPertenecenAEstudiante = listaCursosEstudiante;
    }

    public String getCarreraEstud() {
        return carreraEstud;
    }

    public void setCarreraEstud(String carreraEstud) {
        this.carreraEstud = carreraEstud;
    }

    public Long getDocumentoEstud() {
        return documentoEstud;
    }
    public void setDocumentoEstud(Long documentoEstud) {
        this.documentoEstud = documentoEstud;
    }
    public Map<String, Curso> getCursosPertenecenAEstudiante() {
        return cursosPertenecenAEstudiante;
    }
    public void setCursosPertenecenAEstudiante(HashMap<String, Curso> cursosPertenecenAEstudiante) {
        this.cursosPertenecenAEstudiante = cursosPertenecenAEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante {" +
                "|| Nombre Estudiante: '" + super.getNombre() + '\'' +
                "|| Carrera Estudiante:'" + carreraEstud + '\'' +
                "|| Correo Estudiante:'" + super.getCorreo() + '\'' +
                '}';
    }
}
