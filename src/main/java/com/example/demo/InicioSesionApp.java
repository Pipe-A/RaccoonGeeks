package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioSesionApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InicioSesionApp.class.getResource("PantallaInicio.fxml"));
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();
            // Cargo el scene
            Scene scene = new Scene(ventana);
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        /*ControladorProfesor controlProfe = new ControladorProfesor();
        Profesor profeNuevo = new Profesor("prof1", "profe", "Juanito", "sistemas", "loquesea@puj", 12345L, TipoProfesor.DE_PLANTA);
        System.out.println("Registro: ");
        controlProfe.insertarProfesor(profeNuevo);
        System.out.println("Consulta 1: ");
        controlProfe.consultarProfesores();
        System.out.println("Modificar: ");
        controlProfe.modificarProfesoresBasico(profeNuevo, "profesor");
        System.out.println("Consulta 2: ");
        controlProfe.consultarProfesores();
        System.out.println("Eliminar: ");
        controlProfe.eliminarProfesor(profeNuevo);
        System.out.println("Consulta 3: ");
        controlProfe.consultarProfesores();*/
        launch(args);
    }
}