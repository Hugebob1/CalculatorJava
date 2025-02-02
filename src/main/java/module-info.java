module com.example.javafx1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires jdk.compiler;

    opens com.example.javafx1 to javafx.fxml;
    exports com.example.javafx1;
}