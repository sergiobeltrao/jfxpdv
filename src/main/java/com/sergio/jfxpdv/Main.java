package com.sergio.jfxpdv;

import com.sergio.jfxpdv.dao.UsuarioDAO;
import com.sergio.jfxpdv.modelo.ConfiguracoesDoAplicativo;
import com.sergio.jfxpdv.telas.ConfiguracaoBanco;
import com.sergio.jfxpdv.telas.TelaPrincipal;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    Stage stage = new Stage();
    private static final Button botaoEntrar = new Button("Entrar");

    private final PasswordField campoSenha = new PasswordField();
    private final TextField campoUsuario = new TextField();

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        String fonteUsada = "Inter";
        int tamanhoDaFonte = 15;
        double comprimentoDosCampos = 250.0;

        BorderPane borderPane = new BorderPane();

        Label labelRodape = new Label();
        labelRodape.setStyle("-fx-background-color: #836FFF;");
        labelRodape.setMaxHeight(50.0);
        labelRodape.setMaxWidth(Double.MAX_VALUE);

        HBox hboxRodape = new HBox();
        hboxRodape.getChildren().addAll(labelRodape, botaoDeConfiguracao());
        HBox.setHgrow(labelRodape, Priority.ALWAYS);

        VBox vBox = new VBox();
        vBox.setSpacing(10.0);

        borderPane.setCenter(vBox);
        borderPane.setBottom(hboxRodape);

        Text usuario = new Text("Usuário");
        usuario.setFont(new Font(fonteUsada, tamanhoDaFonte));

        campoUsuario.setMaxWidth(comprimentoDosCampos);
        campoUsuario.setFont(new Font(fonteUsada, tamanhoDaFonte));

        Text senha = new Text("Senha");
        senha.setFont(new Font(fonteUsada, tamanhoDaFonte));

        campoSenha.setMaxWidth(comprimentoDosCampos);
        campoSenha.setFont(new Font(fonteUsada, tamanhoDaFonte));


        habilitarBotaoEntrar(false);
        botaoEntrar.setFont(new Font(fonteUsada, tamanhoDaFonte));
        botaoEntrar.setOnAction(e -> {
            try {
                login();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        vBox.getChildren().addAll(usuario, campoUsuario, senha, campoSenha, botaoEntrar);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(borderPane, 1280, 720);
        stage.setScene(scene);
        stage.setMinHeight(576);
        stage.setMinWidth(1024);
        stage.setTitle("Tela de Login");
        stage.show();

        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        int codigoDeInicializacao = configuracoesDoAplicativo.verificaConfiguracaoDoBanco();
        configuracoesDoAplicativo.avisoDePrimeiraConfiguracao(codigoDeInicializacao);

        if (codigoDeInicializacao == 0) {
            habilitarBotaoEntrar(true);
        }
    }

    private Button botaoDeConfiguracao() {
        URL urlDoIcone = getClass().getResource("/com/sergio/jfxpdv/icons/settings.png");
        Button botaoConfiguracao = new Button();
        botaoConfiguracao.setStyle("-fx-background-color: #604af1; -fx-background-radius: 0;");
        botaoConfiguracao.setOnMousePressed(e -> botaoConfiguracao.setStyle("-fx-background-color: #224466; -fx-text-fill: white;"));
        Image iconImage = new Image(String.valueOf(urlDoIcone));
        ImageView iconImageView = new ImageView(iconImage);
        iconImageView.setFitWidth(25);
        iconImageView.setFitHeight(25);
        botaoConfiguracao.setGraphic(iconImageView);
        botaoConfiguracao.setOnAction(e -> {
            new ConfiguracaoBanco().start(stage);
        });
        return botaoConfiguracao;
    }

    public void login() throws IOException {
        String meuLogin = campoUsuario.getText();
        String minhaSenha = campoSenha.getText();

        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
        aviso.setHeaderText(null);
        aviso.setTitle("Aviso!");

        if (meuLogin.isBlank()) {
            aviso.setContentText("Digite o usuário");
            aviso.showAndWait();
        } else if (minhaSenha.isBlank()) {
            aviso.setContentText("Digite a senha");
            aviso.showAndWait();
        } else {
            // TODO: Implementar acesso para outros níveis de permissão.
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.iniciarSessao(meuLogin, minhaSenha).equals("ADMINISTRADOR")) {
                new TelaPrincipal().abrirTela();
                stage.close();
            } else {
                aviso.setContentText("Usuário ou senha errados. Verifique suas credenciais!");
                aviso.showAndWait();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public static void habilitarBotaoEntrar(boolean habilitar){
        botaoEntrar.setDisable(!habilitar);
    }
}
