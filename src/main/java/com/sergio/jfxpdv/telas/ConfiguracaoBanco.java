package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.Main;
import com.sergio.jfxpdv.fabrica.FabricaDeConexao;
import com.sergio.jfxpdv.modelo.ConfiguracoesDoAplicativo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.UnaryOperator;

public class ConfiguracaoBanco {

    private final TextField campoUsuario = new TextField();
    private final PasswordField campoSenha = new PasswordField();
    private final TextField campoEnderecoDoServidor = new TextField();
    private final TextField campoPortaDeConexao = new TextField();
    private final TextField campoNomeDoBanco = new TextField();
    Stage stage = new Stage();

    public void start(Stage stagePrincipal) {

        double comprimentoDosCampos = 250.0;
        Font meuEstiloDeFonte = new Font("Inter", 15);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(50, 0, 0, 0)); // Top, Right, Bottom, Left

        Text txtUsuario = new Text("Usuário");
        Text txtSenha = new Text("Senha");
        Text txtEnderecoDoServidor = new Text("Endereço do servidor");
        Text txtPortaDeConexao = new Text("Porta de conexão");
        Text txtNomeDoBanco = new Text("Nome do banco");

        txtUsuario.setFont(meuEstiloDeFonte);
        txtSenha.setFont(meuEstiloDeFonte);
        txtEnderecoDoServidor.setFont(meuEstiloDeFonte);
        txtPortaDeConexao.setFont(meuEstiloDeFonte);
        txtNomeDoBanco.setFont(meuEstiloDeFonte);

        campoUsuario.setFont(meuEstiloDeFonte);
        campoSenha.setFont(meuEstiloDeFonte);
        campoEnderecoDoServidor.setFont(meuEstiloDeFonte);
        campoPortaDeConexao.setFont(meuEstiloDeFonte);
        campoNomeDoBanco.setFont(meuEstiloDeFonte);

        campoUsuario.setMaxWidth(comprimentoDosCampos);
        campoSenha.setMaxWidth(comprimentoDosCampos);
        campoEnderecoDoServidor.setMaxWidth(comprimentoDosCampos);
        campoPortaDeConexao.setMaxWidth(comprimentoDosCampos);
        campoNomeDoBanco.setMaxWidth(comprimentoDosCampos);

        vBox.getChildren().addAll(txtUsuario, campoUsuario,
                txtSenha, campoSenha,
                txtEnderecoDoServidor, campoEnderecoDoServidor,
                txtPortaDeConexao, campoPortaDeConexao,
                txtNomeDoBanco, campoNomeDoBanco);

        vBox.setSpacing(10);

        campoPortaDeConexao.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, filtroNumerico()));

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button salvarConfiguracoes = new Button("Salvar");
        salvarConfiguracoes.setFont(meuEstiloDeFonte);
        salvarConfiguracoes.setDisable(true);
        salvarConfiguracoes.setOnAction(e -> {
            try {
                salvarConfiguracoes();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button testarConexao = new Button("Testar Conexão");
        testarConexao.setFont(meuEstiloDeFonte);
        testarConexao.setOnAction(e -> {
            if (testarConexao()) {
                salvarConfiguracoes.setDisable(false);
            }
        });

        hBox.getChildren().addAll(salvarConfiguracoes, testarConexao);
        hBox.setSpacing(10);

        HBox hBoxRodape = new HBox();
        Label labelStatus = new Label();
        labelStatus.setStyle("-fx-background-color: #836FFF;");
        labelStatus.setMinHeight(25.0);
        labelStatus.setMaxWidth(Double.MAX_VALUE);
        hBoxRodape.getChildren().add(labelStatus);
        HBox.setHgrow(labelStatus, Priority.ALWAYS);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox);
        borderPane.setCenter(hBox);
        borderPane.setBottom(hBoxRodape);

        Scene scene = new Scene(borderPane, 400, 550);
        stage.setScene(scene);
        stage.setTitle("Configuração do banco de dados");
        stage.setResizable(false);
        stage.initOwner(stagePrincipal);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UTILITY);

        stage.showAndWait();
    }

    private boolean testarConexao() {

        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        String enderecoDoServidor = campoEnderecoDoServidor.getText();
        String portaDeConexao = campoPortaDeConexao.getText();
        String nomeDoBanco = campoNomeDoBanco.getText();

        boolean todosOsDadosForamPreenchidos = false;

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Dados insuficientes");

        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText(null);
        sucesso.setTitle("Conexão bem sucedida!");

        if (usuario.isBlank()) {
            alerta.setContentText("Você precisa digitar o usuário");
            alerta.showAndWait();
        } else if (senha.isBlank()) {
            alerta.setContentText("Você precisa digitar a senha");
            alerta.showAndWait();
        } else if (enderecoDoServidor.isBlank()) {
            alerta.setContentText("Informe o endereço do banco");
            alerta.showAndWait();
        } else if (portaDeConexao.isBlank()) {
            alerta.setContentText("Informe a porta de conexão");
            alerta.showAndWait();
        } else if (nomeDoBanco.isBlank()) {
            alerta.setContentText("Informe o nome do banco");
            alerta.showAndWait();
        } else {
            todosOsDadosForamPreenchidos = true;
        }

        if (todosOsDadosForamPreenchidos) {
            FabricaDeConexao fabricaDeConexao = new FabricaDeConexao(enderecoDoServidor, usuario, senha, portaDeConexao, nomeDoBanco);
            Connection con = fabricaDeConexao.iniciarConexao();

            try {
                if (!con.isClosed()) {
                    sucesso.setContentText("Você já pode salvar as configurações!");
                    sucesso.showAndWait();
                    con.close();
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public void salvarConfiguracoes() throws IOException {

        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        String enderecoDoServidor = campoEnderecoDoServidor.getText();
        String portaDeConexao = campoPortaDeConexao.getText();
        String nomeDoBanco = campoNomeDoBanco.getText();

        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        configuracoesDoAplicativo.novaConfiguracao("banco.nomeDoUsuario", usuario);
        configuracoesDoAplicativo.novaConfiguracao("banco.senhaDoUsuario", senha);
        configuracoesDoAplicativo.novaConfiguracao("banco.enderecoDoServidor", enderecoDoServidor);
        configuracoesDoAplicativo.novaConfiguracao("banco.portaDeConexao", portaDeConexao);
        configuracoesDoAplicativo.novaConfiguracao("banco.nomeDoBanco", nomeDoBanco);

        Alert salvoComSucesso = new Alert(Alert.AlertType.INFORMATION);
        salvoComSucesso.setTitle("Configurações salvas.");
        salvoComSucesso.setHeaderText(null);
        salvoComSucesso.setContentText("Suas configurações foram salvas!");
        salvoComSucesso.showAndWait();

        Main.habilitarBotaoEntrar(true);

        stage.close();
    }

    private UnaryOperator<TextFormatter.Change> filtroNumerico() {
        // TODO: Valida que há somente números e que estão entre 0 e 65535.
        return change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        };
    }
}
