package com.sergio.jfxpdv.telas;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class TelaBuscaCliente {
    private final BorderPane borderPane = new BorderPane();

    public void buscarCliente() {
        Text text = new Text();
        text.setText("Buscar cliente");
        text.setStyle("-fx-text-fill: black; -fx-fill-width: true; -fx-fit-to-height: true; -fx-font-size: 30px");
        borderPane.setCenter(text);

        TelaPrincipal.painelCentral.setContent(borderPane);
    }
}
