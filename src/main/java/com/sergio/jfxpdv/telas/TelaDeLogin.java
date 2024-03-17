package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.dao.UsuarioDAO;
import com.sergio.jfxpdv.diversos.ConfiguracoesDoAplicativo;
import com.sergio.jfxpdv.diversos.Constantes;
import com.sergio.jfxpdv.diversos.GeradorDeHash;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import static com.sergio.jfxpdv.diversos.Constantes.cssTelaDeLogin;
import static com.sergio.jfxpdv.diversos.Constantes.txtFieldMedio;

public class TelaDeLogin extends Application {

    private Stage stage = new Stage();
    private final Text txtUsuario = new Text("Usuário");
    private final TextField campoUsuario = new TextField();
    private final Text txtSenha = new Text("Senha");
    private final PasswordField campoSenha = new PasswordField();
    private static final Button botaoEntrar = new Button("Entrar");

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(boxLogin());
        borderPane.setBottom(boxRodape());
        borderPane.getStyleClass().add("border-pane");

        Scene scene = new Scene(borderPane, 1280, 720);

        scene.getStylesheets().add(Constantes.obterCss(cssTelaDeLogin));

        stage.setScene(scene);
        stage.setMinHeight(Constantes.resVerticalMin);
        stage.setMinWidth(Constantes.resHorizontalMin);
        stage.setTitle("Tela de Login");
        stage.show();

        verificaAsConfiguracoes();
    }

    private VBox boxLogin() {
        VBox vboxLogin = new VBox();
        vboxLogin.getStyleClass().add("vbox-login");

        vboxLogin.getChildren().addAll(txtUsuario, campoUsuario, txtSenha, campoSenha, botaoEntrar);
        campoUsuario.setMinWidth(txtFieldMedio);
        campoUsuario.setMinHeight(Constantes.alturaMinimaCampos);
        campoSenha.setMinWidth(txtFieldMedio);
        campoSenha.setMinHeight(Constantes.alturaMinimaCampos);

        habilitaBotaoEntrar(false);

        botaoEntrar.setOnAction(e -> {
            try {
                iniciaSessao();
            } catch (IOException | NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
        });

        return vboxLogin;
    }

    private HBox boxRodape() {
        HBox hboxRodape = new HBox();
        hboxRodape.getStyleClass().add("label-rodape");

        Label labelRodape = new Label();

        hboxRodape.getChildren().addAll(labelRodape, botaoDeConfiguracaoDoBanco());
        HBox.setHgrow(labelRodape, Priority.ALWAYS);

        return hboxRodape;
    }

    private Button botaoDeConfiguracaoDoBanco() {
        URL urlDoIcone = getClass().getResource("/com/sergio/jfxpdv/icons/settings.png");
        Button botaoConfiguracao = new Button();

        botaoConfiguracao.getStyleClass().add("button-configuracao-banco");
        botaoConfiguracao.setOnMousePressed(e -> botaoConfiguracao.getStyleClass().add("button-configuracao-banco-clique"));
        Image iconImage = new Image(String.valueOf(urlDoIcone));
        ImageView iconImageView = new ImageView(iconImage);
        iconImageView.setFitWidth(25);
        iconImageView.setFitHeight(25);
        botaoConfiguracao.setGraphic(iconImageView);
        botaoConfiguracao.setOnAction(e -> new TelaDeConfiguracaoDoBanco().start(stage));
        return botaoConfiguracao;
    }

    private void verificaAsConfiguracoes() throws Exception {
        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        int codigoDeInicializacao = configuracoesDoAplicativo.verificaConfiguracaoDoBanco();

        if (codigoDeInicializacao == 0) {
            habilitaBotaoEntrar(true);
        } else {
            configuracoesDoAplicativo.avisosDeInicializacao();
        }
    }

    private void iniciaSessao() throws IOException, NoSuchAlgorithmException {

        GeradorDeHash geradorDeHash = new GeradorDeHash();

        String hashDoLogin = geradorDeHash.geradorDeHash(campoUsuario.getText().toLowerCase(Locale.ROOT));
        String hashDaSenha = geradorDeHash.geradorDeHash(campoSenha.getText());
        String validador = geradorDeHash.geradorDeHash(hashDoLogin + hashDaSenha);

        Alert aviso = new Alert(Alert.AlertType.INFORMATION);

        DialogPane dialogPane = aviso.getDialogPane();
        dialogPane.getStylesheets().add(Constantes.obterCss(cssTelaDeLogin));
        dialogPane.getStyleClass().add("padrao-geral-texto");

        aviso.setHeaderText(null);
        aviso.setTitle("Atenção!");

        if (campoUsuario.getText().isBlank() || campoSenha.getText().isBlank()) {
            aviso.setContentText("Por favor, informe o nome de usuário e senha.");
            aviso.showAndWait();
        } else {
            UsuarioDAO dao = new UsuarioDAO();
            String nivelDeAcesso = dao.iniciarSessao(hashDoLogin, validador);

            switch (nivelDeAcesso) {
                case "ADMINISTRADOR", "GERENTE", "CAIXA" -> new TelaInicial().abrirTelaPrincipal(stage);
                default -> {
                    aviso.setContentText("Nome de usuário ou senha incorretos. Por favor, verifique suas credenciais!");
                    aviso.showAndWait();
                }
            }
        }
    }

    public static void habilitaBotaoEntrar(boolean habilitar) {
        botaoEntrar.setDisable(!habilitar);
    }

    public static void main(String[] args) {
        launch();
    }
}
