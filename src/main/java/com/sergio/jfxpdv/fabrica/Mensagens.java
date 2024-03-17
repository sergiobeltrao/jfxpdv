package com.sergio.jfxpdv.fabrica;

import com.sergio.jfxpdv.diversos.Constantes;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import static com.sergio.jfxpdv.diversos.Constantes.cssCamposPadronizados;

public class Mensagens {

    public static void caixaDeMensagemPadrao(String titulo, String mensagem, Alert.AlertType tipoDoAlerta) {
        Alert alerta = new Alert(tipoDoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);

        DialogPane dialogPane = alerta.getDialogPane();
        dialogPane.getStylesheets().add(Constantes.obterCss(cssCamposPadronizados));
        dialogPane.getStyleClass().add("mensagens");

        alerta.showAndWait();
    }
}
