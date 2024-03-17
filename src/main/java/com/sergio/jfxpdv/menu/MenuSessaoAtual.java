package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.GeradorDeMenus;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuSessaoAtual {

    public static final Button botaoLogout = new GeradorDeMenus().itemDoSubMenu("Logout");
    private final Button botaoFechar = new GeradorDeMenus().itemDoSubMenu("Fechar");

    public VBox menu() {
        GeradorDeMenus geradorDeMenus = new GeradorDeMenus();

        botaoFechar.setOnAction(e -> System.exit(0));

        return geradorDeMenus.raizDoGrupo("Sessão Atual", geradorDeMenus.subMenu(
                botaoLogout,
                botaoFechar
        ));
    }
}
