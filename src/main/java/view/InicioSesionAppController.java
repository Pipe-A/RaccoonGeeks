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
import java.util.UUID;

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
                archivo.write("<MonitoresCurso>");
                archivo.write("\n");
                if(cur.getMonitoresCurso()!=null){
                    for (Monitor monitor: cur.getMonitoresCurso().values()) {
                        archivo.write(monitor.getUsuario());
                        archivo.write("\n");
                    }
                }
                archivo.write("</MonitoresCurso>");
                archivo.write("\n");
                archivo.write("<EstudiantesCurso>");
                archivo.write("\n");

                if(cur.getEstudiantesPertenecenCurso()!=null) {
                    for (Estudiante est : cur.getEstudiantesPertenecenCurso().values()) {
                        archivo.write(est.getUsuario());
                        archivo.write("\n");
                    }
                }
                archivo.write("</EstudiantesCurso>");
                archivo.write("\n");
                archivo.write("<ProfesoresCurso>");
                archivo.write("\n");
                if(cur.getProfesoresPertenecenCurso()!=null){
                    for(Profesor profesor: cur.getProfesoresPertenecenCurso().values()){
                        archivo.write(profesor.getUsuario());
                        archivo.write("\n");
                    }
                }
                archivo.write("</ProfesoresCurso>");
                archivo.write("\n");
                archivo.write("</Curso>");
                archivo.write("\n");
            }

            for(Usuario usr: controladorGeneral.getUsuarios().values()){
                if(usr instanceof Monitor){
                    archivo.write("<Monitor>");
                    archivo.write("\n");
                    archivo.write(usr.getUsuario());
                    archivo.write("\n");
                    archivo.write(usr.getCorreo());
                    archivo.write("\n");
                    archivo.write(usr.getContrasenna());
                    archivo.write("\n");
                    archivo.write(usr.getNombre());
                    archivo.write("\n");
                    archivo.write(((Monitor) usr).getCarreraEstud());
                    archivo.write("\n");
                    archivo.write(((Monitor) usr).getDocumentoEstud().toString());
                    archivo.write("\n");
                    archivo.write("<CursosMonitorEstudiante>");

                    archivo.write("\n");
                    if(((Monitor) usr).getCursosPertenecenAEstudiante()!=null){
                        for(Curso curso: ((Monitor) usr).getCursosPertenecenAEstudiante().values()){
                            archivo.write(curso.getIdCurso().toString());
                            archivo.write("\n");
                        }
                    }
                    archivo.write("</CursosMonitorEstudiante>");
                    archivo.write("\n");
                    archivo.write("<CursosMonitor>");
                    if(((Monitor)usr).getCursosMonitor()!=null){
                        for(Curso curso: ((Monitor) usr).getCursosMonitor().values()){
                            archivo.write(curso.getIdCurso().toString());
                            archivo.write("\n");
                        }
                    }
                    archivo.write("</CursosMonitor>");

                    archivo.write("</Monitor>");
                    archivo.write("\n");
                }
                else if(usr instanceof Estudiante){
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
                    archivo.write("<CursosEstudiante>");

                    archivo.write("\n");
                    if(((Estudiante) usr).getCursosPertenecenAEstudiante()!=null){
                        for(Curso curso: ((Estudiante) usr).getCursosPertenecenAEstudiante().values()){
                            archivo.write(curso.getIdCurso().toString());
                            archivo.write("\n");
                        }
                    }
                    archivo.write("</CursosEstudiante>");
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

                    archivo.write("<CursosProfesor>");
                    archivo.write("\n");
                    if(((Profesor) usr).getCursosPertenecenAProfesor()!=null){
                        for(Curso curso: ((Profesor) usr).getCursosPertenecenAProfesor().values()) {
                            archivo.write(curso.getIdCurso().toString());
                            archivo.write("\n");
                        }
                    }

                    archivo.write("</CursosProfesor>");
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
        Map<UUID,String> cursosMonitores=new HashMap<>();
        Map<UUID,String> cursosEstudiantes=new HashMap<>();
        Map<UUID,String> cursosProfesores= new HashMap<>();
        Map<String,UUID> monitoresCursosEstudiante = new HashMap<>();
        Map<String,UUID> monitoresCursosMonitor = new HashMap<>();
        Map<String,UUID> estudiantesCursos = new HashMap<>();
        Map<String,UUID> profesorCursos = new HashMap<>();

        try{
            in= new Scanner(archivo);
            while (in.hasNext()){
                //ADMINISTRADORES--------------------------
                if(in.hasNext("<Administrativo>")&&in.next().equals("<Administrativo>")){
                    System.out.println("HACE ALGO EL PUTO");
                    Administrativo cur=new Administrativo();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCedulaAdmin(in.nextLong());

                    if(in.next().equals("</Administrativo>")){
                        System.out.println("ADMINISTRADORES GUARDADOS");
                        controladorGeneral.getListaAdministrador().put(cur.getUsuario(),cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(),cur);
                    }
                }
                if(in.hasNext("<Curso>")&&in.next().equals("<Curso>")){

                    Curso cur=new Curso();
                    cur.setIdCurso(UUID.fromString(in.next()));
                    cur.setNombreCurso(in.next());

                    if(in.next().equals("<MonitoresCurso>")){
                        while(!in.hasNext("</MonitoresCurso>")){
                            String usuario=in.next();
                            cursosMonitores.put(cur.getIdCurso(),usuario);
                        }
                        in.next();
                    }
                    if(in.next().equals("<EstudiantesCurso>")){
                        while(!in.hasNext("</EstudiantesCurso>")){
                            String usuario=in.next();
                            cursosEstudiantes.put(cur.getIdCurso(),usuario);
                        }
                        in.next();
                    }
                    if(in.next().equals("<ProfesoresCurso>")){
                        while(!in.hasNext("</ProfesoresCurso>")){
                            String usuario=in.next();
                            cursosProfesores.put(cur.getIdCurso(),usuario);
                        }
                       in.next();
                    }
                    if(in.next().equals("</Curso>")){
                        System.out.println("CURSOS GUARDADOS");
                        controladorGeneral.getControlCursos().getListaCursos().put(cur.getIdCurso(),cur);
                    }
                }
                //MONITORES------------------------------------
                if(in.hasNext("<Monitor>")&&in.next().equals("<Monitor>")) {

                    Estudiante cur = new Monitor();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCarreraEstud(in.next());
                    cur.setDocumentoEstud(in.nextLong());

                    if (in.next().equals("<CursosMonitorEstudiante>")){
                        while (!(in.hasNext("</CursosMonitorEstudiante>"))) {
                            monitoresCursosEstudiante.put(cur.getUsuario(), UUID.fromString(in.next()));
                        }
                        in.next();
                    }
                    if (in.next().equals("<CursosMonitor>")) {
                        while (!in.hasNext("</CursosMonitor>")) {
                            UUID curso = UUID.fromString(in.next());
                            monitoresCursosMonitor.put(cur.getUsuario(), curso);
                        }
                        in.next();
                    }
                    if (in.next().equals("</Monitor>")) {
                        System.out.println("MONITORES GUARDADOS");
                        controladorGeneral.getControlEstu().getListaMonitores().put(cur.getUsuario(), (Monitor) cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(), (Monitor) cur);
                    }
                }
                //ESTUDIANTES--------------------------
                if(in.hasNext("<Estudiante>")&&in.next().equals("<Estudiante>")){
                    System.out.println("HACE ALGO EL SEGUNDO PUTO");
                    Estudiante cur=new Estudiante();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCarreraEstud(in.next());
                    cur.setDocumentoEstud(in.nextLong());

                    if(in.next().equals("<CursosEstudiante>")){
                        while(!in.hasNext("</CursosEstudiante>")){
                            System.out.println("HACE ALGO EL TERCER PUTITO");
                            UUID curso=UUID.fromString(in.next());
                            estudiantesCursos.put(cur.getUsuario(),curso);
                        }
                        in.next();
                    }
                    if(in.next().equals("</Estudiante>")){
                        System.out.println("Estudiantes GUARDADOS");
                        controladorGeneral.getControlEstu().getListaEstudiantes().put(cur.getUsuario(), cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(),cur);
                    }
                }

                //PROFESORES--------------------------
                if(in.hasNext("<Profesor>")&&in.next().equals("<Profesor>")){
                    Profesor cur=new Profesor();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCedulaProfe(in.nextLong());

                    if(in.next().equals("<CursosProfesor>")){
                        while(!in.hasNext("</CursosProfesor>")){
                            UUID curso=UUID.fromString(in.next());
                            profesorCursos.put(cur.getUsuario(),curso);
                        }
                        in.next();
                    }
                    if(in.next().equals("</Profesor>")){
                        System.out.println("PROFESORES GUARDADOS");
                        controladorGeneral.getControlProfe().getListaProfes().put(cur.getUsuario(),cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(),cur);
                    }
                }

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        /*
        *
        cursosMonitores
        cursosEstudiantes
        cursosProfesores
        monitoresCursosEstudiante
        monitoresCursosMonitor
        estudiantesCursos
        profesorCursos
        *
        * */



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


