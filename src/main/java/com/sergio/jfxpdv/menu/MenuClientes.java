package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.fabrica.MenuLateral;
import com.sergio.jfxpdv.telas.TelaBuscaCliente;
import com.sergio.jfxpdv.telas.TelaCadastroCliente;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuClientes {

    private final Button botaoCadastrar = new MenuLateral().itemDoSubMenu("Cadastrar");
    private final Button botaoBuscar = new MenuLateral().itemDoSubMenu("Buscar");

    public VBox menu() {
        MenuLateral menuLateral = new MenuLateral();

        botaoCadastrar.setOnAction(e -> cadastrar());

        botaoBuscar.setOnAction(e -> buscar());

        return menuLateral.raizDoGrupo("Clientes", menuLateral.subMenu(
                botaoCadastrar,
                botaoBuscar)
        );
    }

    private void cadastrar() {
        new TelaCadastroCliente().cadastrarCliente();
    }

    private void buscar() {
        new TelaBuscaCliente().buscarCliente();
    }
}
