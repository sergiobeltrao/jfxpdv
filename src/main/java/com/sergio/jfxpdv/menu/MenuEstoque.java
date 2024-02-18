package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.MenuLateral;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuEstoque {

    private final Button botaoAddEstoque = new MenuLateral().itemDoSubMenu("Adicionar ao Estoque");
    private final Button botaoEditProduto = new MenuLateral().itemDoSubMenu("Editar Produto");
    private final Button botaoHistoricoEstoque = new MenuLateral().itemDoSubMenu("Histórico de Estoque");

    public VBox menu() {
        MenuLateral menuLateral = new MenuLateral();
        return menuLateral.raizDoGrupo("Estoque", menuLateral.subMenu(
                botaoAddEstoque,
                botaoEditProduto,
                botaoHistoricoEstoque
        ));
    }
}
