package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashMap;
import java.util.Map;
@XmlRootElement
public class Estudiante extends Usuario {
    private String carreraEstud;
    private Long documentoEstud;
    private TipoGeneral tipo;
    private HashMap<String, Curso> listaCursosEstudiante = new HashMap<>();

    public Estudiante(){}

    public Estudiante(String usuario, String contrasenna, String nombre, String correo) {
        super(usuario, contrasenna, nombre, correo);
    }

    public Estudiante(String usuario, String contrasenna, String nombre, String correo, String carreraEstud, Long documentoEstud, TipoGeneral tipo, HashMap<String, Curso> listaCursosEstudiante) {
        super(usuario, contrasenna, nombre, correo);
        this.carreraEstud = carreraEstud;
        this.documentoEstud = documentoEstud;
        this.tipo = tipo;
        this.listaCursosEstudiante = listaCursosEstudiante;
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
    public HashMap<String, Curso> getListaCursosEstudiante() {
        return listaCursosEstudiante;
    }
    public void setListaCursosEstudiante(HashMap<String, Curso> listaCursosEstudiante) {
        this.listaCursosEstudiante = listaCursosEstudiante;
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
