package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.GeradorDeMenus;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuEstoque {

    private final Button botaoAddEstoque = new GeradorDeMenus().itemDoSubMenu("Adicionar ao Estoque");
    private final Button botaoEditProduto = new GeradorDeMenus().itemDoSubMenu("Editar Produto");
    private final Button botaoHistoricoEstoque = new GeradorDeMenus().itemDoSubMenu("Histórico de Estoque");

    public VBox menu() {
        GeradorDeMenus geradorDeMenus = new GeradorDeMenus();
        return geradorDeMenus.raizDoGrupo("Estoque", geradorDeMenus.subMenu(
                botaoAddEstoque,
                botaoEditProduto,
                botaoHistoricoEstoque
        ));
    }
}
