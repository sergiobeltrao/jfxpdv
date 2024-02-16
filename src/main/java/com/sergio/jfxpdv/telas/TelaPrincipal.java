package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.modelo.MenuPrincipal;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class TelaPrincipal {

    private final String localizacaoDoCSS = "/com/sergio/jfxpdv/css/tela-inicial.css";
    private final String obterCss = Objects.requireNonNull(TelaPrincipal.class.getResource(localizacaoDoCSS)).toExternalForm();

    private final VBox barraLateralEsquerda = new VBox();
    private final HBox barraSuperior = new HBox();
    private final Label labelSuperiorEsquerdo = new Label();
    private final Pane painelCentral = new Pane();

    private final Stage stage = new Stage();

    public TelaPrincipal() {
    }

    public void abrirTelaPrincipal() {
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
        barraLateralEsquerda.getChildren().add(new MenuPrincipal().menu());

        borderPane.setTop(barraSuperior);
        borderPane.setCenter(painelCentral);
        borderPane.setLeft(scrollPane);

        Scene scene = new Scene(borderPane, 1280, 720);
        scene.getStylesheets().add(obterCss);
        scene.getRoot().getStyleClass().add("theme-3");
        stage.setTitle("Tela de Teste");
        stage.setMinHeight(720);
        stage.setMinWidth(1280);
        stage.setScene(scene);
        stage.show();
    }
}
