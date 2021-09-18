package model;
import java.util.*;

public class Monitor extends Estudiante{
    private Map <UUID, Curso> CursosMonitor=new HashMap<>();

    public Monitor() {
    }

    public Monitor(String usuarioEstud, String contrasennaEstud, String nombreEstud, String carreraEstud, String correoEstud, Long documentoEstud, Map<UUID, Curso> cursosMonitor) {
        super(usuarioEstud, contrasennaEstud, nombreEstud, carreraEstud, correoEstud, documentoEstud);
        CursosMonitor = cursosMonitor;
    }

    public Map<UUID, Curso> getCursosMonitor() {
        return CursosMonitor;
    }

    public void setCursosMonitor(Map<UUID, Curso> cursosMonitor) {
        CursosMonitor = cursosMonitor;
    }
}
