package com.example.demo;

import javafx.stage.Stage;

public class PantallaEstudianteController {

    private InicioSesionAppController inicioSesionAppController;
    private Stage stage;

    public void init(String text, Stage stage, InicioSesionAppController inicioSesionAppController) {
        this.inicioSesionAppController = inicioSesionAppController;
        this.stage = stage;
    }
}
