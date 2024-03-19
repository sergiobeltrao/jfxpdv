package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.fabrica.ConexaoComBanco;
import com.sergio.jfxpdv.diversos.ConfiguracoesDoAplicativo;
import com.sergio.jfxpdv.diversos.Constantes;
import com.sergio.jfxpdv.fabrica.JanelasDeDialogo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.UnaryOperator;

import static com.sergio.jfxpdv.diversos.Constantes.cssTelaDeLogin;

public class TelaDeConfiguracaoDoBanco {

    private final Text txtUsuario = new Text("Usuário");
    private final TextField campoUsuario = new TextField();
    private final Text txtSenha = new Text("Senha");
    private final PasswordField campoSenha = new PasswordField();
    private final Text txtEnderecoDoServidor = new Text("Endereço do Servidor");
    private final TextField campoEnderecoDoServidor = new TextField();
    private final Text txtPortaDeConexao = new Text("Porta de Conexão");
    private final TextField campoPortaDeConexao = new TextField();
    private final Text txtNomeDoBanco = new Text("Nome do Banco");
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
        vBoxCentral.getStylesheets().add(Constantes.obterCss(cssTelaDeLogin));
        vBoxCentral.getStyleClass().add("vbox-banco");

        Scene scene = new Scene(vBoxCentral, 400, 550);

        VBox vBoxCampos = new VBox();
        vBoxCampos.getStyleClass().add("vbox-banco");
        vBoxCampos.setPadding(new Insets(0, 0, 30, 0)); // Top, Right, Bottom, Left

        vBoxCampos.getChildren().addAll(txtUsuario, campoUsuario,
                txtSenha, campoSenha,
                txtEnderecoDoServidor, campoEnderecoDoServidor,
                txtPortaDeConexao, campoPortaDeConexao,
                txtNomeDoBanco, campoNomeDoBanco);

        campoPortaDeConexao.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, filtroNumerico()));

        testarConexao.getStyleClass().add("padrao-geral-texto");

        testarConexao.setOnAction(e -> testarConexao());

        vBoxCentral.getChildren().addAll(vBoxCampos, testarConexao);

        stage.setScene(scene);
        stage.setTitle("Configuração do banco de dados");
        stage.setResizable(false);
        stage.initOwner(stagePrincipal);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UTILITY);

        stage.showAndWait();
    }

    private void testarConexao() {

        usuario = campoUsuario.getText();
        senha = campoSenha.getText();
        enderecoDoServidor = campoEnderecoDoServidor.getText();
        portaDeConexao = campoPortaDeConexao.getText();
        nomeDoBanco = campoNomeDoBanco.getText();

        String retornoDosDados = todosOsDadosForamPreenchidos();

        if (retornoDosDados.equals("Todos os dados foram preenchidos.")) {
            ConexaoComBanco conexaoComBanco = new ConexaoComBanco(usuario, senha, enderecoDoServidor, portaDeConexao, nomeDoBanco);
            Connection con = conexaoComBanco.iniciarConexao();

            try {
                if (!con.isClosed()) {
                    JanelasDeDialogo.dialogoPadrao("Aviso", "Conexão bem sucedida!", Alert.AlertType.INFORMATION);
                    boolean salvarConfiguracoes = JanelasDeDialogo.confirmacaoPadrao("Salvar configurações", "Deseja salvar as configurações?");

                    if (salvarConfiguracoes) {
                        salvarConfiguracoes();
                        con.close();
                    }
                }
            } catch (SQLException ex) {
                JanelasDeDialogo.dialogoPadrao("Erro no banco de dados", "Encontramos um problema ao acessar o banco de dados. Detalhes do erro: " + ex.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            JanelasDeDialogo.dialogoPadrao("Aviso", retornoDosDados, Alert.AlertType.INFORMATION);
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

    public void salvarConfiguracoes() {

        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        configuracoesDoAplicativo.novaConfiguracao("banco.nomeDoUsuario", usuario);
        configuracoesDoAplicativo.novaConfiguracao("banco.senhaDoUsuario", senha);
        configuracoesDoAplicativo.novaConfiguracao("banco.enderecoDoServidor", enderecoDoServidor);
        configuracoesDoAplicativo.novaConfiguracao("banco.portaDeConexao", portaDeConexao);
        configuracoesDoAplicativo.novaConfiguracao("banco.nomeDoBanco", nomeDoBanco);

        JanelasDeDialogo.dialogoPadrao("Configurações salvas", "Suas configurações foram salvas com sucesso!", Alert.AlertType.INFORMATION);

        TelaDeLogin.habilitaBotaoEntrar(true);

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
