package com.sergio.jfxpdv.fabrica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static com.sergio.jfxpdv.modelo.Constantes.*;
import static com.sergio.jfxpdv.modelo.Constantes.obterCss;

public class CamposPadronizados {

    private final TextField campoDeTexto = new TextField();
    private final Label label = new Label();
    private final ComboBox<String> comboBox = new ComboBox<>();
    private final StackPane stackPane = new StackPane();
    private final VBox vBox = new VBox();
    private final Text txtTitulo = new Text();
    private final Button button = new Button();

    public void personalizacao() {
        campoDeTexto.getStylesheets().add(obterCss(cssCamposPadronizados));
        campoDeTexto.getStyleClass().add("text-field");
        label.getStylesheets().add(obterCss(cssCamposPadronizados));
        label.getStyleClass().add("label");
        comboBox.getStylesheets().add(obterCss(cssCamposPadronizados));
        comboBox.getStyleClass().add("combo-box");
        stackPane.getStylesheets().add(obterCss(cssCamposPadronizados));
        stackPane.getStyleClass().add("stack-pane");
        vBox.getStylesheets().add(obterCss(cssCamposPadronizados));
        vBox.getStyleClass().add("vbox");
        txtTitulo.getStyleClass().add("text-titulo");
        button.getStylesheets().add(obterCss(cssCamposPadronizados));
        button.getStyleClass().add("button");
    }

    @SuppressWarnings("unused")
    public VBox textoAcimaDaBorda(String titulo) {
        personalizacao();
        txtTitulo.setText(titulo);

        vBox.getChildren().addAll(txtTitulo, campoDeTexto);

        return vBox;
    }

    @SuppressWarnings("unused")
    public VBox comboBoxAcimaDaBorda(String titulo, String textoDeSelecao, String... itens) {
        personalizacao();
        txtTitulo.setText(titulo);

        vBox.getChildren().addAll(txtTitulo, comboBox);

        comboBox.getItems().addAll(itens);
        comboBox.setPromptText(textoDeSelecao);

        comboBox.setMinHeight(alturaMinimaCampos);
        comboBox.setMinWidth(txtFieldPequeno);

        return vBox;
    }

    @SuppressWarnings("unused")
    public StackPane txtFielTextoNaBorda(String titulo) {
        personalizacao();
        label.setText(titulo);

        stackPane.getChildren().addAll(campoDeTexto, label);
        stackPane.setAlignment(Pos.TOP_LEFT);
        StackPane.setMargin(label, new Insets(-11, 0, 0, 7));

        return stackPane;
    }

    @SuppressWarnings("unused")
    public StackPane comboBoxTextoNaBorda(String titulo, String textoDeSelecao, String... itens) {
        personalizacao();

        label.setText(titulo);

        comboBox.getItems().addAll(itens);
        comboBox.setPromptText(textoDeSelecao);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(comboBox, label);
        stackPane.setAlignment(Pos.TOP_LEFT);
        StackPane.setMargin(label, new Insets(-11, 0, 0, 7));

        comboBox.setMinWidth(txtFieldPequeno);

        return stackPane;
    }

    public Button botaoPadrao(String texto) {
        personalizacao();
        button.setText(texto);
        return button;
    }
}
