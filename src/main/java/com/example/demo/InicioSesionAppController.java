package com.example.demo;

import controller.ControladorGeneral;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import utils.AlertUtils;

import java.io.IOError;
import java.io.IOException;

public class InicioSesionAppController {
    private ControladorGeneral controladorGeneral=new ControladorGeneral();

    @FXML
    private PasswordField fieldContraseña;

    @FXML
    private TextField fieldUsuario;

    @FXML
    private Button ButtonIniciarSesion;

    private Stage stage;

    @FXML
    void iniciarSesion(ActionEvent event){
        String usuario = fieldUsuario.getText();
        String contraseña = fieldContraseña.getText();
        try {
            int tipoUsuario = controladorGeneral.comprobarTipoUsuario(usuario, contraseña);
            switch (tipoUsuario) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    AlertUtils.alertError("Error al Iniciar Sesión", "Iniciar Sesión", "El nombre de usuario o contraseña son incorrectos, revíselos y vuelva a intentarlo");
                    break;

            }
        }catch (Exception ex){
            ex.printStackTrace();
            AlertUtils.alertError("Error al Iniciar Sesión", "Iniciar Sesión", "Error al iniciar sesión, revise sus credenciales e inténtelo nuevamente");
        }
    }

    public void mostrarPantallaEstudiante() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/com.example.demo/PONER AQUI"));
        Parent root = loader.load();
        PantallaEstudianteController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(/*AQUI PONER LOS PARAMETROS PARA PASAR, stage, this*/);
        stage.show();
        this.stage.close();
    }

    public void setStage(Stage primaryStage){
        stage = primaryStage;
    }



}


