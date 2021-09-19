package controller;

import javafx.beans.property.ReadOnlyProperty;
import model.*;

import java.util.HashMap;
import java.util.Map;

public class ControladorGeneral {
    private Map<String, Usuario> usuarios=new HashMap<>();
    private ReportesUsuarios reportesUsuarios=new ReportesUsuarios();
    ControladorAdministrativo controlAdmin = new ControladorAdministrativo();
    ControladorProfesor controlProfe = new ControladorProfesor();
    ControladorEstudiante controlEstu = new ControladorEstudiante();
    ControlCursos controlCursos = new ControlCursos();

    public ControladorProfesor getControlProfe() {
        return controlProfe;
    }
    public ControladorEstudiante getControlEstu() {
        return controlEstu;
    }
    public ControladorAdministrativo getControlAdmin() { return controlAdmin; }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public ReportesUsuarios getReportesUsuarios() {
        return reportesUsuarios;
    }

    public void setReportesUsuarios(ReportesUsuarios reportesUsuarios) {
        this.reportesUsuarios = reportesUsuarios;
    }

    public int comprobarTipoUsuario(String usuario, String contrasenna){
        //Segun el tipo de retorno, se abre una pestaña u otra
        Usuario UsuarioEncontrado = this.buscarUsuario(usuario);
        if(UsuarioEncontrado.getUsuario().equals(usuario) && UsuarioEncontrado.getContrasenna().equals(contrasenna)){
            if(UsuarioEncontrado instanceof Estudiante){
                return 1;
            }else if(UsuarioEncontrado instanceof Profesor){
                return 2;
            }else if(UsuarioEncontrado instanceof  Administrativo){
                return 3;
            }
            return 4;
        } else{
            System.out.println("No existe usuario");
            return 4;
        }
    }

    Usuario buscarUsuario(String usuario){
        if(controlEstu.getListaEstudiantes().containsKey(usuario)){
            return controlEstu.getListaEstudiantes().get(usuario);
        }else if(controlAdmin.getListaAdministrador().containsKey(usuario)){
            return controlAdmin.getListaAdministrador().get(usuario);
        }else if(controlProfe.getListaProfes().containsKey(usuario)){
            return controlProfe.getListaProfes().get(usuario);
        }
        return null;
    }

    public void guardarUsuario(Usuario user){
        this.usuarios.put(user.getUsuario(),user);
        if(user instanceof Estudiante){
            this.controlEstu.getListaEstudiantes().put(user.getUsuario(),(Estudiante) user);
        }else if(user instanceof Administrativo){
            this.controlAdmin.getListaAdministrador().put(user.getUsuario(), (Administrativo) user);
        }else if(user instanceof Profesor){
            this.controlProfe.getListaProfes().put(user.getUsuario(),(Profesor) user);
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
