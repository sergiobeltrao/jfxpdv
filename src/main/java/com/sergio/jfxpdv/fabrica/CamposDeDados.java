package com.sergio.jfxpdv.fabrica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static com.sergio.jfxpdv.diversos.Constantes.*;
import static com.sergio.jfxpdv.diversos.Constantes.obterCss;

public class CamposDeDados {

    private final TextField campoDeTexto = new TextField();
    private final Label label = new Label();
    private final ComboBox<String> comboBox = new ComboBox<>();
    private final StackPane stackPane = new StackPane();
    private final VBox vBox = new VBox();
    private final Text txtTitulo = new Text();
    private final Button button = new Button();
    private final HBox hBox = new HBox();
    private final Label labelAsterisco = new Label("*");

    public String getText() {
        return campoDeTexto.getText();
    }

    public String getValue() {
        return comboBox.getValue();
    }

    public void cleanText() {
        campoDeTexto.setText("");
    }

    public void setText(String texto) {
        campoDeTexto.setText(texto);
    }

    public void setValue(String item) {
        comboBox.setValue(item);
    }

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
        labelAsterisco.getStylesheets().add(obterCss(cssCamposPadronizados));
        labelAsterisco.getStyleClass().add("campo-obrigatorio");
    }

    @SuppressWarnings("unused")
    public VBox textoAcimaDaBorda(String titulo, boolean obrigatorio) {
        personalizacao();
        txtTitulo.setText(titulo);

        if (obrigatorio) {
            hBox.getChildren().addAll(txtTitulo, labelAsterisco);
            vBox.getChildren().addAll(hBox, campoDeTexto);
        } else {
            vBox.getChildren().addAll(txtTitulo, campoDeTexto);
        }

        return vBox;
    }

    @SuppressWarnings("unused")
    public VBox comboBoxAcimaDaBorda(String titulo, String textoDeSelecao, boolean selecaoObrigatoria, String... itens) {
        personalizacao();
        txtTitulo.setText(titulo);

        if (selecaoObrigatoria) {
            hBox.getChildren().addAll(txtTitulo, labelAsterisco);
            vBox.getChildren().addAll(hBox, comboBox);
        } else {
            vBox.getChildren().addAll(txtTitulo, comboBox);
        }

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
