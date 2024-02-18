package com.sergio.jfxpdv.fabrica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.sergio.jfxpdv.modelo.Constantes.*;

public class CamposDeDados {

    private final TextField campoDeTexto = new TextField();
    private final Label label = new Label();


    public VBox textoAcimaDaBorda(String titulo) {
        Text txtTitulo = new Text();
        txtTitulo.setText(titulo);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(txtTitulo, campoDeTexto);

        // Para o CSS
        txtTitulo.setFont(Font.font("Segoe UI", 14));
        campoDeTexto.setMinHeight(alturaMinimaCampos);
        campoDeTexto.setFont(Font.font("Segoe UI", 14));

        return vBox;
    }

    public StackPane textoNaBordaCentro(String titulo) {
        label.setText(titulo);
        label.setPadding(new Insets(0, 3, -5, 3)); /* Top, Right, Bottom, Left */

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(campoDeTexto, label);
        stackPane.setAlignment(Pos.TOP_LEFT);
        StackPane.setMargin(label, new Insets(-11, 0, 0, 7));

        // Para o CSS
        label.setStyle("-fx-background-color: #f4f4f4;");
        label.setFont(Font.font("Segoe UI", 14));
        stackPane.setStyle("-fx-background-color: #f4f4f4");
        campoDeTexto.setMinHeight(alturaMinimaCampos);
        campoDeTexto.setFont(Font.font("Segoe UI", 14));

        return stackPane;
    }

    public ComboBox<String> comboBoxStringPadrao() {

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setMinHeight(alturaMinimaCampos);

        return comboBox;
    }
}
