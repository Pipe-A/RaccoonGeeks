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

public class PantallaAdminGestionCursoEstudiantesController {

    @FXML
    private Label usuarioEstu;

    @FXML
    private Label tipoEstu;

    @FXML
    private Label numIDEstu;

    @FXML
    private Label carreraEstu;

    @FXML
    private Label correoEstu;

    @FXML
    private Label nombreEstu;

    @FXML
    private Button btnAsignarEstACurso;

    @FXML
    private Button btnEliminarEstDeCurso;

    @FXML
    private Button btnBuscarEstuAAsignar;

    @FXML
    private Button btnRegresarCursoPrincipal;

    @FXML
    void asignarEstACurso(ActionEvent event) {

    }

    @FXML
    void buscarEstuAAsignar(ActionEvent event) {

    }

    @FXML
    void eliminarEstDeCurso(ActionEvent event) {

    }

    @FXML
    void regresarCursoPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaAdminGestionCurso.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) this.btnRegresarCursoPrincipal.getScene().getWindow();
        myStage.close();
    }

}
