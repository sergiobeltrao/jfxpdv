package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.GeradorDeMenus;
import com.sergio.jfxpdv.telas.TelaDeBuscaDeCliente;
import com.sergio.jfxpdv.telas.TelaDeCadastroDeCliente;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuClientes {

    private final Button botaoCadastrar = new GeradorDeMenus().itemDoSubMenu("Cadastrar");
    private final Button botaoBuscar = new GeradorDeMenus().itemDoSubMenu("Buscar");

    public VBox menu() {
        GeradorDeMenus geradorDeMenus = new GeradorDeMenus();

        botaoCadastrar.setOnAction(e -> cadastrar());

        botaoBuscar.setOnAction(e -> buscar());

        return geradorDeMenus.raizDoGrupo("Clientes", geradorDeMenus.subMenu(
                botaoCadastrar,
                botaoBuscar)
        );
    }

    private void cadastrar() {
        new TelaDeCadastroDeCliente().cadastrarCliente();
    }

    private void buscar() {
        new TelaDeBuscaDeCliente().buscarCliente();
    }
}
