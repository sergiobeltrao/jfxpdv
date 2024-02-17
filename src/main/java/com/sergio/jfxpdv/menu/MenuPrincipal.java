package com.sergio.jfxpdv.menu;

import com.sergio.jfxpdv.modelo.Constantes;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.sergio.jfxpdv.modelo.Constantes.cssMenu;

public class MenuPrincipal {

    public VBox menu() {
        VBox vBoxMenu = new VBox();
        vBoxMenu.getChildren().addAll(menuEstoque(), menuTerminalDeVendas(), menuConfiguracoes(), menuAjuda(), new MenuSessaoAtual().menu());
        return vBoxMenu;
    }

    private VBox menuEstoque() {
        VBox vBoxRaizEstoque = new VBox();
        vBoxRaizEstoque.getStylesheets().add(Constantes.obterCss(cssMenu));
        vBoxRaizEstoque.getStyleClass().add("vbox-menu");

        Button botaoEstoque = new Button();
        botaoEstoque.setText("Estoque");
        botaoEstoque.setAlignment(Pos.CENTER_LEFT);

        botaoEstoque.getStyleClass().add("button-menu");
        VBox vBoxSubMenuEstoque = new VBox();

        vBoxRaizEstoque.getChildren().addAll(botaoEstoque, vBoxSubMenuEstoque);

        botaoEstoque.setOnAction(e -> {
            if (vBoxSubMenuEstoque.getChildren().isEmpty()) {
                vBoxSubMenuEstoque.getChildren().add(subMenuEstoque());
            } else {
                vBoxSubMenuEstoque.getChildren().clear();
            }
        });

        return vBoxRaizEstoque;
    }

    private VBox subMenuEstoque() {
        VBox vBoxSubMenu = new VBox();
        vBoxSubMenu.getStyleClass().add("vbox-submenu");

        Button botaoAddEstoque = new Button();
        botaoAddEstoque.setText("Adicionar ao Estoque");
        botaoAddEstoque.getStyleClass().add("button-submenu");
        botaoAddEstoque.setAlignment(Pos.CENTER_LEFT);

        Button botaoEditProduto = new Button();
        botaoEditProduto.setText("Editar Produto");
        botaoEditProduto.getStyleClass().add("button-submenu");
        botaoEditProduto.setAlignment(Pos.CENTER_LEFT);

        Button botaoHistoricoEstoque = new Button();
        botaoHistoricoEstoque.setText("Histórico de Estoque");
        botaoHistoricoEstoque.getStyleClass().add("button-submenu");
        botaoHistoricoEstoque.setAlignment(Pos.CENTER_LEFT);

        vBoxSubMenu.getChildren().addAll(botaoAddEstoque, botaoEditProduto, botaoHistoricoEstoque);

        return vBoxSubMenu;
    }

    private VBox menuTerminalDeVendas() {
        VBox vBoxRaizTerminalDeVendas = new VBox();
        vBoxRaizTerminalDeVendas.getStylesheets().add(Constantes.obterCss(cssMenu));
        vBoxRaizTerminalDeVendas.getStyleClass().add("vbox-menu");

        Button botaoTerminalDeVendas = new Button();
        botaoTerminalDeVendas.setText("Terminal de Vendas");
        botaoTerminalDeVendas.setAlignment(Pos.CENTER_LEFT);

        botaoTerminalDeVendas.getStyleClass().add("button-menu");
        VBox vBoxSubMenuTVendas = new VBox();

        vBoxRaizTerminalDeVendas.getChildren().addAll(botaoTerminalDeVendas, vBoxSubMenuTVendas);

        botaoTerminalDeVendas.setOnAction(e -> {
            if (vBoxSubMenuTVendas.getChildren().isEmpty()) {
                vBoxSubMenuTVendas.getChildren().add(subMenuTerminalDeVendas());
            } else {
                vBoxSubMenuTVendas.getChildren().clear();
            }
        });

        return vBoxRaizTerminalDeVendas;
    }

    private VBox subMenuTerminalDeVendas() {
        VBox vBoxSubMenuTVendas = new VBox();
        vBoxSubMenuTVendas.getStyleClass().add("vbox-submenu");

        Button botaoAddVendas = new Button();
        botaoAddVendas.setText("Vendas");
        botaoAddVendas.getStyleClass().add("button-submenu");
        botaoAddVendas.setAlignment(Pos.CENTER_LEFT);

        Button botaoRelatorios = new Button();
        botaoRelatorios.setText("Relatórios");
        botaoRelatorios.getStyleClass().add("button-submenu");
        botaoRelatorios.setAlignment(Pos.CENTER_LEFT);

        vBoxSubMenuTVendas.getChildren().addAll(botaoAddVendas, botaoRelatorios);

        return vBoxSubMenuTVendas;
    }

    private VBox menuConfiguracoes() {
        VBox vBoxRaizConfiguracoes = new VBox();
        vBoxRaizConfiguracoes.getStylesheets().add(Constantes.obterCss(cssMenu));
        vBoxRaizConfiguracoes.getStyleClass().add("vbox-menu");

        Button botaoConfiguracoes = new Button();
        botaoConfiguracoes.setText("Configurações");
        botaoConfiguracoes.setAlignment(Pos.CENTER_LEFT);

        botaoConfiguracoes.getStyleClass().add("button-menu");
        VBox vBoxSubMenuConfiguracoes = new VBox();

        vBoxRaizConfiguracoes.getChildren().addAll(botaoConfiguracoes, vBoxSubMenuConfiguracoes);

        botaoConfiguracoes.setOnAction(e -> {
            if (vBoxSubMenuConfiguracoes.getChildren().isEmpty()) {
                vBoxSubMenuConfiguracoes.getChildren().add(subMenuConfiguracoes());
            } else {
                vBoxSubMenuConfiguracoes.getChildren().clear();
            }
        });

        return vBoxRaizConfiguracoes;
    }

    private VBox subMenuConfiguracoes() {
        VBox vBoxSubMenuConfiguracoes = new VBox();
        vBoxSubMenuConfiguracoes.getStyleClass().add("vbox-submenu");

        Button botaoAlterarSenha = new Button();
        botaoAlterarSenha.setText("Alterar Senha");
        botaoAlterarSenha.getStyleClass().add("button-submenu");
        botaoAlterarSenha.setAlignment(Pos.CENTER_LEFT);

        Button botaoPersonalizacoes = new Button();
        botaoPersonalizacoes.setText("Personalizações");
        botaoPersonalizacoes.getStyleClass().add("button-submenu");
        botaoPersonalizacoes.setAlignment(Pos.CENTER_LEFT);

        vBoxSubMenuConfiguracoes.getChildren().addAll(botaoAlterarSenha, botaoPersonalizacoes);

        return vBoxSubMenuConfiguracoes;
    }

    private VBox menuAjuda() {
        VBox vBoxRaizAjuda = new VBox();
        vBoxRaizAjuda.getStylesheets().add(Constantes.obterCss(cssMenu));
        vBoxRaizAjuda.getStyleClass().add("vbox-menu");

        Button botaoAjuda = new Button();
        botaoAjuda.setText("Ajuda");
        botaoAjuda.setAlignment(Pos.CENTER_LEFT);

        botaoAjuda.getStyleClass().add("button-menu");
        VBox vBoxSubMenuAjuda = new VBox();

        vBoxRaizAjuda.getChildren().addAll(botaoAjuda, vBoxSubMenuAjuda);

        botaoAjuda.setOnAction(e -> {
            if (vBoxSubMenuAjuda.getChildren().isEmpty()) {
                vBoxSubMenuAjuda.getChildren().add(subMenuAjuda());
            } else {
                vBoxSubMenuAjuda.getChildren().clear();
            }
        });

        return vBoxRaizAjuda;
    }

    private VBox subMenuAjuda() {
        VBox vBoxSubMenuAjuda = new VBox();
        vBoxSubMenuAjuda.getStyleClass().add("vbox-submenu");

        Button botaoManualDoUsuario = new Button();
        botaoManualDoUsuario.setText("Manual do Usuário");
        botaoManualDoUsuario.getStyleClass().add("button-submenu");
        botaoManualDoUsuario.setAlignment(Pos.CENTER_LEFT);

        Button botaoSuporte = new Button();
        botaoSuporte.setText("Suporte");
        botaoSuporte.getStyleClass().add("button-submenu");
        botaoSuporte.setAlignment(Pos.CENTER_LEFT);

        Button botaoVerificarAtualizacoes = new Button();
        botaoVerificarAtualizacoes.setText("Verificar Atualizações");
        botaoVerificarAtualizacoes.getStyleClass().add("button-submenu");
        botaoVerificarAtualizacoes.setAlignment(Pos.CENTER_LEFT);

        Button botaoSobre = new Button();
        botaoSobre.setText("Sobre");
        botaoSobre.getStyleClass().add("button-submenu");
        botaoSobre.setAlignment(Pos.CENTER_LEFT);

        vBoxSubMenuAjuda.getChildren().addAll(botaoManualDoUsuario, botaoSuporte, botaoVerificarAtualizacoes, botaoSobre);

        return vBoxSubMenuAjuda;
    }
}
