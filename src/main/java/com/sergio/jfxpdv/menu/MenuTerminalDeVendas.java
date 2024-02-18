package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.MenuLateral;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuTerminalDeVendas {

    private final Button botaoAddVendas = new MenuLateral().itemDoSubMenu("Vendas");
    private final Button botaoRelatorios = new MenuLateral().itemDoSubMenu("Relatórios");

    public VBox menu() {
        MenuLateral menuLateral = new MenuLateral();
        return menuLateral.raizDoGrupo("Terminal de Vendas", menuLateral.subMenu(
                botaoAddVendas,
                botaoRelatorios
        ));
    }
}
