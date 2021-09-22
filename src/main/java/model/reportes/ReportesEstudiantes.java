package model.reportes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import model.Estudiante;


import java.util.HashMap;
import java.util.Map;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportesEstudiantes {
    private Map<String, Estudiante> estudiantes = new HashMap<>();
    public Map<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setUsuarios(Map<String , Estudiante> usuarios) {
        this.estudiantes = usuarios;
        System.out.println(usuarios.size());
    }
}