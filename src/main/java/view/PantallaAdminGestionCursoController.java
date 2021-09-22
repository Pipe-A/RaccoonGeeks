package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaAdminGestionCursoController {

    @FXML
    private Label IDCurso;

    @FXML
    private Label nombreCurso;

    @FXML
    private Button btnRegistrarCurso;

    @FXML
    private Button btnActualizarCurso;

    @FXML
    private Button btnEliminarCurso;

    @FXML
    private Button btnEstuDelCurso;

    @FXML
    private Button btnMonitoresDelCuso;

    @FXML
    private Button btnProfesDelCurso;

    @FXML
    private Button btnRegresarMenuAdmin;

    @FXML
    void RegistrarCurso(ActionEvent event) {

    }

    @FXML
    void actualizarCurso(ActionEvent event) {

    }

    @FXML
    void eliminarCurso(ActionEvent event) {

    }

    @FXML
    void estuDelCurso(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaAdminGestionCursoEstudiantes.fxml"));
        Parent root = loader.load();
        PantallaAdminGestionCursoEstudiantesController pantallaAdminGestionCursoEstudiantesController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> {
            try {
                pantallaAdminGestionCursoEstudiantesController.regresarCursoPrincipal(event);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Stage myStage = (Stage) this.btnEstuDelCurso .getScene().getWindow();
        myStage.close();
    }

    @FXML
    void monitoresDelCurso(ActionEvent event) {

    }

    @FXML
    void profesDelCurso(ActionEvent event) {

    }

    @FXML
    void regresarMenuAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipalAdmin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) this.btnRegresarMenuAdmin.getScene().getWindow();
        myStage.close();
    }

}
