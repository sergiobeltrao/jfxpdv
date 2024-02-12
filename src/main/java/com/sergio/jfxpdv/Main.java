package com.sergio.jfxpdv;

import com.sergio.jfxpdv.modelo.ConfiguracoesDoAplicativo;
import com.sergio.jfxpdv.telas.ConfiguracaoBanco;
import com.sergio.jfxpdv.telas.TelaPrincipal;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    Stage stage = new Stage();

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

        TextField campoUsuario = new TextField();
        campoUsuario.setMaxWidth(comprimentoDosCampos);
        campoUsuario.setFont(new Font(fonteUsada, tamanhoDaFonte));

        Text senha = new Text("Senha");
        senha.setFont(new Font(fonteUsada, tamanhoDaFonte));

        PasswordField campoSenha = new PasswordField();
        campoSenha.setMaxWidth(comprimentoDosCampos);
        campoSenha.setFont(new Font(fonteUsada, tamanhoDaFonte));

        Button botaoEntrar = new Button("Entrar");
        botaoEntrar.setFont(new Font(fonteUsada, tamanhoDaFonte));
        botaoEntrar.setOnAction(e -> {
            new TelaPrincipal(stage);
        });

        vBox.getChildren().addAll(usuario, campoUsuario, senha, campoSenha, botaoEntrar);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(borderPane, 1280, 720);
        stage.setScene(scene);
        stage.setMinHeight(576);
        stage.setMinWidth(1024);
        stage.setTitle("Tela de Login");
        stage.show();

        new ConfiguracoesDoAplicativo().avisoDePrimeiraConfiguracao(new ConfiguracoesDoAplicativo().verificaConfiguracaoDoBanco());
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

    public static void main(String[] args) {
        launch();
    }
}
