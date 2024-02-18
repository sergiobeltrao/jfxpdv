package com.sergio.jfxpdv.menu;

import javafx.scene.layout.VBox;

public class BarraLateral {

    public VBox menu() {
        VBox vBoxMenu = new VBox();
        vBoxMenu.getChildren().addAll(
                new MenuClientes().menu(),
                new MenuEstoque().menu(),
                new MenuTerminalDeVendas().menu(),
                new MenuConfiguracoes().menu(),
                new MenuAjuda().menu(),
                new MenuSessaoAtual().menu());

        return vBoxMenu;
    }
}