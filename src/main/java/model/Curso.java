package model;
import java.util.*;


public class Curso {
    private UUID idCurso;
    private String nombreCurso;
    private Map <String, Profesor> profesoresPertenecenCurso =new HashMap<>();
    private Map <String, Estudiante> estudiantesPertenecenCurso =new HashMap<>();

    public Curso(String nombreCurso, Map<String, Profesor> profesoresCurso, Map<String, Estudiante> estudiantesCurso){
        this.idCurso = UUID.randomUUID();
        this.nombreCurso = nombreCurso;
        this.profesoresPertenecenCurso = profesoresCurso;
        this.estudiantesPertenecenCurso = estudiantesCurso;
    }

    //private Map <String, Monitor> listaMonitores = new HashMap<>();

    public void setProfesoresPertenecenCurso(Map newProfesoresCurso){
        this.profesoresPertenecenCurso =newProfesoresCurso;
    }

    public Map getProfesoresPertenecenCurso(){
        return this.profesoresPertenecenCurso;
    }

    public void setEstudiantesPertenecenCurso(Map newEstudiantesCurso){
        this.estudiantesPertenecenCurso =newEstudiantesCurso;
    }

    public Map getEstudiantesPertenecenCurso(){
        return this.estudiantesPertenecenCurso;
    }

    /*public Map<String, Monitor> getListaMonitores() {
        return listaMonitores;
    }

    public void setListaMonitores(Map<String, Monitor> listaMonitores) {
        this.listaMonitores = listaMonitores;
    }*/

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

    @Override
    public String toString() {
        return "Curso {" +
                "|| Nombre Curso: '" + this.getNombreCurso() + '\'' +
                "|| Estudiantes curso:'" + this.getEstudiantesPertenecenCurso() + '\'' +
                "|| Profesores curso:'" + this.getProfesoresPertenecenCurso() + '\'' +
                '}';
    }


}
