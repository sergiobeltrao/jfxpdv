package com.sergio.jfxpdv.fabrica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import static com.sergio.jfxpdv.modelo.Constantes.*;
import static com.sergio.jfxpdv.modelo.Constantes.obterCss;

public class CamposDeInformacao {

    private final TextField campoDeTexto = new TextField();
    private final Label label = new Label();
    private final ComboBox<String> comboBox = new ComboBox<>();
    private final StackPane stackPane = new StackPane();

    public void personalizacao() {
        campoDeTexto.getStylesheets().add(obterCss(cssCamposDeInformacao));
        campoDeTexto.getStyleClass().add("text-field");
        label.getStylesheets().add(obterCss(cssCamposDeInformacao));
        label.getStyleClass().add("label");
        comboBox.getStylesheets().add(obterCss(cssCamposDeInformacao));
        comboBox.getStyleClass().add("combo-box");
        stackPane.getStylesheets().add(obterCss(cssCamposDeInformacao));
        stackPane.getStyleClass().add("stack-pane");
    }

    public StackPane txtFielTextoNaBorda(String titulo) {
        personalizacao();
        label.setText(titulo);

        stackPane.getChildren().addAll(campoDeTexto, label);
        stackPane.setAlignment(Pos.TOP_LEFT);
        StackPane.setMargin(label, new Insets(-11, 0, 0, 7));

        campoDeTexto.setMinHeight(alturaMinimaCampos);

        return stackPane;
    }

    public StackPane comboBoxTextoNaBorda(String titulo, String textoDeSelecao, String... itens) {
        personalizacao();

        label.setText(titulo);

        comboBox.getItems().addAll(itens);
        comboBox.setPromptText(textoDeSelecao);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(comboBox, label);
        stackPane.setAlignment(Pos.TOP_LEFT);
        StackPane.setMargin(label, new Insets(-11, 0, 0, 7));

        comboBox.setMinHeight(alturaMinimaCampos);
        comboBox.setMinWidth(txtFieldPequeno);

        return stackPane;
    }
}
