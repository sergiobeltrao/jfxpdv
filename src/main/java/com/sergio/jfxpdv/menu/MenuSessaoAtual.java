package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.MenuLateral;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuSessaoAtual {

    public static final Button botaoLogout = new MenuLateral().itemDoSubMenu("Logout");
    private final Button botaoFechar = new MenuLateral().itemDoSubMenu("Fechar");

    public VBox menu() {
        MenuLateral menuLateral = new MenuLateral();

        botaoFechar.setOnAction(e -> System.exit(0));

        return menuLateral.raizDoGrupo("Sessão Atual", menuLateral.subMenu(
                botaoLogout,
                botaoFechar
        ));
    }
}
