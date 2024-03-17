package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.dao.ClienteDAO;
import com.sergio.jfxpdv.fabrica.CamposPadronizados;
import com.sergio.jfxpdv.fabrica.Mensagens;
import com.sergio.jfxpdv.modelo.Cliente;
import com.sergio.jfxpdv.servicos.ViaCEP;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.io.IOException;

import static com.sergio.jfxpdv.modelo.Constantes.*;

public class TelaCadastroCliente {
    private final BorderPane borderPane = new BorderPane();
    Button limparDados = new CamposPadronizados().botaoPadrao("Limpar Dados");
    Button cadastrar = new CamposPadronizados().botaoPadrao("Cadastrar");

    CamposPadronizados comboBoxTipo = new CamposPadronizados();
    CamposPadronizados nome = new CamposPadronizados();
    CamposPadronizados cpfECnpj = new CamposPadronizados();
    CamposPadronizados rg = new CamposPadronizados();
    CamposPadronizados telefone = new CamposPadronizados();
    CamposPadronizados email = new CamposPadronizados();
    CamposPadronizados comboBoxEstados = new CamposPadronizados();
    CamposPadronizados cidade = new CamposPadronizados();
    CamposPadronizados rua = new CamposPadronizados();
    CamposPadronizados bairro = new CamposPadronizados();
    CamposPadronizados cep = new CamposPadronizados();
    CamposPadronizados numero = new CamposPadronizados();
    CamposPadronizados complemento = new CamposPadronizados();

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
        Button buscarCEP = new CamposPadronizados().botaoPadrao("Buscar");
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

        cadastrar.setOnAction(e -> {
            try {
                novoCliente();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        limparDados.setOnAction(e -> limparCampos());

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
        TelaPrincipal.painelCentral.setContent(borderPane);
    }

    private String mensagensDeCamposVazios() {
        String mensagemDeErro = null;

        if (comboBoxTipo.getValor() == null) {
            mensagemDeErro = "Por favor, selecione o tipo de cliente.";
        } else if (nome.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o nome do cliente.";
        } else if (cpfECnpj.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o CPF ou CNPJ do cliente.";
        } else if (telefone.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o telefone do cliente.";
        } else if (comboBoxEstados.getValor() == null) {
            mensagemDeErro = "Por favor, selecione o estado do cliente.";
        } else if (cidade.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, selecione a cidade do cliente.";
        } else if (rua.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o nome da rua do cliente.";
        } else if (bairro.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o bairro do cliente.";
        } else if (cep.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o CEP do cliente.";
        } else if (numero.getTexto().isBlank()) {
            mensagemDeErro = "Por favor, preencha o número da casa do cliente.";
        }

        return mensagemDeErro;
    }

    private void novoCliente() throws IOException {

        String nomeCliente = nome.getTexto();
        String cpfCnpjCliente = cpfECnpj.getTexto();
        String rgCliente = rg.getTexto();
        String telefoneCliente = telefone.getTexto();
        String emailCliente = email.getTexto();
        String estadoCliente = comboBoxEstados.getValor();
        String cidadeCliente = cidade.getTexto();
        String ruaCliente = rua.getTexto();
        String bairroCliente = bairro.getTexto();
        String cepCliente = cep.getTexto();
        String numeroCasaCliente = numero.getTexto();
        String complementoCliente = complemento.getTexto();

        if (mensagensDeCamposVazios() != null) {
            Mensagens.caixaDeMensagemPadrao("Aviso!", mensagensDeCamposVazios(), Alert.AlertType.WARNING);
        } else {

            String tipoCliente = null;

            if (comboBoxTipo.getValor().equals("Pessoa Física")) {
                tipoCliente = "PF";
            } else if (comboBoxTipo.getValor().equals("Pessoa Jurídica")) {
                tipoCliente = "PJ";
            }

            Cliente cliente = new Cliente(tipoCliente, nomeCliente, cpfCnpjCliente, rgCliente, telefoneCliente, emailCliente,
                    estadoCliente, cidadeCliente, ruaCliente, bairroCliente, cepCliente, numeroCasaCliente, complementoCliente);

            ClienteDAO dao = new ClienteDAO();
            dao.cadastroCliente(cliente);

            Mensagens.caixaDeMensagemPadrao("Sucesso!", "Cliente cadastrado!", Alert.AlertType.INFORMATION);
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
