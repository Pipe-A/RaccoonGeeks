package controller;
import model.Curso;
import model.Estudiante;

import model.Profesor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ControlCursos {
    /* private Map <String, Profesor> profesoresCurso=new HashMap<>();
     private Map <String, Estudiante> estudiantesCurso=new HashMap<>();
     private Map <String, Monitor> listaMonitores = new HashMap<>();*/
    private Map<UUID, Curso> listaCursos = new HashMap<>();

    public Map<UUID, Curso> getListaCursos() {
        return listaCursos;
    }
    public void setListaCursos(Map<UUID, Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
/*
    public Map<String, Profesor> getProfesoresCurso() {return profesoresCurso;}
    public void setProfesoresCurso(Map<String, Profesor> profesoresCurso) {this.profesoresCurso = profesoresCurso;}
    public Map<String, Estudiante> getEstudiantesCurso() {return estudiantesCurso;}
    public void setEstudiantesCurso(Map<String, Estudiante> estudiantesCurso) {this.estudiantesCurso = estudiantesCurso;}
    public Map<String, Monitor> getListaMonitores() {return listaMonitores;}
    public void setListaMonitores(Map<String, Monitor> listaMonitores) {this.listaMonitores = listaMonitores;}*/

    public Curso buscarCurso(UUID id){
        if(this.listaCursos.containsKey(id)){
            return this.listaCursos.get(id);
        }
        return null;
    }

    public void insertarCurso(Curso nuevoCurso){
        if (buscarCurso(nuevoCurso.getIdCurso()) == null) {
            this.listaCursos.put(nuevoCurso.getIdCurso(), nuevoCurso);
            System.out.println("El curso se agrego con exito.");
            System.out.println(nuevoCurso.toString());
        }
        else{
            System.out.println("Ese curso ya existe. No puede agregar un curso existente.");
        }
    }

    public void consultarCurso(){
        if(!this.listaCursos.isEmpty()) {
            for (Curso cur : this.listaCursos.values()) {
                System.out.println(cur.toString());
            }
            return;
        }
        System.out.println("En este momento no hay ningun curso registrado");
    }

    public void modificarCurso(Curso curso, String nuevoNombre){
        if (buscarCurso(curso.getIdCurso()) != null) {
            curso.setNombreCurso(nuevoNombre);
        }else{
            System.out.println("El curso ingresado no existe. Por favor, intentelo de nuevo.");
        }
    }

    public void eliminarCurso(Curso curso){
        if (buscarCurso(curso.getIdCurso()) != null) {
            System.out.println("El curso se encontro con exito!");
            System.out.println(curso.toString());
            this.listaCursos.remove(curso.getIdCurso());
            System.out.println("El curso se ha eliminado con exito! ");
        }
        else{
            System.out.println("El curso no existe. Por favor, ingreselo de nuevo.");
        }
    }
}
