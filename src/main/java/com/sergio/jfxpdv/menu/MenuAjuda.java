package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.GeradorDeMenus;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuAjuda {

    private final Button botaoManualDoUsuario = new GeradorDeMenus().itemDoSubMenu("Manual do Usuário");
    private final Button botaoSuporte = new GeradorDeMenus().itemDoSubMenu("Suporte");
    private final Button botaoVerificarAtualizacoes = new GeradorDeMenus().itemDoSubMenu("Verificar Atualizações");
    private final Button botaoSobre = new GeradorDeMenus().itemDoSubMenu("Sobre");

    public VBox menu() {
        GeradorDeMenus geradorDeMenus = new GeradorDeMenus();
        return geradorDeMenus.raizDoGrupo("Ajuda", geradorDeMenus.subMenu(
                botaoManualDoUsuario,
                botaoSuporte,
                botaoVerificarAtualizacoes,
                botaoSobre
        ));
    }
}
