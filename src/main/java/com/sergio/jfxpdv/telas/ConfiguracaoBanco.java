package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.Main;
import com.sergio.jfxpdv.fabrica.FabricaDeConexao;
import com.sergio.jfxpdv.modelo.ConfiguracoesDoAplicativo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class ConfiguracaoBanco {

    private final Text txtUsuario = new Text("Usuário");
    private final TextField campoUsuario = new TextField();
    private final Text txtSenha = new Text("Senha");
    private final PasswordField campoSenha = new PasswordField();
    private final Text txtEnderecoDoServidor = new Text("Endereço do servidor");
    private final TextField campoEnderecoDoServidor = new TextField();
    private final Text txtPortaDeConexao = new Text("Porta de conexão");
    private final TextField campoPortaDeConexao = new TextField();
    private final Text txtNomeDoBanco = new Text("Nome do banco");
    private final TextField campoNomeDoBanco = new TextField();
    private final Button testarConexao = new Button("Testar Conexão");

    private final Stage stage = new Stage();

    private String usuario;
    private String senha;
    private String enderecoDoServidor;
    private String portaDeConexao;
    private String nomeDoBanco;

    public void start(Stage stagePrincipal) {

        VBox vBoxCentral = new VBox();
        vBoxCentral.getStylesheets().add(Main.obterCss);
        vBoxCentral.getStyleClass().add("vbox-padrao");

        Scene scene = new Scene(vBoxCentral, 400, 550);

        VBox vBoxCampos = new VBox();
        vBoxCampos.getStyleClass().add("vbox-padrao");
        vBoxCampos.setPadding(new Insets(0, 0, 30, 0)); // Top, Right, Bottom, Left

        vBoxCampos.getChildren().addAll(txtUsuario, campoUsuario,
                txtSenha, campoSenha,
                txtEnderecoDoServidor, campoEnderecoDoServidor,
                txtPortaDeConexao, campoPortaDeConexao,
                txtNomeDoBanco, campoNomeDoBanco);

        campoPortaDeConexao.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, filtroNumerico()));

        testarConexao.getStyleClass().add("padrao-geral-texto");
        testarConexao.setOnAction(e -> {
            try {
                testarConexao();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        vBoxCentral.getChildren().addAll(vBoxCampos, testarConexao);

        stage.setScene(scene);
        stage.setTitle("Configuração do banco de dados");
        stage.setResizable(false);
        stage.initOwner(stagePrincipal);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UTILITY);

        stage.showAndWait();
    }

    private void testarConexao() throws IOException {

        usuario = campoUsuario.getText();
        senha = campoSenha.getText();
        enderecoDoServidor = campoEnderecoDoServidor.getText();
        portaDeConexao = campoPortaDeConexao.getText();
        nomeDoBanco = campoNomeDoBanco.getText();

        String retornoDosDados = todosOsDadosForamPreenchidos();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Aviso");

        if (retornoDosDados.equals("Todos os dados foram preenchidos.")) {
            FabricaDeConexao fabricaDeConexao = new FabricaDeConexao(enderecoDoServidor, usuario, senha, portaDeConexao, nomeDoBanco);
            Connection con = fabricaDeConexao.iniciarConexao();

            try {
                if (!con.isClosed()) {
                    alerta.setContentText("Conexão bem sucedida!");
                    alerta.showAndWait();

                    Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmacao.setTitle("Salvar configurações");
                    confirmacao.setHeaderText("Deseja salvar as configurações?");
                    confirmacao.setContentText("Clique em 'Sim' para confirmar ou em 'Não' para cancelar.");

                    ButtonType buttonTypeSim = new ButtonType("Sim");
                    ButtonType buttonTypeNao = new ButtonType("Não");

                    confirmacao.getButtonTypes().setAll(buttonTypeSim, buttonTypeNao);

                    Optional<ButtonType> result = confirmacao.showAndWait();
                    if (result.isPresent() && result.get() == buttonTypeSim) {
                        salvarConfiguracoes();
                        con.close();
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            alerta.setContentText(retornoDosDados);
            alerta.showAndWait();
        }
    }

    private String todosOsDadosForamPreenchidos() {

        if (usuario.isBlank()) {
            return "Por favor, digite o usuário.";
        } else if (senha.isBlank()) {
            return "Por favor, digite a senha.";
        } else if (enderecoDoServidor.isBlank()) {
            return "Por favor, informe o endereço do servidor.";
        } else if (portaDeConexao.isBlank()) {
            return "Por favor, informe a porta de conexão.";
        } else if (Integer.parseInt(portaDeConexao) > 65535) {
            return "Por favor, informe uma porta válida (entre 0 e 65535).";
        } else if (nomeDoBanco.isBlank()) {
            return "Por favor, informe o nome do banco.";
        }

        return "Todos os dados foram preenchidos.";
    }

    public void salvarConfiguracoes() throws IOException {

        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        configuracoesDoAplicativo.novaConfiguracao("banco.nomeDoUsuario", usuario);
        configuracoesDoAplicativo.novaConfiguracao("banco.senhaDoUsuario", senha);
        configuracoesDoAplicativo.novaConfiguracao("banco.enderecoDoServidor", enderecoDoServidor);
        configuracoesDoAplicativo.novaConfiguracao("banco.portaDeConexao", portaDeConexao);
        configuracoesDoAplicativo.novaConfiguracao("banco.nomeDoBanco", nomeDoBanco);

        Alert salvoComSucesso = new Alert(Alert.AlertType.INFORMATION);
        salvoComSucesso.setTitle("Configurações salvas");
        salvoComSucesso.setHeaderText(null);
        salvoComSucesso.setContentText("Suas configurações foram salvas com sucesso!");
        salvoComSucesso.showAndWait();

        Main.habilitaBotaoEntrar(true);

        stage.close();
    }

    private UnaryOperator<TextFormatter.Change> filtroNumerico() {
        return change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        };
    }
}
