package com.sergio.jfxpdv.fabrica;

import javafx.scene.control.Alert;

public class Mensagens {
    public void mensagemDeErro(String titulo, String mensagemDeErro) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagemDeErro);
        alerta.showAndWait();
    }
}
