package controller;

import model.Estudiante;

import java.util.HashMap;
import java.util.Map;

public class ControladorEstudiante {
    private Map<String, Estudiante> listaEstudiantes = new HashMap<>();
    public Map<String, Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void setListaEstudiantes(Map<String, Estudiante> listaEstudiantes) { this.listaEstudiantes = listaEstudiantes; }

    // CRUD
    public Estudiante buscarEstudiante(String usuario){
        if(this.listaEstudiantes.containsKey(usuario)){
            return this.listaEstudiantes.get(usuario);
        }
        return null;
    }

    public void insertarEstudiante(Estudiante nuevoEstudiante){
        if (buscarEstudiante(nuevoEstudiante.getUsuarioEstud()) == null) {
            this.listaEstudiantes.put(nuevoEstudiante.getUsuarioEstud(), nuevoEstudiante);
            System.out.println("Cliente registrado con éxito!");
            System.out.println(nuevoEstudiante.toString());
        }
        else{
            System.out.println("Ya existe un estudiante con este nombre de Usuario, inténtelo nuevamente!");
            //throw new ExcCliente("Ya existe un cliente con este número de cedula, inténtelo nuevamente!");
        }
    }

    public void consultarEstudiantes(){
        if(!this.listaEstudiantes.isEmpty()) {
            for (Estudiante estudiante : this.listaEstudiantes.values()) {
                System.out.println(estudiante.toString());
            }
            return;
        }
        System.out.println("Actualmente no existen estudiantes, por favor registre al menos uno");
    }

    public void modificarEstudianteBasico(Estudiante estudiante, String nuevaContrasenna, String nuevoNombre, String nuevaCarrera){
        if (buscarEstudiante(estudiante.getUsuarioEstud()) != null) {
            estudiante.setContrasennaEstud(nuevaContrasenna);
            estudiante.setNombreEstud(nuevoNombre);
            estudiante.setCarreraEstud(nuevaCarrera);
            System.out.println("Los datos actualizados del profesor son: ");
            System.out.println(estudiante.toString());
        }
        else{
            System.out.println("El estudiante no existe, intente nuevamente");
        }
    }

    public void eliminarEstudiante(Estudiante estudiante){
        if (buscarEstudiante(estudiante.getUsuarioEstud()) != null) {
            System.out.println("Estudiante encontrado! ");
            System.out.println(estudiante.toString());
            // this.listaClientes.remove(this.listaClientes.indexOf(cliente));
            this.listaEstudiantes.remove(estudiante.getUsuarioEstud());
            System.out.println("El estudiante ha sido eliminado con exito! ");
        }
        else{
            System.out.println("El estudiante no existe, intente nuevamente");
        }
    }
}
