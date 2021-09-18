package model;

import java.util.HashMap;
import java.util.Map;

public class Estudiante {
    private String usuarioEstud;
    private String contrasennaEstud;
    private String nombreEstud;
    private String carreraEstud;
    private String correoEstud;
    private Long documentoEstud;
    private TipoGeneral tipo;

    private HashMap<String, Curso> listaCursosEstudiante = new HashMap<>();

    public Estudiante(){}

    public Estudiante(String usuarioEstud, String contrasennaEstud, String nombreEstud, String carreraEstud, String correoEstud, Long documentoEstud) {
        this.usuarioEstud = usuarioEstud;
        this.contrasennaEstud = contrasennaEstud;
        this.nombreEstud = nombreEstud;
        this.carreraEstud = carreraEstud;
        this.correoEstud = correoEstud;
        this.documentoEstud = documentoEstud;
        this.tipo = TipoGeneral.ESTUDIANTE;
    }

    public String getUsuarioEstud() {
        return usuarioEstud;
    }
    public void setUsuarioEstud(String usuarioEstud) {
        this.usuarioEstud = usuarioEstud;
    }
    public String getContrasennaEstud() {
        return contrasennaEstud;
    }
    public void setContrasennaEstud(String contrasennaEstud) {
        this.contrasennaEstud = contrasennaEstud;
    }
    public String getNombreEstud() {
        return nombreEstud;
    }
    public void setNombreEstud(String nombreEstud) {
        this.nombreEstud = nombreEstud;
    }
    public String getCarreraEstud() {
        return carreraEstud;
    }
    public void setCarreraEstud(String carreraEstud) {
        this.carreraEstud = carreraEstud;
    }
    public String getCorreoEstud() {
        return correoEstud;
    }
    public void setCorreoEstud(String correoEstud) {
        this.correoEstud = correoEstud;
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
                "|| Nombre Estudiante: '" + nombreEstud + '\'' +
                "|| Carrera Estudiante:'" + carreraEstud + '\'' +
                "|| Correo Estudiante:'" + correoEstud + '\'' +
                '}';
    }
}
