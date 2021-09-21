package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaPrincipalAdminController {

    @FXML
    private Button btnGestionarProfe;

    @FXML
    private Button btnGestionarCurso;

    @FXML
    private Button btnGestionarAdmin;

    @FXML
    private Button btnGestionarEst;

    @FXML
    void gestionCurso(ActionEvent event) {

    }

    @FXML
    void gestionarAdmin(ActionEvent event) {

    }

    @FXML
    void gestionarEst(ActionEvent event) {

    }

    @FXML
    void gestionarProfe(ActionEvent event) {

    }

    public void closeWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaInicio.fxml"));
        Parent root = loader.load();
        InicioSesionAppController controlPantPrincController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) this.btnGestionarProfe.getScene().getWindow();
        myStage.close();
    }

}

