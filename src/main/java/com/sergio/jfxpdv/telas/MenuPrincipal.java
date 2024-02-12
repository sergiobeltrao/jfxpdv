package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.Main;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuPrincipal {

    private final Menu menuInicio = new Menu("Início");
    private final Menu menuEstoque = new Menu("Estoque");
    private final Menu menuTerminalDeVendas = new Menu("Terminal de Vendas");
    private final Menu menuConfiguracoes = new Menu("Configurações");
    private final Menu menuAjuda = new Menu("Ajuda");

    // 1: Início
    private final MenuItem logout = new MenuItem("Logout");
    private final MenuItem fechar = new MenuItem("Fechar");

    // 2: Estoque
    private final MenuItem adicionarAoEstoque = new MenuItem("Adicionar ao Estoque");
    private final MenuItem editarProduto = new MenuItem("Editar Produto");
    private final MenuItem historicoDeEstoque = new MenuItem("Histórico de Estoque");

    // 3: Terminal de Vendas
    private final MenuItem vendas = new MenuItem("Vendas");
    private final MenuItem relatorios = new MenuItem("Relatórios");

    // 4: Configurações
    private final MenuItem alterarSenha = new MenuItem("Alterar Senha");
    private final MenuItem personalizacao = new MenuItem("Personalização");
    private final MenuItem formatoDeData = new MenuItem("Formato de Data");

    // 5: Ajuda
    private final MenuItem manualDoUsuario = new MenuItem("Manual do Usuário");
    private final MenuItem suporte = new MenuItem("Suporte");
    private final MenuItem verificarAtualizacoes = new MenuItem("Verificar Atualizações");
    private final MenuItem sobre = new MenuItem("Sobre");

    public MenuBar Menu() {

        MenuBar barraDeMenus = new MenuBar();

        barraDeMenus.getMenus().addAll(menuInicio, menuEstoque, menuTerminalDeVendas, menuConfiguracoes, menuAjuda);

        menuInicio.getItems().addAll(logout, fechar);
        menuEstoque.getItems().addAll(adicionarAoEstoque, editarProduto, historicoDeEstoque);
        menuTerminalDeVendas.getItems().addAll(vendas, relatorios);
        menuConfiguracoes.getItems().addAll(alterarSenha, personalizacao, formatoDeData);
        menuAjuda.getItems().addAll(manualDoUsuario, suporte, verificarAtualizacoes, sobre);

        inicio();
        estoque();
        terminalDeVendas();
        configuracoes();
        ajuda();

        return barraDeMenus;
    }

    private void inicio() {

        logout.setOnAction(e -> {
            new Main();
        });

        fechar.setOnAction(e -> System.exit(0));
    }

    private void estoque() {

    }

    private void terminalDeVendas() {

    }

    private void configuracoes() {

    }

    private void ajuda() {

    }
}
