package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.GeradorDeMenus;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuTerminalDeVendas {

    private final Button botaoAddVendas = new GeradorDeMenus().itemDoSubMenu("Vendas");
    private final Button botaoRelatorios = new GeradorDeMenus().itemDoSubMenu("Relatórios");

    public VBox menu() {
        GeradorDeMenus geradorDeMenus = new GeradorDeMenus();
        return geradorDeMenus.raizDoGrupo("Terminal de Vendas", geradorDeMenus.subMenu(
                botaoAddVendas,
                botaoRelatorios
        ));
    }
}
