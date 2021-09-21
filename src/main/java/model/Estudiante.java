package model;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashMap;

@XmlRootElement
public class Estudiante extends Usuario {
    private String carreraEstud;
    private Long documentoEstud;
    private TipoGeneral tipo;
    private HashMap<String, Curso> cursosPertenecenAEstudiante = new HashMap<>();

    public Estudiante(String usuario, String contrasenna, String nombre, String correo, String carreraEstud, Long documentoEstud, TipoGeneral tipo, HashMap<String, Curso> listaCursosProfesor) {
        super(usuario, contrasenna, nombre, correo);
        this.carreraEstud = carreraEstud;
        this.documentoEstud = documentoEstud;
        this.tipo = tipo;
        this.cursosPertenecenAEstudiante = listaCursosProfesor;
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
    public HashMap<String, Curso> getCursosPertenecenAEstudiante() {
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
