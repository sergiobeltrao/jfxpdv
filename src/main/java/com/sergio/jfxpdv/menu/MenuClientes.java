package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.modelo.Constantes;
import com.sergio.jfxpdv.telas.TelaBuscaCliente;
import com.sergio.jfxpdv.telas.TelaCadastroCliente;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.sergio.jfxpdv.modelo.Constantes.cssMenu;

public class MenuClientes {

    private final Button cadastroClientes = new Button();
    private final Button buscarClientes = new Button();

    public VBox menu() {
        VBox vBoxClientes = new VBox();
        vBoxClientes.getStylesheets().add(Constantes.obterCss(cssMenu));
        vBoxClientes.getStyleClass().add("vbox-menu");

        Button cadastroClientes = new Button();
        cadastroClientes.setText("Clientes");
        cadastroClientes.setAlignment(Pos.CENTER_LEFT);

        cadastroClientes.getStyleClass().add("button-menu");
        VBox vBoxSubClientes = new VBox();

        vBoxClientes.getChildren().addAll(cadastroClientes, vBoxSubClientes);

        cadastroClientes.setOnAction(e -> {
            if (vBoxSubClientes.getChildren().isEmpty()) {
                vBoxSubClientes.getChildren().add(subMenu());
            } else {
                vBoxSubClientes.getChildren().clear();
            }
        });

        return vBoxClientes;
    }

    private VBox subMenu() {
        VBox vBoxSubMenuClientes = new VBox();
        vBoxSubMenuClientes.getStyleClass().add("vbox-submenu");

        cadastroClientes.setText("Cadastrar");
        cadastroClientes.getStyleClass().add("button-submenu");
        cadastroClientes.setAlignment(Pos.CENTER_LEFT);
        cadastroClientes.setOnAction(e -> cadastrar());

        buscarClientes.setText("Buscar");
        buscarClientes.getStyleClass().add("button-submenu");
        buscarClientes.setAlignment(Pos.CENTER_LEFT);
        buscarClientes.setOnAction(e -> buscar());

        vBoxSubMenuClientes.getChildren().addAll(cadastroClientes, buscarClientes);

        return vBoxSubMenuClientes;
    }

    private void cadastrar() {
        new TelaCadastroCliente().cadastrarCliente();
    }

    private void buscar() {
        new TelaBuscaCliente().buscarCliente();
    }
}
