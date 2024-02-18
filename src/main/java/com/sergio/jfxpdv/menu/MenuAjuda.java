package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.MenuLateral;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuAjuda {

    private final Button botaoManualDoUsuario = new MenuLateral().itemDoSubMenu("Manual do Usuário");
    private final Button botaoSuporte = new MenuLateral().itemDoSubMenu("Suporte");
    private final Button botaoVerificarAtualizacoes = new MenuLateral().itemDoSubMenu("Verificar Atualizações");
    private final Button botaoSobre = new MenuLateral().itemDoSubMenu("Sobre");

    public VBox menu() {
        MenuLateral menuLateral = new MenuLateral();
        return menuLateral.raizDoGrupo("Ajuda", menuLateral.subMenu(
                botaoManualDoUsuario,
                botaoSuporte,
                botaoVerificarAtualizacoes,
                botaoSobre
        ));
    }
}
