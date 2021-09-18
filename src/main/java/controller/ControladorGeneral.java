package controller;

import model.Administrativo;
import model.Estudiante;
import model.Profesor;

import java.util.Map;

public class ControladorGeneral {
    ControladorAdministrativo controlAdmin = new ControladorAdministrativo();
    ControladorProfesor controlProfe = new ControladorProfesor();
    ControladorEstudiante controlEstu = new ControladorEstudiante();
    //Map<,Curso> listaCursos = new Map();

    public ControladorProfesor getControlProfe() {
        return controlProfe;
    }
    public ControladorEstudiante getControlEstu() {
        return controlEstu;
    }
    public ControladorAdministrativo getControlAdmin() { return controlAdmin; }

    public int comprobarTipoUsuario(String usuario, String contrasenna){
        //Segun el tipo de retorno, se abre una pestaña u otra
        Estudiante estudianteEncontrado = this.controlEstu.buscarEstudiante(usuario);
        Profesor profesorEncontrado = this.controlProfe.buscarProfesor(usuario);
        Administrativo administrativoEncontrado = this.controlAdmin.buscarAdministradores(usuario);
        if(estudianteEncontrado.getUsuarioEstud().equals(usuario) && estudianteEncontrado.getContrasennaEstud().equals(contrasenna)){
            return 1;
        } else if(profesorEncontrado.getUsuarioProfe().equals(usuario) && profesorEncontrado.getContrasennaProfe().equals(contrasenna)){
            return 2;
        } else if(administrativoEncontrado.getUsuarioAdmin().equals(usuario) && administrativoEncontrado.getContrasennaAdmin().equals(contrasenna)){
            return 3;
        }
        else{
            System.out.println("No existe usuario");
            return 4;
        }

    }

    public void asignarEstudiante(Estudiante estudiante){
        //si el estudiante existe, asignar (put) al curso
    }

    public void asingarProfesor(Profesor profesor){
        //si el profesor existe, asignar (put) al curso
    }

    public void asignarMonitor(Profesor monitor){
        //si el estudiante existe, darle el poder del profesor:v y asignar (put) al curso
    }

    public void cargarCredenciales(){

    }

    public void crearUsuario(){

    }
}
