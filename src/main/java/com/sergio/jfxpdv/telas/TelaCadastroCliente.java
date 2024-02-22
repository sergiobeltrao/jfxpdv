package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.fabrica.CamposPadronizados;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        HBox quintaHBox = new HBox();
        quintaHBox.setMinWidth(hBoxLarguraMinima);
        quintaHBox.setAlignment(Pos.CENTER_LEFT);
        quintaHBox.setPadding(new Insets(30, 0, 0, 0));

        CamposPadronizados comboBoxTipo = new CamposPadronizados();

        CamposPadronizados nome = new CamposPadronizados();
        VBox campoNomePane = nome.textoAcimaDaBorda("Nome");
        campoNomePane.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoNomePane, Priority.ALWAYS);

        CamposPadronizados cpfECnpj = new CamposPadronizados();
        VBox campoCpfEcNPJ = cpfECnpj.textoAcimaDaBorda("CPF/CNPJ");
        campoCpfEcNPJ.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCpfEcNPJ, Priority.ALWAYS);

        CamposPadronizados rg = new CamposPadronizados();
        VBox campoRg = rg.textoAcimaDaBorda("RG");
        campoRg.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRg, Priority.ALWAYS);

        CamposPadronizados telefone = new CamposPadronizados();
        VBox campoTelefone = telefone.textoAcimaDaBorda("Telefone");
        campoTelefone.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoTelefone, Priority.ALWAYS);

        CamposPadronizados email = new CamposPadronizados();
        VBox campoEmail = email.textoAcimaDaBorda("E-mail");
        campoEmail.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoEmail, Priority.ALWAYS);

        CamposPadronizados comboBoxEstados = new CamposPadronizados();

        CamposPadronizados cidade = new CamposPadronizados();
        VBox campoCidade = cidade.textoAcimaDaBorda("Cidade");
        HBox.setHgrow(campoCidade, Priority.ALWAYS);

        CamposPadronizados rua = new CamposPadronizados();
        VBox campoRua = rua.textoAcimaDaBorda("Rua");
        campoRua.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRua, Priority.ALWAYS);

        CamposPadronizados bairro = new CamposPadronizados();
        VBox campoBairro = bairro.textoAcimaDaBorda("Bairro");
        campoBairro.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoBairro, Priority.ALWAYS);

        CamposPadronizados cep = new CamposPadronizados();
        VBox campoCep = cep.textoAcimaDaBorda("CEP");
        HBox.setHgrow(campoCep, Priority.ALWAYS);

        CamposPadronizados numero = new CamposPadronizados();
        VBox campoNumero = numero.textoAcimaDaBorda("Número");
        HBox.setHgrow(campoNumero, Priority.ALWAYS);
        campoNumero.setMinWidth(txtFieldPequeno);
        campoNumero.setMaxWidth(txtFieldPequeno);

        CamposPadronizados complemento = new CamposPadronizados();
        VBox campoComplemento = complemento.textoAcimaDaBorda("Complemento");
        HBox.setHgrow(campoComplemento, Priority.ALWAYS);

        Button novoCliente = new CamposPadronizados().botaoPadrao("Novo");
        Button salvar = new CamposPadronizados().botaoPadrao("Salvar");
        Button editar = new CamposPadronizados().botaoPadrao("Editar");
        Button excluir = new CamposPadronizados().botaoPadrao("Excluir");


        primeiraHBox.getChildren().addAll(
                comboBoxTipo.comboBoxAcimaDaBorda("Tipo", "Selecione", "Pessoa Física", "Pessoa Jurídica"),
                campoNomePane, campoCpfEcNPJ);
        primeiraHBox.setSpacing(boxEspacamento);

        segundaHBox.getChildren().addAll(campoRg, campoTelefone, campoEmail);
        segundaHBox.setSpacing(boxEspacamento);

        terceiraHBox.getChildren().addAll(comboBoxEstados.comboBoxAcimaDaBorda("Estado", "Selecione",
                        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                        "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
                        "RO", "RR", "SC", "SP", "SE", "TO"),
                campoCidade, campoRua);
        terceiraHBox.setSpacing(boxEspacamento);

        quintaHBox.getChildren().addAll(novoCliente, salvar, editar, excluir);
        quintaHBox.setSpacing(boxEspacamento);

        quartaHBox.getChildren().addAll(
                campoBairro,
                campoCep,
                campoNumero,
                campoComplemento
        );

        quartaHBox.setSpacing(boxEspacamento);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(primeiraHBox, segundaHBox, terceiraHBox, quartaHBox, quintaHBox);
        vBox.setSpacing(boxEspacamento);

        borderPane.setCenter(vBox);
        borderPane.setPadding(new Insets(20, 0, 0, 20)); /* Top, Right, Bottom, Left */
        TelaPrincipal.painelCentral.setContent(borderPane);
    }
}
