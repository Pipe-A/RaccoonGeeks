package model;

import java.util.HashMap;

public class Profesor extends Usuario {

    private String carreraProfe;
    private Long cedulaProfe;
    private TipoProfesor tipoProfesor;
    private TipoGeneral tipo;
    private HashMap<String, Curso> cursosPertenecenAProfesor = new HashMap<>();

    public Profesor(String usuario, String contrasenna, String nombre, String correo, String carreraProfe, Long cedulaProfe, TipoProfesor tipoProfesor, TipoGeneral tipo, HashMap<String, Curso> listaCursosProfesor) {
        super(usuario, contrasenna, nombre, correo);
        this.carreraProfe = carreraProfe;
        this.cedulaProfe = cedulaProfe;
        this.tipoProfesor = tipoProfesor;
        this.tipo = tipo;
        this.cursosPertenecenAProfesor = listaCursosProfesor;
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
    public HashMap<String, Curso> getCursosPertenecenAProfesor() {
        return cursosPertenecenAProfesor;
    }
    public void setCursosPertenecenAProfesor(HashMap<String, Curso> cursosPertenecenAProfesor) {
        this.cursosPertenecenAProfesor = cursosPertenecenAProfesor;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombreProfe='" + super.getNombre() + '\'' +
                "CorreoProfe='" + super.getCorreo() + '\'' +
                ", listaCursosProfesor=" + this.getCursosPertenecenAProfesor() +
                '}';
    }
}
