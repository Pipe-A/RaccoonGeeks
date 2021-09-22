package view;

import controller.ControladorGeneral;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import jakarta.xml.bind.Marshaller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;
import utils.AlertUtils;
import utils.FileUtils;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        Profesor profeNuevo = new Profesor("profeWilly","holamundo","Willy","willy.com","Sistemas",123123l,TipoProfesor.DE_PLANTA,TipoGeneral.PROFESOR,null);
        controladorGeneral.getControlProfe().insertarProfesor((Profesor) profeNuevo);
        controladorGeneral.guardarUsuario(profeNuevo);

        Usuario estNuevo = new Estudiante("est1","estu","Pedro","arquitect","est@122",98765L, TipoGeneral.ESTUDIANTE,null);
        controladorGeneral.getControlEstu().insertarEstudiante((Estudiante) estNuevo);
        controladorGeneral.guardarUsuario(estNuevo);

        System.out.println("**************DESPUÉS DE CREAR EL CURSO**************");

        controladorGeneral.getControlProfe().consultarProfesores();
        controladorGeneral.getControlCursos().consultarCurso();
        controladorGeneral.getControlEstu().consultarEstudiantes();

        FileWriter archivo=null;
        try{
            archivo=new FileWriter("ProgramInfo.txt");
            for(Curso cur: controladorGeneral.getControlCursos().getListaCursos().values()){
                archivo.write("<Curso>");
                archivo.write("\n");
                archivo.write(cur.getIdCurso().toString());
                archivo.write("\n");
                archivo.write(cur.getNombreCurso());
                archivo.write("\n");
                archivo.write("<Monitores>");
                archivo.write("\n");
                if(cur.getMonitoresCurso()!=null){
                    for (Monitor monitor: cur.getMonitoresCurso().values()) {
                        archivo.write(monitor.getUsuario());
                        archivo.write("\n");
                    }
                }
                archivo.write("</Monitores>");
                archivo.write("\n");
                archivo.write("<Estudiantes>");
                archivo.write("\n");

                if(cur.getEstudiantesPertenecenCurso()!=null) {
                    for (Estudiante est : cur.getEstudiantesPertenecenCurso().values()) {
                        archivo.write(est.getUsuario());
                        archivo.write("\n");
                    }
                }
                archivo.write("</Estudiantes>");
                archivo.write("\n");
                archivo.write("<Profesores>");
                archivo.write("\n");
                if(cur.getProfesoresPertenecenCurso()!=null){
                    for(Profesor profesor: cur.getProfesoresPertenecenCurso().values()){
                        archivo.write(profesor.getUsuario());
                        archivo.write("\n");
                    }
                }
                archivo.write("</Profesores>");
                archivo.write("\n");
                archivo.write("</Curso>");
                archivo.write("\n");

            }

            for(Usuario usr: controladorGeneral.getUsuarios().values()){
                if(usr instanceof Estudiante){
                    archivo.write("<Estudiante>");
                    archivo.write("\n");
                    archivo.write(usr.getUsuario());
                    archivo.write("\n");
                    archivo.write(usr.getCorreo());
                    archivo.write("\n");
                    archivo.write(usr.getContrasenna());
                    archivo.write("\n");
                    archivo.write(usr.getNombre());
                    archivo.write("\n");
                    archivo.write(((Estudiante) usr).getCarreraEstud());
                    archivo.write("\n");
                    archivo.write(((Estudiante) usr).getDocumentoEstud().toString());
                    archivo.write("\n");
                    archivo.write("<Cursos>");

                    archivo.write("\n");
                    if(((Estudiante) usr).getCursosPertenecenAEstudiante()!=null){
                        for(Curso curso: ((Estudiante) usr).getCursosPertenecenAEstudiante().values()){
                            archivo.write(curso.getIdCurso().toString());
                            archivo.write("\n");
                        }
                    }
                    archivo.write("</Cursos>");
                    archivo.write("\n");
                    archivo.write("</Estudiante>");
                    archivo.write("\n");


                }else if(usr instanceof Profesor){
                    archivo.write("<Profesor>");
                    archivo.write("\n");
                    archivo.write(usr.getUsuario());
                    archivo.write("\n");
                    archivo.write(usr.getCorreo());
                    archivo.write("\n");
                    archivo.write(usr.getContrasenna());
                    archivo.write("\n");
                    archivo.write(usr.getNombre());
                    archivo.write("\n");
                    archivo.write(String.valueOf(((Profesor) usr).getCedulaProfe()));
                    archivo.write("\n");

                    archivo.write("<Cursos>");
                    archivo.write("\n");
                    if(((Profesor) usr).getCursosPertenecenAProfesor()!=null){
                        for(Curso curso: ((Profesor) usr).getCursosPertenecenAProfesor().values()) {
                            archivo.write(curso.getIdCurso().toString());
                            archivo.write("\n");
                        }
                    }

                    archivo.write("</Cursos>");
                    archivo.write("\n");

                    archivo.write("</Profesor>");
                    archivo.write("\n");
                }else if(usr instanceof Administrativo){
                    archivo.write("<Administrativo>");
                    archivo.write("\n");
                    archivo.write(usr.getUsuario());
                    archivo.write("\n");
                    archivo.write(usr.getCorreo());
                    archivo.write("\n");
                    archivo.write(usr.getContrasenna());
                    archivo.write("\n");
                    archivo.write(usr.getNombre());
                    archivo.write("\n");
                    archivo.write(String.valueOf(((Administrativo) usr).getCarreraAdmin()));
                    archivo.write("\n");
                    archivo.write(String.valueOf(((Administrativo) usr).getCedulaAdmin()));
                    archivo.write("\n");

                    archivo.write("</Administrativo>");
                    archivo.write("\n");
                }
            }
            archivo.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }



        /*controladorGeneral.getReportesUsuarios().setUsuarios(controladorGeneral.getUsuarios());
        controladorGeneral.getReportesEstudiantes().setUsuarios(controladorGeneral.getControlEstu().getListaEstudiantes());
        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        File ruta = AlertUtils.openFileChooserModeWrite(filtro, ((Button) event.getSource()).getScene().getWindow());
        try {
            if (controladorGeneral.getUsuarios().size() == 0){
                AlertUtils.alertError("Vacio","Archivo vacio","El archivo esta vacio");
            }
            FileUtils.saveXML(ruta, controladorGeneral.getReportesUsuarios());
            //FileUtils.saveXML(ruta,controladorGeneral.getReportesEstudiantes());
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

    public void llenarInfo(){
        File archivo =new File("ProgramInfo.txt");
        Scanner in =null;

        try{
            in= new Scanner(archivo);
            while (in.hasNext()){

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void iniciarSesion(ActionEvent event) throws IOException{
        String usuario = fieldUsuario.getText();
        String contrasenna = fieldContraseña.getText();
        try {
            int tipoUsuario = controladorGeneral.comprobarTipoUsuario(usuario, contrasenna);
            switch (tipoUsuario) {
                case 1:
                    if(TipoEstudiante.REGULAR.equals(TipoEstudiante.REGULAR)){
                        mostrarPantallaEstudiante(event);
                    } else{
                        //mostrarPantallaEstudianteMonitor();
                    }

                    break;
                case 2:
                    break;
                case 3:
                    mostrarPantallaAdministrativo(event);
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
    public void mostrarPantallaEstudiante(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaEstudiantes.fxml"));
        Parent root = loader.load();
        PantallaEstudianteController pntEstudianteController = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> {
            try {
                pntEstudianteController.cerrarSesionEstudiante(event);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Stage myStage = (Stage) this.ButtonIniciarSesion.getScene().getWindow();
        myStage.close();
    }

    public void mostrarPantallaProfesor(){

    }

    public void mostrarPantallaAdministrativo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipalAdmin.fxml"));
        Parent root = loader.load();
        PantallaPrincipalAdminController controlPantallaGestionProfe = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> {
            try {
                controlPantallaGestionProfe.cerrarSesionAdmin(event);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Stage myStage = (Stage) this.ButtonIniciarSesion.getScene().getWindow();
        myStage.close();
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


