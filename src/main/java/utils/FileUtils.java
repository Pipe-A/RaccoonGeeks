package utils;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void saveXML(File salida, ReportesUsuarios reporteUsuario) throws IOException, JAXBException {
        try(FileWriter archvioSalida = new FileWriter(salida)){
            JAXBContext context = JAXBContext.newInstance(ReportesUsuarios.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(reporteUsuario, archvioSalida);
        }
    }
}
