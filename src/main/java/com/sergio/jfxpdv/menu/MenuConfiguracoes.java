package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.MenuLateral;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuConfiguracoes {

    private final Button botaoAlterarSenha = new MenuLateral().itemDoSubMenu("Alterar Senha");
    private final Button botaoPersonalizacoes = new MenuLateral().itemDoSubMenu("Personalizações");

    public VBox menu() {
        MenuLateral menuLateral = new MenuLateral();
        return menuLateral.raizDoGrupo("Configurações", menuLateral.subMenu(
                botaoAlterarSenha,
                botaoPersonalizacoes
        ));
    }
}
