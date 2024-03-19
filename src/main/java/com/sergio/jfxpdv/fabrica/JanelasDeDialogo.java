package com.sergio.jfxpdv.fabrica;

import com.sergio.jfxpdv.diversos.Constantes;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

import java.util.Optional;

import static com.sergio.jfxpdv.diversos.Constantes.cssCamposPadronizados;

public class JanelasDeDialogo {

    public static void dialogoPadrao(String titulo, String mensagem, Alert.AlertType tipoDoAlerta) {
        Alert alerta = new Alert(tipoDoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);

        DialogPane dialogPane = alerta.getDialogPane();
        dialogPane.getStylesheets().add(Constantes.obterCss(cssCamposPadronizados));
        dialogPane.getStyleClass().add("mensagens");

        alerta.showAndWait();
    }

    public static boolean confirmacaoPadrao(String titulo, String mensagem) {
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle(titulo);
        confirmacao.setHeaderText(mensagem);
        confirmacao.setContentText("Clique em 'Sim' para confirmar ou em 'Não' para cancelar.");

        ButtonType botaoSim = new ButtonType("Sim");
        ButtonType botaoNao = new ButtonType("Não");

        confirmacao.getButtonTypes().setAll(botaoSim, botaoNao);

        DialogPane dialogPane = confirmacao.getDialogPane();
        dialogPane.getStylesheets().add(Constantes.obterCss(cssCamposPadronizados));
        dialogPane.getStyleClass().add("mensagens");

        Optional<ButtonType> resultado = confirmacao.showAndWait();

        return resultado.isPresent() && resultado.get() == botaoSim;
    }
}
