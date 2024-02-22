module com.sergio.jfxpdv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.sergio.jfxpdv to javafx.fxml;
    exports com.sergio.jfxpdv;

    exports com.sergio.jfxpdv.telas;
    opens com.sergio.jfxpdv.telas to javafx.fxml;

    exports com.sergio.jfxpdv.modelo;
    opens com.sergio.jfxpdv.modelo to javafx.fxml;

    exports com.sergio.jfxpdv.menu;
    opens com.sergio.jfxpdv.menu to javafx.fxml;

    exports com.sergio.jfxpdv.servicos;
    opens com.sergio.jfxpdv.servicos to javafx.fxml;
}