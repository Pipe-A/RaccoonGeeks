package controller;
import model.Profesor;
import java.util.HashMap;
import java.util.Map;

public class ControladorProfesor {
    private Map<String, Profesor> listaProfes = new HashMap<>();
    public Map<String, Profesor> getListaProfes() {
        return listaProfes;
    }
    public void setListaProfes(Map<String, Profesor> listaProfes) {
        this.listaProfes = listaProfes;
    }

    // CRUD
    public Profesor buscarProfesor(String usuario){
        if(this.listaProfes.containsKey(usuario)){
            return this.listaProfes.get(usuario);
        }
        return null;
    }

    public void insertarProfesor(Profesor profesorNuevo){
        if (buscarProfesor(profesorNuevo.getUsuarioProfe()) == null) {
            this.listaProfes.put(profesorNuevo.getUsuarioProfe(), profesorNuevo);
            System.out.println("Profesor registrado con éxito!");
            System.out.println(profesorNuevo.toString());
        }
        else{
            System.out.println("Ya existe un profesor con este nombre de Usuario, inténtelo nuevamente!");
            //throw new ExcCliente("Ya existe un cliente con este número de cedula, inténtelo nuevamente!");
        }
    }

    public void consultarProfesores(){
        if(!this.listaProfes.isEmpty()) {
            for (Profesor profesor : this.listaProfes.values()) {
                System.out.println(profesor.toString());
            }
            return;
        }
        System.out.println("Actualmente no existen profesores, por favor registre al menos uno");
    }

    public void modificarProfesoresBasico(Profesor profesor, String nuevaContrasenna){
        if (buscarProfesor(profesor.getUsuarioProfe()) != null) {
            System.out.println("Profesor encontrado!");
            System.out.println(profesor.toString());
            profesor.setContrasennaProfe(nuevaContrasenna);
            System.out.println("Los datos actualizados del profesor son: ");
            System.out.println(profesor.toString());
        }
        else{
            System.out.println("El profesor no existe, intente nuevamente");
        }
    }

    public void eliminarProfesor(Profesor profesor){
        if (buscarProfesor(profesor.getUsuarioProfe()) != null) {
            System.out.println("Profesor encontrado!");
            System.out.println(profesor.toString());
            // this.listaClientes.remove(this.listaClientes.indexOf(cliente));
            this.listaProfes.remove(profesor.getUsuarioProfe());
            System.out.println("El profesor ha sido eliminado con exito! ");
        }
        else{
            System.out.println("El profesor no existe, intente nuevamente");
        }
    }


}
