package com.sergio.jfxpdv.telas;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaPrincipal {

    public static Stage stage = new Stage();

    public TelaPrincipal() {

        BorderPane borderPane = new BorderPane();

        borderPane.setTop(new MenuPrincipal().Menu());

        Scene scene = new Scene(borderPane, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.setMinHeight(576);
        stage.setMinWidth(1024);
        stage.show();
    }

    public static void fechar(boolean fechar) {
        if (fechar) {
            stage.close();
        }
    }
}