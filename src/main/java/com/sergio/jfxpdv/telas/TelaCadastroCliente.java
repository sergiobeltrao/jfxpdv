package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.fabrica.CamposDeInformacao;
import javafx.geometry.Insets;
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

        CamposDeInformacao nome = new CamposDeInformacao();
        StackPane campoNomePane = nome.txtFielTextoNaBorda("Nome");
        campoNomePane.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoNomePane, Priority.ALWAYS);

        CamposDeInformacao rg = new CamposDeInformacao();
        StackPane campoRg = rg.txtFielTextoNaBorda("RG");
        campoRg.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRg, Priority.ALWAYS);

        CamposDeInformacao cpf = new CamposDeInformacao();
        StackPane campoCpf = cpf.txtFielTextoNaBorda("CPF");
        campoCpf.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCpf, Priority.ALWAYS);

        CamposDeInformacao telefone = new CamposDeInformacao();
        StackPane campoTelefone = telefone.txtFielTextoNaBorda("Telefone");
        campoTelefone.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoTelefone, Priority.ALWAYS);

        CamposDeInformacao celular = new CamposDeInformacao();
        StackPane campoCelular = celular.txtFielTextoNaBorda("Celular");
        campoCelular.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCelular, Priority.ALWAYS);

        CamposDeInformacao email = new CamposDeInformacao();
        StackPane campoEmail = email.txtFielTextoNaBorda("E-mail");
        campoEmail.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoEmail, Priority.ALWAYS);

        CamposDeInformacao bairro = new CamposDeInformacao();
        StackPane campoBairro = bairro.txtFielTextoNaBorda("Bairro");
        campoBairro.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoBairro, Priority.ALWAYS);

        CamposDeInformacao rua = new CamposDeInformacao();
        StackPane campoRua = rua.txtFielTextoNaBorda("Rua");
        campoRua.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRua, Priority.ALWAYS);

        CamposDeInformacao numero = new CamposDeInformacao();
        StackPane campoNumero = numero.txtFielTextoNaBorda("Número");
        HBox.setHgrow(campoNumero, Priority.ALWAYS);
        campoNumero.setMinWidth(txtFieldPequeno);
        campoNumero.setMaxWidth(txtFieldPequeno);

        CamposDeInformacao complemento = new CamposDeInformacao();
        StackPane campoComplemento = complemento.txtFielTextoNaBorda("Complemento");
        HBox.setHgrow(campoComplemento, Priority.ALWAYS);

        CamposDeInformacao cep = new CamposDeInformacao();
        StackPane campoCep = cep.txtFielTextoNaBorda("CEP");
        HBox.setHgrow(campoCep, Priority.ALWAYS);

        CamposDeInformacao cidade = new CamposDeInformacao();
        StackPane campoCidade = cidade.txtFielTextoNaBorda("Cidade");
        HBox.setHgrow(campoCidade, Priority.ALWAYS);

        CamposDeInformacao comboBoxEstados = new CamposDeInformacao();

        primeiraHBox.getChildren().addAll(campoNomePane, campoRg, campoCpf);
        primeiraHBox.setSpacing(boxEspacamento);

        segundaHBox.getChildren().addAll(campoTelefone, campoCelular, campoEmail);
        segundaHBox.setSpacing(boxEspacamento);

        terceiraHBox.getChildren().addAll(campoBairro, campoRua, campoNumero);
        terceiraHBox.setSpacing(boxEspacamento);

        quartaHBox.getChildren().addAll(
                campoComplemento,
                campoCep,
                comboBoxEstados.comboBoxTextoNaBorda("Estados", "Selecione",
                        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                        "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
                        "RO", "RR", "SC", "SP", "SE", "TO"),
                campoCidade);

        quartaHBox.setSpacing(boxEspacamento);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(primeiraHBox, segundaHBox, terceiraHBox, quartaHBox);
        vBox.setSpacing(boxEspacamento);

        borderPane.setCenter(vBox);
        borderPane.setPadding(new Insets(20, 0, 0, 20)); /* Top, Right, Bottom, Left */
        TelaPrincipal.painelCentral.setContent(borderPane);
    }
}
