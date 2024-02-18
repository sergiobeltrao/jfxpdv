package com.sergio.jfxpdv;

import com.sergio.jfxpdv.fabrica.CamposDeDados;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Teste extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setCenter(new CamposDeDados().textoNaBordaCentro("Teste"));

        Scene scene = new Scene(borderPane, 300, 100);
        stage.setScene(scene);
        stage.setTitle("TextField com Titled Border");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
