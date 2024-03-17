package com.sergio.jfxpdv.fabrica;

import javafx.scene.control.Alert;

public class Mensagens {

    public static void mensagemDeErro(String titulo, String mensagem) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setTitle(titulo);
        erro.setHeaderText(null);
        erro.setContentText(mensagem);
        erro.showAndWait();
    }

    public static void mensagemDeAviso(String titulo, String mensagem) {
        Alert aviso = new Alert(Alert.AlertType.WARNING);
        aviso.setTitle(titulo);
        aviso.setHeaderText(null);
        aviso.setContentText(mensagem);
        aviso.showAndWait();
    }

    public static void mensagemDeInformacao(String titulo, String mensagem) {
        Alert informacao = new Alert(Alert.AlertType.INFORMATION);
        informacao.setTitle(titulo);
        informacao.setHeaderText(null);
        informacao.setContentText(mensagem);
        informacao.showAndWait();
    }
}
