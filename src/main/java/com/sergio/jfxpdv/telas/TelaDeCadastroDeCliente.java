package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.dao.ClienteDAO;
import com.sergio.jfxpdv.fabrica.CamposDeDados;
import com.sergio.jfxpdv.fabrica.JanelasDeDialogo;
import com.sergio.jfxpdv.modelo.Cliente;
import com.sergio.jfxpdv.diversos.ConsultaViaCEP;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import static com.sergio.jfxpdv.diversos.Constantes.*;

public class TelaDeCadastroDeCliente {
    private final BorderPane borderPane = new BorderPane();
    Button limparDados = new CamposDeDados().botaoPadrao("Limpar Dados");
    Button cadastrar = new CamposDeDados().botaoPadrao("Cadastrar");

    CamposDeDados comboBoxTipo = new CamposDeDados();
    CamposDeDados nome = new CamposDeDados();
    CamposDeDados cpfECnpj = new CamposDeDados();
    CamposDeDados rg = new CamposDeDados();
    CamposDeDados telefone = new CamposDeDados();
    CamposDeDados email = new CamposDeDados();
    CamposDeDados comboBoxEstados = new CamposDeDados();
    CamposDeDados cidade = new CamposDeDados();
    CamposDeDados rua = new CamposDeDados();
    CamposDeDados bairro = new CamposDeDados();
    CamposDeDados cep = new CamposDeDados();
    CamposDeDados numero = new CamposDeDados();
    CamposDeDados complemento = new CamposDeDados();

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

        VBox campoNomePane = nome.textoAcimaDaBorda("Nome", true);
        campoNomePane.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoNomePane, Priority.ALWAYS);

        VBox campoCpfEcNPJ = cpfECnpj.textoAcimaDaBorda("CPF/CNPJ", true);
        campoCpfEcNPJ.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoCpfEcNPJ, Priority.ALWAYS);

        VBox campoRg = rg.textoAcimaDaBorda("RG", false);
        campoRg.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRg, Priority.ALWAYS);

        VBox campoTelefone = telefone.textoAcimaDaBorda("Telefone", true);
        campoTelefone.setMinWidth(txtFieldMedio);
        HBox.setHgrow(campoTelefone, Priority.ALWAYS);

        VBox campoEmail = email.textoAcimaDaBorda("E-mail", false);
        campoEmail.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoEmail, Priority.ALWAYS);

        VBox campoCidade = cidade.textoAcimaDaBorda("Cidade", true);
        HBox.setHgrow(campoCidade, Priority.ALWAYS);

        VBox campoRua = rua.textoAcimaDaBorda("Rua", true);
        campoRua.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoRua, Priority.ALWAYS);

        VBox campoBairro = bairro.textoAcimaDaBorda("Bairro", true);
        campoBairro.setMinWidth(txtFieldGrande);
        HBox.setHgrow(campoBairro, Priority.ALWAYS);

        VBox campoCep = cep.textoAcimaDaBorda("CEP", true);
        Button buscarCEP = new CamposDeDados().botaoPadrao("Buscar");
        HBox cepEBotao = new HBox();
        HBox.setHgrow(campoCep, Priority.ALWAYS);
        cepEBotao.getChildren().addAll(campoCep, buscarCEP);
        cepEBotao.setAlignment(Pos.BOTTOM_RIGHT);
        cepEBotao.setSpacing(2);

        VBox campoNumero = numero.textoAcimaDaBorda("Número", true);
        HBox.setHgrow(campoNumero, Priority.ALWAYS);
        campoNumero.setMinWidth(txtFieldPequeno);
        campoNumero.setMaxWidth(txtFieldPequeno);

        VBox campoComplemento = complemento.textoAcimaDaBorda("Complemento", false);
        HBox.setHgrow(campoComplemento, Priority.ALWAYS);

        cadastrar.setOnAction(e -> novoCliente());
        limparDados.setOnAction(e -> limparCampos());

        buscarCEP.setOnAction(e -> {
            String cepDigitado = cep.getText();
            if (!cepDigitado.isBlank()) {
                ConsultaViaCEP consultaViaCEP = new ConsultaViaCEP(cepDigitado);

                bairro.setText(consultaViaCEP.getBairro());
                cidade.setText(consultaViaCEP.getLocalidade());
                rua.setText(consultaViaCEP.getLogradouro());
                comboBoxEstados.setValue(consultaViaCEP.getUf());
            }
        });

        primeiraHBox.getChildren().addAll(
                tipoDeCliente(),
                campoNomePane, campoCpfEcNPJ);
        primeiraHBox.setSpacing(boxEspacamento);

        segundaHBox.getChildren().addAll(campoRg, campoTelefone, campoEmail);
        segundaHBox.setSpacing(boxEspacamento);

        terceiraHBox.getChildren().addAll(estados(), campoCidade, campoRua);
        terceiraHBox.setSpacing(boxEspacamento);

        quintaHBox.getChildren().addAll(cadastrar, limparDados);
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
        TelaInicial.painelCentral.setContent(borderPane);
    }

    private String mensagensDeCamposVazios() {
        String mensagemDeErro = null;

        if (comboBoxTipo.getValue() == null) {
            mensagemDeErro = "Por favor, selecione o tipo de cliente.";
        } else if (nome.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o nome do cliente.";
        } else if (cpfECnpj.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o CPF ou CNPJ do cliente.";
        } else if (telefone.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o telefone do cliente.";
        } else if (comboBoxEstados.getValue() == null) {
            mensagemDeErro = "Por favor, selecione o estado do cliente.";
        } else if (cidade.getText().isBlank()) {
            mensagemDeErro = "Por favor, selecione a cidade do cliente.";
        } else if (rua.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o nome da rua do cliente.";
        } else if (bairro.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o bairro do cliente.";
        } else if (cep.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o CEP do cliente.";
        } else if (numero.getText().isBlank()) {
            mensagemDeErro = "Por favor, preencha o número da casa do cliente.";
        }

        return mensagemDeErro;
    }

    private void novoCliente() {

        String nomeCliente = nome.getText();
        String cpfCnpjCliente = cpfECnpj.getText();
        String rgCliente = rg.getText();
        String telefoneCliente = telefone.getText();
        String emailCliente = email.getText();
        String estadoCliente = comboBoxEstados.getValue();
        String cidadeCliente = cidade.getText();
        String ruaCliente = rua.getText();
        String bairroCliente = bairro.getText();
        String cepCliente = cep.getText();
        String numeroCasaCliente = numero.getText();
        String complementoCliente = complemento.getText();

        if (mensagensDeCamposVazios() != null) {
            JanelasDeDialogo.dialogoPadrao("Aviso!", mensagensDeCamposVazios(), Alert.AlertType.WARNING);
        } else {

            String tipoCliente = null;

            if (comboBoxTipo.getValue().equals("Pessoa Física")) {
                tipoCliente = "PF";
            } else if (comboBoxTipo.getValue().equals("Pessoa Jurídica")) {
                tipoCliente = "PJ";
            }

            Cliente cliente = new Cliente(tipoCliente, nomeCliente, cpfCnpjCliente, rgCliente, telefoneCliente, emailCliente,
                    estadoCliente, cidadeCliente, ruaCliente, bairroCliente, cepCliente, numeroCasaCliente, complementoCliente);

            ClienteDAO dao = new ClienteDAO();
            dao.cadastroCliente(cliente);

            JanelasDeDialogo.dialogoPadrao("Sucesso!", "Cliente cadastrado!", Alert.AlertType.INFORMATION);
            limparCampos();
        }
    }

    public VBox tipoDeCliente() {
        return comboBoxTipo.comboBoxAcimaDaBorda("Tipo", "Selecione", true,
                "Pessoa Física", "Pessoa Jurídica");
    }

    public VBox estados() {
        return comboBoxEstados.comboBoxAcimaDaBorda("Estado", "Selecione", true,
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
                "RO", "RR", "SC", "SP", "SE", "TO");
    }

    private void limparCampos() {
//        comboBoxTipo
        nome.cleanText();
        cpfECnpj.cleanText();
        rg.cleanText();
        telefone.cleanText();
        email.cleanText();
//        comboBoxEstados.limparComboBox();
        cidade.cleanText();
        rua.cleanText();
        bairro.cleanText();
        cep.cleanText();
        numero.cleanText();
        complemento.cleanText();
    }
}
