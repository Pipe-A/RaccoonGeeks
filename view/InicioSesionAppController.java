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



import java.io.*;
import java.util.*;

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
        System.out.println("COMIENZA");
        Scanner in =null;
        ArrayList<Map<UUID,ArrayList<String>>> MonitoresDelCurso = new ArrayList<>();
        ArrayList<Map<UUID,ArrayList<String>>> EstudiantesDelCurso = new ArrayList<>();
        ArrayList<Map<UUID,ArrayList<String>>> profesoresDelCurso = new ArrayList<>();
        ArrayList<Map<String,ArrayList<UUID>>> cursosDeMonitorComoEstudiante=new ArrayList<>();
        ArrayList<Map<String,ArrayList<UUID>>> cursosDeMonitorComoMonitor=new ArrayList<>();
        ArrayList<Map<String,ArrayList<UUID>>> cursosDelEstudiante=new ArrayList<>();
        ArrayList<Map<String,ArrayList<UUID>>> cursosDelProfesor=new ArrayList<>();

         //Map<UUID,String> cursosEstudiantes=new HashMap<>();
        //Map<UUID,String> cursosProfesores= new HashMap<>();
        //Map<String,UUID> monitoresCursosEstudiante = new HashMap<>();
        //Map<String,UUID> monitoresCursosMonitor = new HashMap<>();
        //Map<String,UUID> estudiantesCursos = new HashMap<>();
        //Map<String,UUID> profesorCursos = new HashMap<>();

        try{
            in= new Scanner(archivo);
            in.useDelimiter("\n");
            int contCurso=0,contMonitor=0, contEstudiante=0,contProfesores=0;

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

                    Map<UUID,ArrayList<String>> mapMonitores=new HashMap<>();
                    MonitoresDelCurso.add(mapMonitores);
                    Curso cur=new Curso();
                    cur.setIdCurso(UUID.fromString(in.next()));
                    cur.setNombreCurso(in.next());
                    System.out.println(cur.getNombreCurso());
                    Map<String, Monitor>monitorMap=new HashMap<>();
                    cur.setMonitoresCurso(monitorMap);
                    if(in.next().equals("<MonitoresCurso>")){
                        ArrayList <String> monitores=new ArrayList<>();
                        MonitoresDelCurso.get(contCurso).put(cur.getIdCurso(),monitores);
                        while(!in.hasNext("</MonitoresCurso>")){
                            String usuario=in.next();
                            MonitoresDelCurso.get(contCurso).get(cur.getIdCurso()).add(usuario);
                        }
                        in.next();
                    }
                    Map<UUID,ArrayList<String>> mapEstudiantes=new HashMap<>();
                    EstudiantesDelCurso.add(mapEstudiantes);
                    Map<String,Estudiante> estudianteMap=new HashMap<>();
                    cur.setEstudiantesPertenecenCurso(estudianteMap);
                    if(in.next().equals("<EstudiantesCurso>")){
                        ArrayList<String > estudiantes=new ArrayList<>();
                        EstudiantesDelCurso.get(contCurso).put(cur.getIdCurso(),estudiantes);
                        while(!in.hasNext("</EstudiantesCurso>")){
                            String usuario=in.next();
                            EstudiantesDelCurso.get(contCurso).get(cur.getIdCurso()).add(usuario);
                        }
                        in.next();
                    }
                    Map<UUID,ArrayList<String>> mapProfesores=new HashMap<>();
                    profesoresDelCurso.add(mapProfesores);
                    Map<String,Profesor> profesorMap=new HashMap<>();
                    cur.setProfesoresPertenecenCurso(profesorMap);
                    if(in.next().equals("<ProfesoresCurso>")){
                        ArrayList<String> profesores=new ArrayList<>();
                        profesoresDelCurso.get(contCurso).put(cur.getIdCurso(),profesores);
                        while(!in.hasNext("</ProfesoresCurso>")){
                            String usuario=in.next();

                            profesoresDelCurso.get(contCurso).get(cur.getIdCurso()).add(usuario);
                           // cursosProfesores.put(cur.getIdCurso(),usuario);
                        }
                       in.next();
                    }
                    if(in.next().equals("</Curso>")){
                        System.out.println("CURSOS GUARDADOS");
                        controladorGeneral.getControlCursos().getListaCursos().put(cur.getIdCurso(),cur);
                    }
                    contCurso++;
                }

                //MONITORES------------------------------------
                if(in.hasNext("<Monitor>")&&in.next().equals("<Monitor>")) {

                    Monitor cur = new Monitor();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCarreraEstud(in.next());
                    cur.setDocumentoEstud(in.nextLong());
                    Map<String,ArrayList<UUID>> mapCursosEstudiante=new HashMap<>() ;
                    cursosDeMonitorComoEstudiante.add(mapCursosEstudiante);
                    Map<UUID,Curso> cursoMap=new HashMap<>();
                    cur.setCursosPertenecenAEstudiante(cursoMap);
                    if (in.next().equals("<CursosMonitorEstudiante>")){
                        ArrayList<UUID> cursosMonitorEstudiante=new ArrayList<>();
                        cursosDeMonitorComoEstudiante.get(contMonitor).put(cur.getUsuario(),cursosMonitorEstudiante);
                        while (!(in.hasNext("</CursosMonitorEstudiante>"))) {
                            cursosDeMonitorComoEstudiante.get(contMonitor).get(cur.getUsuario()).add(UUID.fromString(in.next()));
                            //monitoresCursosEstudiante.put(cur.getUsuario(), UUID.fromString(in.next()));
                        }
                        in.next();
                    }
                    Map<String,ArrayList<UUID>> mapCursosMonitor=new HashMap<>();
                    cursosDeMonitorComoMonitor.add(mapCursosMonitor);
                    Map<UUID,Curso>cursoMap1=new HashMap<>();
                    cur.setCursosMonitor(cursoMap1);
                    if (in.next().equals("<CursosMonitor>")) {
                        ArrayList<UUID> cursosMonitorMonitor=new ArrayList<>();
                        cursosDeMonitorComoMonitor.get(contMonitor).put(cur.getUsuario(),cursosMonitorMonitor);
                        while (!in.hasNext("</CursosMonitor>")) {
                            UUID curso = UUID.fromString(in.next());
                            cursosDeMonitorComoMonitor.get(contMonitor).get(cur.getUsuario()).add(curso);
                           // monitoresCursosMonitor.put(cur.getUsuario(), curso);
                        }
                        in.next();
                    }
                    if (in.next().equals("</Monitor>")) {
                        System.out.println("MONITORES GUARDADOS");
                        controladorGeneral.getControlEstu().getListaMonitores().put(cur.getUsuario(), (Monitor) cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(), (Monitor) cur);
                    }
                    contMonitor++;
                }
                //ESTUDIANTES--------------------------
                if(in.hasNext("<Estudiante>")&&in.next().equals("<Estudiante>")){

                    Map<String,ArrayList<UUID>> mapEstudiantes = new HashMap<>();
                    cursosDelEstudiante.add(mapEstudiantes);

                    System.out.println("HACE ALGO EL SEGUNDO PUTO");
                    Estudiante cur=new Estudiante();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCarreraEstud(in.next());
                    cur.setDocumentoEstud(in.nextLong());
                    Map<UUID,Curso> cursoMap=new HashMap<>();
                    cur.setCursosPertenecenAEstudiante(cursoMap);
                    if(in.next().equals("<CursosEstudiante>")){
                        ArrayList<UUID> cursos=new ArrayList<>();
                        cursosDelEstudiante.get(contEstudiante).put(cur.getUsuario(),cursos);
                        while(!in.hasNext("</CursosEstudiante>")){
                            System.out.println("HACE ALGO EL TERCER PUTITO");
                            UUID curso=UUID.fromString(in.next());
                            cursosDelEstudiante.get(contEstudiante).get(cur.getUsuario()).add(curso);
                            //estudiantesCursos.put(cur.getUsuario(),curso);
                        }
                        in.next();
                    }
                    if(in.next().equals("</Estudiante>")){
                        System.out.println("Estudiantes GUARDADOS");
                        controladorGeneral.getControlEstu().getListaEstudiantes().put(cur.getUsuario(), cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(),cur);
                    }
                    contEstudiante++;
                }

                //PROFESORES--------------------------
                if(in.hasNext("<Profesor>")&&in.next().equals("<Profesor>")){
                    Map<String,ArrayList<UUID>> mapCursos = new HashMap<>();
                    cursosDelProfesor.add(mapCursos);

                    Profesor cur=new Profesor();
                    cur.setUsuario(in.next());
                    cur.setCorreo(in.next());
                    cur.setContrasenna(in.next());
                    cur.setNombre(in.next());
                    cur.setCedulaProfe(in.nextLong());

                    Map<UUID,Curso>cursoMap= new HashMap<>();
                    cur.setCursosPertenecenAProfesor(cursoMap);
                    if(in.next().equals("<CursosProfesor>")){
                        ArrayList<UUID> cursos=new ArrayList<>();
                        cursosDelProfesor.get(contProfesores).put(cur.getUsuario(),cursos);
                        while(!in.hasNext("</CursosProfesor>")){
                            UUID curso=UUID.fromString(in.next());
                            cursosDelProfesor.get(contProfesores).get(cur.getUsuario()).add(curso);
                            //profesorCursos.put(cur.getUsuario(),curso);
                        }
                        in.next();
                    }
                    if(in.next().equals("</Profesor>")){
                        System.out.println("PROFESORES GUARDADOS");
                        controladorGeneral.getControlProfe().getListaProfes().put(cur.getUsuario(),cur);
                        controladorGeneral.getUsuarios().put(cur.getUsuario(),cur);
                    }
                    contProfesores++;
                }

            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        for(Map<UUID,ArrayList<String>> Map: EstudiantesDelCurso) {
            for (ArrayList<String> arr : Map.values()) {
                for (String str : arr) {
                    UUID uuid=Map.keySet().iterator().next();
                    controladorGeneral.getControlCursos().getListaCursos().get(uuid).getEstudiantesPertenecenCurso().put(str, controladorGeneral.getControlEstu().getListaEstudiantes().get(str));

                    //controladorGeneral.getControlEstu().getListaEstudiantes().get(str);//.getCursosPertenecenAEstudiante();//.put(uuid,controladorGeneral.getControlCursos().getListaCursos().get(uuid));
                }
            }
        }

        for(Map<UUID,ArrayList<String>> Map: MonitoresDelCurso) {
            for (ArrayList<String> arr : Map.values()) {
                for (String str : arr) {
                    controladorGeneral.getControlCursos().getListaCursos().get(Map.keySet().iterator().next()).getMonitoresCurso().put(str, controladorGeneral.getControlEstu().getListaMonitores().get(str));
                    //controladorGeneral.getControlEstu().getListaMonitores().get(str).getCursosMonitor().put(Map.keySet().iterator().next(),controladorGeneral.getControlCursos().getListaCursos().get(Map.keySet().iterator().next()));

                }
            }
        }

        for(Map<UUID,ArrayList<String>> Map: profesoresDelCurso) {
            for (ArrayList<String> arr : Map.values()) {
                for (String str : arr) {
                    controladorGeneral.getControlCursos().getListaCursos().get(Map.keySet().iterator().next()).getProfesoresPertenecenCurso().put(str, controladorGeneral.getControlProfe().getListaProfes().get(str));
                   // controladorGeneral.getControlProfe().getListaProfes().get(str).getCursosPertenecenAProfesor().put(Map.keySet().iterator().next(),controladorGeneral.getControlCursos().getListaCursos().get(Map.keySet().iterator().next()));

                }
            }
        }

        for(Map<String,ArrayList<UUID>> Map: cursosDeMonitorComoEstudiante) {
            for (ArrayList<UUID> arr : Map.values()) {
                for (UUID str : arr) {
                    controladorGeneral.getControlEstu().getListaMonitores().get(Map.keySet().iterator().next()).getCursosPertenecenAEstudiante().put(str,controladorGeneral.getControlCursos().getListaCursos().get(str));
                   // controladorGeneral.getControlCursos().getListaCursos().get(str).getEstudiantesPertenecenCurso().put(Map.keySet().iterator().next(),controladorGeneral.getControlEstu().getListaMonitores().get(Map.keySet().iterator().next()));
                }
            }
        }

        for(Map<String,ArrayList<UUID>> Map: cursosDeMonitorComoMonitor) {
            for (ArrayList<UUID> arr : Map.values()) {
                for (UUID str : arr) {
                    controladorGeneral.getControlEstu().getListaMonitores().get(Map.keySet().iterator().next()).getCursosMonitor().put(str,controladorGeneral.getControlCursos().getListaCursos().get(str));
                   // controladorGeneral.getControlCursos().getListaCursos().get(str).getMonitoresCurso().put(Map.keySet().iterator().next(),controladorGeneral.getControlEstu().getListaMonitores().get(Map.keySet().iterator().next()));

                }
            }
        }

        for(Map<String,ArrayList<UUID>> Map: cursosDelEstudiante) {
            for (ArrayList<UUID> arr : Map.values()) {
                for (UUID str : arr) {
                    controladorGeneral.getControlEstu().getListaEstudiantes().get(Map.keySet().iterator().next()).getCursosPertenecenAEstudiante().put(str,controladorGeneral.getControlCursos().getListaCursos().get(str));
                    //controladorGeneral.getControlCursos().getListaCursos().get(str).getEstudiantesPertenecenCurso().put(Map.keySet().iterator().next(),controladorGeneral.getControlEstu().getListaEstudiantes().get(Map.keySet().iterator().next()));

                }
            }
        }

        for(Map<String,ArrayList<UUID>> Map: cursosDelProfesor) {
            for (ArrayList<UUID> arr : Map.values()) {
                for (UUID str : arr) {
                    controladorGeneral.getControlProfe().getListaProfes().get(Map.keySet().iterator().next()).getCursosPertenecenAProfesor().put(str,controladorGeneral.getControlCursos().getListaCursos().get(str));
                    //controladorGeneral.getControlCursos().getListaCursos().get(str).getProfesoresPertenecenCurso().put(Map.keySet().iterator().next(),controladorGeneral.getControlProfe().getListaProfes().get(Map.keySet().iterator().next()));

                }
            }
        }
    }

    @FXML
    void iniciarSesion(ActionEvent event) throws IOException{
        llenarInfo();
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


