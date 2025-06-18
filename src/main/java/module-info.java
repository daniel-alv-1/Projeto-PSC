module com.example.projetopsc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.example.projetopsc to javafx.fxml;
    exports com.example.projetopsc;
}
