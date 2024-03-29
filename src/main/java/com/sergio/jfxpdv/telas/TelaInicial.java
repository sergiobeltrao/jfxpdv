package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.menu.BarraRaizDoMenuLateral;
import com.sergio.jfxpdv.menu.MenuSessaoAtual;
import com.sergio.jfxpdv.diversos.Constantes;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static com.sergio.jfxpdv.diversos.Constantes.cssTelaPrincipal;

public class TelaInicial {

    private final VBox barraLateralEsquerda = new VBox();
    private final HBox barraSuperior = new HBox();
    private final Label labelSuperiorEsquerdo = new Label();
    public static ScrollPane painelCentral = new ScrollPane();

    public TelaInicial() {
    }

    public void abrirTelaPrincipal(Stage stage) {
        BorderPane borderPane = new BorderPane();
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(barraLateralEsquerda);
        scrollPane.getStyleClass().add("painel-de-rolagem");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        barraSuperior.getChildren().add(labelSuperiorEsquerdo);

        labelSuperiorEsquerdo.getStyleClass().add("label-superior-esquerdo");
        barraSuperior.getStyleClass().add("barra-superior");
        barraLateralEsquerda.getStyleClass().add("barra-lateral-esquerda");
        painelCentral.getStyleClass().add("painel-central");
        barraLateralEsquerda.getChildren().add(new BarraRaizDoMenuLateral().menu());

        labelSuperiorEsquerdo.setText("Bem-vindo(a) ao JFXPDV!");

        painelCentral.setContent(null);

        borderPane.setTop(barraSuperior);
        borderPane.setCenter(painelCentral);
        borderPane.setLeft(scrollPane);

        MenuSessaoAtual.botaoLogout.setOnAction(e -> new TelaDeLogin().start(stage));

        Scene scene = new Scene(borderPane, Constantes.resHorizontalMin, Constantes.resVerticalMin);
        scene.getStylesheets().add(Constantes.obterCss(cssTelaPrincipal));
        scene.getRoot().getStyleClass().add("theme-3");
        stage.setTitle("Tela de Teste");
        stage.setMinHeight(Constantes.resVerticalMin);
        stage.setMinWidth(Constantes.resHorizontalMin);
        stage.setScene(scene);
        stage.show();
    }
}
