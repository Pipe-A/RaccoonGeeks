package com.example.demo;

import controller.ControladorGeneral;
import jakarta.xml.bind.JAXBException;
import java.beans.XMLEncoder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Estudiante;
import model.TipoGeneral;
import model.Usuario;
import utils.AlertUtils;


import utils.FileUtils;

import java.io.*;

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
    private Button ButtonGenerarArchivo;

    @FXML
    void generarArchivo(ActionEvent event) {
        Usuario usr1= new Estudiante("Pepe","pepe1","Pepitp","pepa","Sistemas",123124L, TipoGeneral.ESTUDIANTE,null );
        controladorGeneral.guardarUsuario(usr1);

/*
        controladorGeneral.getReportesUsuarios().setUsuarios(controladorGeneral.getUsuarios());
        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        File ruta = AlertUtils.openFileChooserModeWrite(filtro, ((Button) event.getSource()).getScene().getWindow());
        try {
            if (controladorGeneral.getUsuarios().size() == 0){
                AlertUtils.alertError("Vacio","Archivo vacio","El archivo esta vacio");
            }
            FileUtils.saveXML(ruta, controladorGeneral.getReportesUsuarios());
            AlertUtils.alertConfirmation("Generar reporte", "El reporte de los usuarios se ha generado exitosamente", "Presiona OK para continuar");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            AlertUtils.alertError("Error", "No se pueden obtener los usuarios", "Revise los datos que ingresó e inténtelo de nuevo");
        } catch (JAXBException jex) {
            jex.printStackTrace();
            AlertUtils.alertError("Error", "No se pueden obtener los usuarios", "Revise los datos que ingresó e inténtelo de nuevo");
        }

        /*OutputStream out;
        try {
            out = new FileOutputStream("C:\\Users\\willi\\Documents\\ProyectoIngesoft\\Proyecto\\RaccoonGeeks\\Prueba.xml");
            java.beans.XMLEncoder encoder = new XMLEncoder(out);
            for(Usuario usr: controladorGeneral.getControlEstu().getListaEstudiantes().values()){
                encoder.writeObject(usr);
            }
            encoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    void iniciarSesion(ActionEvent event){
        String usuario = fieldUsuario.getText();
        String contraseña = fieldContraseña.getText();
        try {
            int tipoUsuario = controladorGeneral.comprobarTipoUsuario(usuario, contraseña);
            switch (tipoUsuario) {
                case 1:
                    mostrarPantallaEstudiante();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/com.example.demo/PantallaEstudiantes.fxml"));
        Parent root = loader.load();
        PantallaEstudianteController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(fieldUsuario.getText(),stage,this);
        stage.show();
        this.stage.close();
    }

    public void setStage(Stage primaryStage){
        stage = primaryStage;
    }

    public void show(){
        stage.show();
    }



}


