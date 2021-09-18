package model;
import java.util.*;


public class Curso {
    private UUID idCurso;
    private String nombreCurso;
    private Map < String, Profesor> profesoresCurso=new HashMap<>();
    private Map < String, Estudiante> estudiantesCurso=new HashMap<>();
    private Map < String, Monitor> listaMonitores = new HashMap<>();

    public void setProfesoresCurso(Map newProfesoresCurso){
        this.profesoresCurso=newProfesoresCurso;
    }

    public Map getProfesoresCurso(){
        return this.profesoresCurso;
    }

    public void setEstudiantesCurso(Map newEstudiantesCurso){
        this.estudiantesCurso=newEstudiantesCurso;
    }

    public Map getEstudiantesCurso(){
        return this.estudiantesCurso;
    }

    public Map<String, Monitor> getListaMonitores() {
        return listaMonitores;
    }

    public void setListaMonitores(Map<String, Monitor> listaMonitores) {
        this.listaMonitores = listaMonitores;
    }

    public void setIdCurso(UUID newIdCurso){
        this.idCurso=newIdCurso;
    }

    public UUID getIdCurso(){
        return this.idCurso;
    }

    public void setNombreCurso(String newIdCurso){
        this.nombreCurso=newIdCurso;
    }

    public String getNombreCurso(){
        return this.nombreCurso;
    }


}
