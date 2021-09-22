package view;

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
    private Button btnCerrarSesionAdmin;


    @FXML
    void gestionCurso(ActionEvent event) {

    }

    @FXML
    void gestionarAdmin(ActionEvent event) {

    }

    @FXML
    void gestionarEst(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaAdminGestionEstudiante.fxml"));
        Parent root = loader.load();
        PantallaAdminGestionEstudianteController pantallaEstudianteController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> {
            try {
                pantallaEstudianteController.regresarMenuAdmin(event);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Stage myStage = (Stage) this.btnGestionarEst.getScene().getWindow();
        myStage.close();
    }

    @FXML
    void gestionarProfe(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaAdminGestionProfesor.fxml"));
        Parent root = loader.load();
        PantallaAdminGestionProfesorController pantallaAdminGestionProfesorController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> {
            try {
                pantallaAdminGestionProfesorController.regresarMenuAdmin(event);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Stage myStage = (Stage) this.btnGestionarProfe.getScene().getWindow();
        myStage.close();
    }


    @FXML
    void cerrarSesionAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaInicio.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) this.btnCerrarSesionAdmin.getScene().getWindow();
        myStage.close();
    }


}
