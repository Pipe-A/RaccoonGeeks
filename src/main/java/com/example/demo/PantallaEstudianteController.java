package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PantallaEstudianteController {

    private InicioSesionAppController inicioSesionAppController;
    private Stage stage;

    @FXML
    private Label text_NombreUsuario;

    @FXML
    private Button btn_CerrarSesionEstudiante;

    @FXML
    private Tab tab_Actividades;

    @FXML
    private TableView<?> tableView_Actividades;

    @FXML
    private TableColumn<?, ?> col_Actividad;

    @FXML
    private TableColumn<?, ?> col_FechaEntregaACT;

    @FXML
    private Tab tab_Actividades1;

    @FXML
    private TableView<?> tableView_Examenes;

    @FXML
    private TableColumn<?, ?> col_Examenes;

    @FXML
    private TableColumn<?, ?> col_FechaEntregaEXA;

    @FXML
    private Tab tab_Notas;

    @FXML
    private TableView<?> tableView_Notas_Actividad;

    @FXML
    private TableColumn<?, ?> col_Actividad_Notas;

    @FXML
    private TableColumn<?, ?> col_Notas_Actividad;

    @FXML
    private TableView<?> tableView_Notas_Examenes;

    @FXML
    private TableColumn<?, ?> col_Examen_Nombre;

    @FXML
    private TableColumn<?, ?> col_Examen_Nota;

    @FXML
    private PieChart grafica_Pie;

    @FXML
    private Tab tab_Calendario;

    @FXML
    private ChoiceBox<?> chBox_listaMaterias;

    @FXML
    void cerrarSesionEstudiante(ActionEvent event) {

    }

    public void init(String text, Stage stage, InicioSesionAppController inicioSesionAppController) {
        this.inicioSesionAppController = inicioSesionAppController;
        this.stage = stage;
    }
}
