package model;

import java.util.HashMap;

public class Profesor {
    private String usuarioProfe;
    private String contrasennaProfe;
    private String nombreProfe;
    private String carreraProfe;
    private String correoProfe;
    private Long cedulaProfe;
    private TipoProfesor tipoProfesor;
    private TipoGeneral tipo;

    private HashMap<String, Curso> listaCursosProfesor = new HashMap<>();

    public Profesor(String usuarioProfe, String contrasennaProfe, String nombreProfe, String carreraProfe, String correoProfe, Long cedulaProfe, TipoProfesor tipoProfesor) {
        this.usuarioProfe = usuarioProfe;
        this.contrasennaProfe = contrasennaProfe;
        this.nombreProfe = nombreProfe;
        this.carreraProfe = carreraProfe;
        this.correoProfe = correoProfe;
        this.cedulaProfe = cedulaProfe;
        this.tipoProfesor = tipoProfesor;
        this.tipo = TipoGeneral.PROFESOR;
    }

    public String getUsuarioProfe() {
        return usuarioProfe;
    }
    public void setUsuarioProfe(String usuarioProfe) {
        this.usuarioProfe = usuarioProfe;
    }
    public String getContrasennaProfe() {
        return contrasennaProfe;
    }
    public void setContrasennaProfe(String contrasennaProfe) {
        this.contrasennaProfe = contrasennaProfe;
    }
    public String getNombreProfe() {
        return nombreProfe;
    }
    public void setNombreProfe(String nombreProfe) {
        this.nombreProfe = nombreProfe;
    }
    public String getCarreraProfe() {
        return carreraProfe;
    }
    public void setCarreraProfe(String carreraProfe) {
        this.carreraProfe = carreraProfe;
    }
    public String getCorreoProfe() {
        return correoProfe;
    }
    public void setCorreoProfe(String correoProfe) {
        this.correoProfe = correoProfe;
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
        return "Profesor {" +
                "NombreProfe: '" + nombreProfe + '\'' +
                "Contraseña: '" + contrasennaProfe + '\'' +
                "|| CarreraProfe: '" + carreraProfe + '\'' +
                "|| CorreoProfe:'" + correoProfe + '\'' +
                "|| TipoProfesor: " + tipoProfesor +
                '}';
    }

}
