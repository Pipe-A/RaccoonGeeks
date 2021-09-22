module view {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jakarta.xml.bind;
    requires java.logging;
    requires java.desktop;

    exports view;
    opens view to javafx.fxml;
    exports model.reportes;
    opens model.reportes to com.sun.xml.bind;
}