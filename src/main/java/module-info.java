module com.sergio.jfxpdv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.sergio.jfxpdv to javafx.fxml;
    exports com.sergio.jfxpdv;
    exports com.sergio.jfxpdv.telas;
    opens com.sergio.jfxpdv.telas to javafx.fxml;

    exports com.sergio.jfxpdv.modelo;
}