package com.sergio.jfxpdv.fabrica;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.sergio.jfxpdv.modelo.Constantes.cssMenu;
import static com.sergio.jfxpdv.modelo.Constantes.obterCss;

public class MenuLateral {

    public VBox raizDoGrupo(String nome, VBox subMenu) {
        VBox vBox = new VBox();
        vBox.getStylesheets().add(obterCss(cssMenu));
        vBox.getStyleClass().add("vbox-menu");

        Button botaoRaizDoGrupo = new Button();
        botaoRaizDoGrupo.setText(nome);
        botaoRaizDoGrupo.setAlignment(Pos.CENTER_LEFT);

        botaoRaizDoGrupo.getStyleClass().add("button-menu");
        VBox vBoxSubMenu = new VBox();

        vBox.getChildren().addAll(botaoRaizDoGrupo, vBoxSubMenu);

        botaoRaizDoGrupo.setOnAction(e -> {
            if (vBoxSubMenu.getChildren().isEmpty()) {
                vBoxSubMenu.getChildren().add(subMenu);
            } else {
                vBoxSubMenu.getChildren().clear();
            }
        });

        return vBox;
    }

    public VBox subMenu(Button... itens) {
        VBox vBoxSubMenu = new VBox();
        vBoxSubMenu.getStyleClass().add("vbox-submenu");
        vBoxSubMenu.getChildren().addAll(itens);
        return vBoxSubMenu;
    }

    public Button itemDoSubMenu(String nome) {
        Button botaoItemDoSubMenu = new Button();
        botaoItemDoSubMenu.setText(nome);
        botaoItemDoSubMenu.getStyleClass().add("button-submenu");
        botaoItemDoSubMenu.setAlignment(Pos.CENTER_LEFT);
        return botaoItemDoSubMenu;
    }
}
