package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.GeradorDeMenus;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuConfiguracoes {

    private final Button botaoAlterarSenha = new GeradorDeMenus().itemDoSubMenu("Alterar Senha");
    private final Button botaoPersonalizacoes = new GeradorDeMenus().itemDoSubMenu("Personalizações");

    public VBox menu() {
        GeradorDeMenus geradorDeMenus = new GeradorDeMenus();
        return geradorDeMenus.raizDoGrupo("Configurações", geradorDeMenus.subMenu(
                botaoAlterarSenha,
                botaoPersonalizacoes
        ));
    }
}
