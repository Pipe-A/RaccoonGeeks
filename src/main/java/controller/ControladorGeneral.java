package controller;

import model.*;
import model.reportes.ReportesEstudiantes;
import model.reportes.ReportesUsuarios;

import java.util.HashMap;
import java.util.Map;

public class ControladorGeneral {

    private Map<String, Usuario> usuarios = new HashMap<>();
    private ReportesUsuarios reportesUsuarios = new ReportesUsuarios();
    private ReportesEstudiantes reportesEstudiantes=new ReportesEstudiantes();
    ControladorProfesor controlProfe = new ControladorProfesor();
    private Map<String, Administrativo> listaAdministrador = new HashMap<>();
    ControladorEstudiante controlEstu = new ControladorEstudiante();
    ControlCursos controlCursos = new ControlCursos();

    public ReportesEstudiantes getReportesEstudiantes() {
        return reportesEstudiantes;
    }

    public void setReportesEstudiantes(ReportesEstudiantes reportesEstudiantes) {
        this.reportesEstudiantes = reportesEstudiantes;
    }

    public ControlCursos getControlCursos() {
        return controlCursos;
    }
    public Map<String, Administrativo> getListaAdministrador() {
        return listaAdministrador;
    }
    public void setControlCursos(ControlCursos controlCursos) {
        this.controlCursos = controlCursos;
    }
    public ControladorProfesor getControlProfe() {
        return controlProfe;
    }
    public ControladorEstudiante getControlEstu() {
        return controlEstu;
    }
    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
    public ReportesUsuarios getReportesUsuarios() {
        return reportesUsuarios;
    }
    public void setReportesUsuarios(ReportesUsuarios reportesUsuarios) {
        this.reportesUsuarios = reportesUsuarios;
    }

    public int comprobarTipoUsuario(String usuario, String contrasenna) {
        //Segun el tipo de retorno, se abre una pestaña u otra
        Usuario UsuarioEncontrado = this.buscarUsuario(usuario);
        if (UsuarioEncontrado.getUsuario().equals(usuario) && UsuarioEncontrado.getContrasenna().equals(contrasenna)) {
            if (UsuarioEncontrado instanceof Estudiante) {
                return 1;
            } else if (UsuarioEncontrado instanceof Profesor) {
                return 2;
            } else if (UsuarioEncontrado instanceof Administrativo) {
                return 3;
            }
            return 4;
        } else {
            System.out.println("No existe usuario");
            return 4;
        }
    }

    Usuario buscarUsuario(String usuario) {
        if (controlEstu.getListaEstudiantes().containsKey(usuario)) {
            return controlEstu.getListaEstudiantes().get(usuario);
        } else if (this.listaAdministrador.containsKey(usuario)) {
            return this.listaAdministrador.get(usuario);
        } else if (controlProfe.getListaProfes().containsKey(usuario)) {
            return controlProfe.getListaProfes().get(usuario);
        }
        return null;
    }

    public void guardarUsuario(Usuario user) {
        this.usuarios.put(user.getUsuario(), user);
        if (user instanceof Estudiante) {
            this.controlEstu.getListaEstudiantes().put(user.getUsuario(), (Estudiante) user);
        } else if (user instanceof Administrativo) {
            this.listaAdministrador.put(user.getUsuario(), (Administrativo) user);
        } else if (user instanceof Profesor) {
            this.controlProfe.getListaProfes().put(user.getUsuario(), (Profesor) user);
        }
    }

    public void setListaAdministrador(Map<String, Administrativo> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }

    public Administrativo buscarAdministradores(String usuario){
        if(this.listaAdministrador.containsKey(usuario)){
            return this.listaAdministrador.get(usuario);
        }
        return null;
    }

    public void insertarAdmin(Administrativo adminNuevo){
        if (buscarAdministradores(adminNuevo.getUsuario()) == null) {
            this.listaAdministrador.put(adminNuevo.getUsuario(), adminNuevo);
            System.out.println("Administrador registrado con éxito!");
            System.out.println(adminNuevo.toString());
        }
        else{
            System.out.println("Ya existe un administrador con este nombre de Usuario, inténtelo nuevamente!");
        }
    }

    public void consultarAdministradores(){
        if(!this.listaAdministrador.isEmpty()) {
            for (Administrativo admin : this.listaAdministrador.values()) {
                System.out.println(admin.toString());
            }
            return;
        }
        System.out.println("Actualmente no existen administradores, por favor registre al menos uno");
    }

    public void modificarAdminBasico(Administrativo admin, String nuevaContrasenna){
        if (buscarAdministradores(admin.getUsuario()) != null) {
            System.out.println("Administrador encontrado!");
            System.out.println(admin.toString());
            admin.setContrasenna(nuevaContrasenna);
            System.out.println("Los datos actualizados del administrador son: ");
            System.out.println(admin.toString());
        }
        else{
            System.out.println("El administrador no existe, intente nuevamente");
        }
    }

    public void eliminarAdministrador(Administrativo admin){
        if (buscarAdministradores(admin.getUsuario()) != null) {
            System.out.println("Administrador encontrado!");
            System.out.println(admin.toString());
            // this.listaClientes.remove(this.listaClientes.indexOf(cliente));
            this.listaAdministrador.remove(admin.getCarreraAdmin());
            System.out.println("El administrador ha sido eliminado con exito! ");
        }else{
            System.out.println("El administrador no existe, intente nuevamente");
        }
    }

    public void asignarEstudiante(Curso curso, Estudiante estudiante){
        Estudiante estEncontrado = controlEstu.buscarEstudiante(estudiante.getUsuario());
        Curso cursoEncontrado = controlCursos.buscarCurso(curso.getIdCurso());
        if(estEncontrado!=null && cursoEncontrado!=null){
            if(!cursoEncontrado.getEstudiantesPertenecenCurso().containsValue(estudiante)){
                cursoEncontrado.getEstudiantesPertenecenCurso().put(estEncontrado.getUsuario(), estEncontrado);
                estEncontrado.getCursosPertenecenAEstudiante().put(curso.getIdCurso().toString(), curso);
            }
        }
        System.out.println("Fin de asignar estudient");
        //si el estudiante existe, asignar (put) al curso
    }

    public void asingarProfesor(Curso curso, Profesor profesor){
        //si el profesor existe, asignar (put) al curso
        Profesor profEncontrado = controlProfe.buscarProfesor(profesor.getUsuario());
        Curso cursoEncontrado = controlCursos.buscarCurso(curso.getIdCurso());
        if(profEncontrado!=null && cursoEncontrado!=null){
            if(!cursoEncontrado.getEstudiantesPertenecenCurso().containsValue(profesor)){
                cursoEncontrado.getProfesoresPertenecenCurso().put(profesor.getUsuario(), profesor);
                profEncontrado.getCursosPertenecenAProfesor().put(curso.getIdCurso(), curso);
            }
        }
    }

    public void crearMonitorAPartirDeEstudiante(Estudiante estudiante){
        if(estudiante!= null){
            Monitor monitor= new Monitor(estudiante.getUsuario(),estudiante.getContrasenna(),estudiante.getNombre(),estudiante.getCorreo(), estudiante.getCarreraEstud(),estudiante.getDocumentoEstud(),TipoGeneral.ESTUDIANTE, estudiante.getCursosPertenecenAEstudiante());
            for(Curso curso: estudiante.getCursosPertenecenAEstudiante().values()){
                curso.getEstudiantesPertenecenCurso().replace(estudiante.getUsuario(),estudiante,monitor);
            }
            this.usuarios.replace(estudiante.getUsuario(),estudiante,monitor);
            this.controlEstu.getListaMonitores().put(monitor.getUsuario(),monitor);
        }else{
            System.out.println("ERROR: El estudiante es Nulo");
        }
    }

    public void asignarMonitor(Monitor monitor, Curso curso) {
        if(monitor!=null&&curso!=null){
            if(!curso.getEstudiantesPertenecenCurso().containsKey(monitor.getUsuario())){
                curso.getMonitoresCurso().put(monitor.getUsuario(),monitor);
            }
            else{
                System.out.println("ERROR: El monitor es estudiante del curso al que se quiere asignar");
            }
        }else{
            System.out.println("ERROR: El monitor o el curso son nulos");
        }
        //si el estudiante existe, darle el poder del profesor:v y asignar (put) al curso
    }

    public void removerRolDeMonitorAUnEstudiante(Monitor monitor){
        Estudiante estudiante=new Estudiante(monitor.getUsuario(),monitor.getContrasenna(), monitor.getNombre(), monitor.getCorreo(), monitor.getCarreraEstud(), monitor.getDocumentoEstud(),TipoGeneral.ESTUDIANTE, monitor.getCursosPertenecenAEstudiante());
        for(Curso curso: monitor.getCursosMonitor().values()){
            curso.getMonitoresCurso().remove(monitor);
        }
        for(Curso curso: monitor.getCursosPertenecenAEstudiante().values()){
            curso.getEstudiantesPertenecenCurso().replace(monitor.getUsuario(),monitor,estudiante);
        }
        this.usuarios.replace(estudiante.getUsuario(),monitor,estudiante);
        this.controlEstu.getListaMonitores().remove(monitor);
    }
    public void cargarCredenciales(){

    }

    public void crearUsuario(){

    }
}
