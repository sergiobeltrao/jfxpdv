package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.fabrica.CamposPadronizados;
import com.sergio.jfxpdv.servicos.ViaCEP;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        VBox campoNomePane = nome.textoAcimaDaBorda("Nome", true);
        campoNomePane.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoNomePane, Priority.ALWAYS);

        CamposPadronizados cpfECnpj = new CamposPadronizados();
        VBox campoCpfEcNPJ = cpfECnpj.textoAcimaDaBorda("CPF/CNPJ", true);
        campoCpfEcNPJ.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCpfEcNPJ, Priority.ALWAYS);

        CamposPadronizados rg = new CamposPadronizados();
        VBox campoRg = rg.textoAcimaDaBorda("RG", false);
        campoRg.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRg, Priority.ALWAYS);

        CamposPadronizados telefone = new CamposPadronizados();
        VBox campoTelefone = telefone.textoAcimaDaBorda("Telefone", true);
        campoTelefone.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoTelefone, Priority.ALWAYS);

        CamposPadronizados email = new CamposPadronizados();
        VBox campoEmail = email.textoAcimaDaBorda("E-mail", false);
        campoEmail.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoEmail, Priority.ALWAYS);

        CamposPadronizados comboBoxEstados = new CamposPadronizados();

        CamposPadronizados cidade = new CamposPadronizados();
        VBox campoCidade = cidade.textoAcimaDaBorda("Cidade", true);
        HBox.setHgrow(campoCidade, Priority.ALWAYS);

        CamposPadronizados rua = new CamposPadronizados();
        VBox campoRua = rua.textoAcimaDaBorda("Rua", true);
        campoRua.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRua, Priority.ALWAYS);

        CamposPadronizados bairro = new CamposPadronizados();
        VBox campoBairro = bairro.textoAcimaDaBorda("Bairro", true);
        campoBairro.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoBairro, Priority.ALWAYS);

        CamposPadronizados cep = new CamposPadronizados();
        VBox campoCep = cep.textoAcimaDaBorda("CEP", true);
        Button buscarCEP = new CamposPadronizados().botaoPadrao("Buscar");
        HBox cepEBotao = new HBox();
        HBox.setHgrow(campoCep, Priority.ALWAYS);
        cepEBotao.getChildren().addAll(campoCep, buscarCEP);
        cepEBotao.setAlignment(Pos.BOTTOM_RIGHT);
        cepEBotao.setSpacing(2);

        CamposPadronizados numero = new CamposPadronizados();
        VBox campoNumero = numero.textoAcimaDaBorda("Número", true);
        HBox.setHgrow(campoNumero, Priority.ALWAYS);
        campoNumero.setMinWidth(txtFieldPequeno);
        campoNumero.setMaxWidth(txtFieldPequeno);

        CamposPadronizados complemento = new CamposPadronizados();
        VBox campoComplemento = complemento.textoAcimaDaBorda("Complemento", false);
        HBox.setHgrow(campoComplemento, Priority.ALWAYS);

        Button novoCliente = new CamposPadronizados().botaoPadrao("Novo");
        Button salvar = new CamposPadronizados().botaoPadrao("Salvar");
        Button editar = new CamposPadronizados().botaoPadrao("Editar");
        Button excluir = new CamposPadronizados().botaoPadrao("Excluir");

        buscarCEP.setOnAction(e -> {
            String cepDigitado = cep.getTexto();
            if (!cepDigitado.isBlank()) {
                ViaCEP viaCEP = new ViaCEP(cepDigitado);

                bairro.setTexto(viaCEP.getBairro());
                cidade.setTexto(viaCEP.getLocalidade());
                rua.setTexto(viaCEP.getLogradouro());
                comboBoxEstados.setComboBox(viaCEP.getUf());
            }
        });

        primeiraHBox.getChildren().addAll(
                comboBoxTipo.comboBoxAcimaDaBorda("Tipo", "Selecione", true, "Pessoa Física", "Pessoa Jurídica"),
                campoNomePane, campoCpfEcNPJ);
        primeiraHBox.setSpacing(boxEspacamento);

        segundaHBox.getChildren().addAll(campoRg, campoTelefone, campoEmail);
        segundaHBox.setSpacing(boxEspacamento);

        terceiraHBox.getChildren().addAll(comboBoxEstados.comboBoxAcimaDaBorda("Estado", "Selecione", true,
                        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                        "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
                        "RO", "RR", "SC", "SP", "SE", "TO"),
                campoCidade, campoRua);
        terceiraHBox.setSpacing(boxEspacamento);

        quintaHBox.getChildren().addAll(novoCliente, salvar, editar, excluir);
        quintaHBox.setSpacing(boxEspacamento);

        quartaHBox.getChildren().addAll(
                campoBairro,
                cepEBotao,
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
