package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.menu.MenuPrincipal;
import com.sergio.jfxpdv.menu.MenuSessaoAtual;
import com.sergio.jfxpdv.modelo.Constantes;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static com.sergio.jfxpdv.modelo.Constantes.cssTelaPrincipal;

public class TelaPrincipal {

    private final VBox barraLateralEsquerda = new VBox();
    private final HBox barraSuperior = new HBox();
    private final Label labelSuperiorEsquerdo = new Label();
    private final Pane painelCentral = new Pane();

    public TelaPrincipal() {
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
        barraLateralEsquerda.getChildren().add(new MenuPrincipal().menu());

        labelSuperiorEsquerdo.setText("Bem-vindo(a) ao JFXPDV!");

        borderPane.setTop(barraSuperior);
        borderPane.setCenter(painelCentral);
        borderPane.setLeft(scrollPane);

        MenuSessaoAtual.botaoLogout.setOnAction(e -> {
            try {
                new TelaDeLogin().start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Scene scene = new Scene(borderPane, 1280, 720);
        scene.getStylesheets().add(Constantes.obterCss(cssTelaPrincipal));
        scene.getRoot().getStyleClass().add("theme-3");
        stage.setTitle("Tela de Teste");
        stage.setMinHeight(Constantes.resVerticalMin);
        stage.setMinWidth(Constantes.resHorizontalMin);
        stage.setScene(scene);
        stage.show();
    }
}
