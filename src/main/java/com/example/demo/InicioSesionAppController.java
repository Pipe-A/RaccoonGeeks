package com.example.demo;

import controller.ControlCursos;
import controller.ControladorEstudiante;
import controller.ControladorGeneral;
import controller.ControladorProfesor;
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
import model.*;
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

        Usuario admin = new Administrativo("Mau","mau1","Mauren","mauriv","Sistemas",12345L,TipoGeneral.ADMINISTRATIVO);
        controladorGeneral.guardarUsuario(admin);

        Usuario profeNuevo = new Profesor("prof1", "profe", "Juanito", "loquesea@puj","sistemas",12345678L,TipoProfesor.DE_PLANTA, TipoGeneral.PROFESOR,null);
        controladorGeneral.getControlProfe().insertarProfesor((Profesor) profeNuevo);
        controladorGeneral.guardarUsuario(profeNuevo);

        Usuario estNuevo = new Estudiante("est1","estu","Pedro","arquitect","est@122",98765L, TipoGeneral.ESTUDIANTE,null);
        controladorGeneral.getControlEstu().insertarEstudiante((Estudiante) estNuevo);
        controladorGeneral.guardarUsuario(estNuevo);

        Curso cursos = new Curso("Fundamentos",null,null);
        controladorGeneral.getControlCursos().insertarCurso(cursos);

        ControladorGeneral controlTotal = new ControladorGeneral();
        controlTotal.asignarEstudiante(cursos,(Estudiante) estNuevo);
        controlTotal.asingarProfesor(cursos,(Profesor) profeNuevo);

        System.out.println("**************DESPUÉS DE CREAR EL CURSO**************");

        controladorGeneral.getControlProfe().consultarProfesores();
        controladorGeneral.getControlCursos().consultarCurso();
        controladorGeneral.getControlEstu().consultarEstudiantes();

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
    void iniciarSesion(ActionEvent event) throws IOException{
        String usuario = fieldUsuario.getText();
        String contraseña = fieldContraseña.getText();
        FXMLLoader loader;
        Parent root;
        Scene scene;
        Stage stage;
        Stage myStage;
        try {
            int tipoUsuario = controladorGeneral.comprobarTipoUsuario(usuario, contraseña);
            switch (tipoUsuario) {
                case 1:
                    //mostrarPantallaEstudiante();
                    loader = new FXMLLoader(getClass().getResource("PantallaEstudiantes.fxml"));
                    root = loader.load();
                    PantallaEstudianteController pntEstudianteController = loader.getController();
                    scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e-> {
                        try {
                            pntEstudianteController.closeWindows();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    myStage = (Stage) this.ButtonIniciarSesion.getScene().getWindow();
                    myStage.close();
                    break;
                case 2:
                    break;
                case 3:
                    loader = new FXMLLoader(getClass().getResource("PantallaPrincipalAdmin.fxml"));
                    root = loader.load();
                    PantallaPrincipalAdminController controlPantallaPrincipalController = loader.getController();
                    scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e-> {
                        try {
                            controlPantallaPrincipalController.closeWindows();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    myStage = (Stage) this.ButtonIniciarSesion.getScene().getWindow();
                    myStage.close();
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

    /*@FXML
    void iniciarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipalAdmin.fxml"));
        Parent root = loader.load();
        PantallaPrincipalAdminController controlPantPrincController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> {
            try {
                controlPantPrincController.closeWindows();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Stage myStage = (Stage) this.ButtonIniciarSesion.getScene().getWindow();
        myStage.close();

    }*/

    /*public void mostrarPantallaEstudiante() throws IOException {
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
    }*/



}


