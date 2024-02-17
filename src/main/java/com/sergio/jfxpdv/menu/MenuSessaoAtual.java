package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.modelo.Constantes;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.sergio.jfxpdv.modelo.Constantes.cssMenu;

public class MenuSessaoAtual {

    public static final Button botaoLogout = new Button();
    private final Button botaoFechar = new Button();

    public VBox menu() {
        VBox vBoxTerminarSessao = new VBox();
        vBoxTerminarSessao.getStylesheets().add(Constantes.obterCss(cssMenu));
        vBoxTerminarSessao.getStyleClass().add("vbox-menu");

        Button botaoTerminarSessao = new Button();
        botaoTerminarSessao.setText("Sessão Atual");
        botaoTerminarSessao.setAlignment(Pos.CENTER_LEFT);

        botaoTerminarSessao.getStyleClass().add("button-menu");
        VBox vBoxSubTerminarSessao = new VBox();

        vBoxTerminarSessao.getChildren().addAll(botaoTerminarSessao, vBoxSubTerminarSessao);

        botaoTerminarSessao.setOnAction(e -> {
            if (vBoxSubTerminarSessao.getChildren().isEmpty()) {
                vBoxSubTerminarSessao.getChildren().add(subMenu());
            } else {
                vBoxSubTerminarSessao.getChildren().clear();
            }
        });

        return vBoxTerminarSessao;
    }

    private VBox subMenu() {
        VBox vBoxSubMenuTerminarSessao = new VBox();
        vBoxSubMenuTerminarSessao.getStyleClass().add("vbox-submenu");

        botaoLogout.setText("Logout");
        botaoLogout.getStyleClass().add("button-submenu");
        botaoLogout.setAlignment(Pos.CENTER_LEFT);

        botaoFechar.setText("Fechar");
        botaoFechar.getStyleClass().add("button-submenu");
        botaoFechar.setAlignment(Pos.CENTER_LEFT);
        botaoFechar.setOnAction(e -> System.exit(0));

        vBoxSubMenuTerminarSessao.getChildren().addAll(botaoLogout, botaoFechar);

        return vBoxSubMenuTerminarSessao;
    }
}
