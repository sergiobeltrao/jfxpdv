package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.fabrica.CamposDeDados;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;

import static com.sergio.jfxpdv.modelo.Constantes.*;

public class TelaCadastroCliente {
    private final BorderPane borderPane = new BorderPane();

    public void cadastrarCliente() {
        HBox primeiraHBox = new HBox();
        primeiraHBox.setMinWidth(hBoxLarguraMinima);
        HBox segundaHBox = new HBox();
        segundaHBox.setMinWidth(hBoxLarguraMinima);
        HBox terceiraHBox = new HBox();
        terceiraHBox.setMinWidth(hBoxLarguraMinima);
        HBox quartaHBox = new HBox();
        quartaHBox.setMinWidth(hBoxLarguraMinima);

        CamposDeDados nome = new CamposDeDados();
        StackPane campoNomePane = nome.textoNaBordaCentro("Nome");
        campoNomePane.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoNomePane, Priority.ALWAYS);

        CamposDeDados rg = new CamposDeDados();
        StackPane campoRg = rg.textoNaBordaCentro("RG");
        campoRg.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRg, Priority.ALWAYS);

        CamposDeDados cpf = new CamposDeDados();
        StackPane campoCpf = cpf.textoNaBordaCentro("CPF");
        campoCpf.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCpf, Priority.ALWAYS);

        CamposDeDados telefone = new CamposDeDados();
        StackPane campoTelefone = telefone.textoNaBordaCentro("Telefone");
        campoTelefone.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoTelefone, Priority.ALWAYS);

        CamposDeDados celular = new CamposDeDados();
        StackPane campoCelular = celular.textoNaBordaCentro("Celular");
        campoCelular.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCelular, Priority.ALWAYS);

        CamposDeDados email = new CamposDeDados();
        StackPane campoEmail = email.textoNaBordaCentro("E-mail");
        campoEmail.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoEmail, Priority.ALWAYS);

        CamposDeDados bairro = new CamposDeDados();
        StackPane campoBairro = bairro.textoNaBordaCentro("Bairro");
        campoBairro.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoBairro, Priority.ALWAYS);

        CamposDeDados rua = new CamposDeDados();
        StackPane campoRua = rua.textoNaBordaCentro("Rua");
        campoRua.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRua, Priority.ALWAYS);

        CamposDeDados numero = new CamposDeDados();
        StackPane campoNumero = numero.textoNaBordaCentro("Número");
        HBox.setHgrow(campoNumero, Priority.ALWAYS);
        campoNumero.setMinWidth(txtFieldPequeno);
        campoNumero.setMaxWidth(txtFieldPequeno);

        CamposDeDados complemento = new CamposDeDados();
        StackPane campoComplemento = complemento.textoNaBordaCentro("Complemento");
        HBox.setHgrow(campoComplemento, Priority.ALWAYS);

        CamposDeDados cep = new CamposDeDados();
        StackPane campoCep = cep.textoNaBordaCentro("CEP");
        HBox.setHgrow(campoCep, Priority.ALWAYS);

        CamposDeDados cidade = new CamposDeDados();
        StackPane campoCidade = cidade.textoNaBordaCentro("Cidade");
        HBox.setHgrow(campoCidade, Priority.ALWAYS);

        ComboBox<String> cboxEstados = new CamposDeDados().comboBoxStringPadrao();
        cboxEstados.getItems().addAll(
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
                "RO", "RR", "SC", "SP", "SE", "TO"
        );

        cboxEstados.setPromptText("Selecione");

        primeiraHBox.getChildren().addAll(campoNomePane, campoRg, campoCpf);
        primeiraHBox.setSpacing(boxEspacamento);

        segundaHBox.getChildren().addAll(campoTelefone, campoCelular, campoEmail);
        segundaHBox.setSpacing(boxEspacamento);

        terceiraHBox.getChildren().addAll(campoBairro, campoRua);
        terceiraHBox.setSpacing(boxEspacamento);

        quartaHBox.getChildren().addAll(campoNumero, campoComplemento, campoCep, cboxEstados, campoCidade);
        quartaHBox.setSpacing(boxEspacamento);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(primeiraHBox, segundaHBox, terceiraHBox, quartaHBox);
        vBox.setSpacing(boxEspacamento);

        borderPane.setCenter(vBox);
        borderPane.setPadding(new Insets(20, 0, 0, 20)); /* Top, Right, Bottom, Left */
        TelaPrincipal.painelCentral.setContent(borderPane);
    }
}
