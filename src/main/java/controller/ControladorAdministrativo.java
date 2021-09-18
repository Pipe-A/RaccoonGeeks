package controller;

import model.Administrativo;
import model.Profesor;

import java.util.HashMap;
import java.util.Map;

public class ControladorAdministrativo {
    private Map<String, Administrativo> listaAdministrador = new HashMap<>();
    public Map<String, Administrativo> getListaAdministrador() {
        return listaAdministrador;
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
        if (buscarAdministradores(adminNuevo.getUsuarioAdmin()) == null) {
            this.listaAdministrador.put(adminNuevo.getUsuarioAdmin(), adminNuevo);
            System.out.println("Profesor registrado con éxito!");
            System.out.println(adminNuevo.toString());
        }
        else{
            System.out.println("Ya existe un administrador con este nombre de Usuario, inténtelo nuevamente!");
            //throw new ExcCliente("Ya existe un cliente con este número de cedula, inténtelo nuevamente!");
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
        if (buscarAdministradores(admin.getUsuarioAdmin()) != null) {
            System.out.println("Administrador encontrado!");
            System.out.println(admin.toString());
            admin.setContrasennaAdmin(nuevaContrasenna);
            System.out.println("Los datos actualizados del administrador son: ");
            System.out.println(admin.toString());
        }
        else{
            System.out.println("El administrador no existe, intente nuevamente");
        }
    }

    public void eliminarAdministrador(Administrativo admin){
        if (buscarAdministradores(admin.getUsuarioAdmin()) != null) {
            System.out.println("Profesor encontrado!");
            System.out.println(admin.toString());
            // this.listaClientes.remove(this.listaClientes.indexOf(cliente));
            this.listaAdministrador.remove(admin.getCarreraAdmin());
            System.out.println("El administrador ha sido eliminado con exito! ");
        }
        else{
            System.out.println("El administrador no existe, intente nuevamente");
        }
    }
}
