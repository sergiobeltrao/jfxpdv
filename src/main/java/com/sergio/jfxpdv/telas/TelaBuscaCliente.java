package com.sergio.jfxpdv.telas;

import com.sergio.jfxpdv.fabrica.CamposPadronizados;
import com.sergio.jfxpdv.modelo.Cliente;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TelaBuscaCliente {
    private final BorderPane borderPane = new BorderPane();

    public void buscarCliente() {

        VBox campoNome = new CamposPadronizados().textoAcimaDaBorda("Nome", false);
        Button botaoBuscar = new CamposPadronizados().botaoPadrao("Pesquisar");
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 20, 20, 20));

        TableView<Cliente> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Cliente, Integer> colunaId = new TableColumn<>("ID");
        TableColumn<Cliente, String> colunaTipo = new TableColumn<>("Tipo");
        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        TableColumn<Cliente, String> colunaCpfOuCnpj = new TableColumn<>("CPF/CNPJ");
        TableColumn<Cliente, String> colunaRg = new TableColumn<>("RG");
        TableColumn<Cliente, String> colunaTelefone = new TableColumn<>("Telefone");
        TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
        TableColumn<Cliente, String> colunaEstado = new TableColumn<>("Estado");
        TableColumn<Cliente, String> colunaCidade = new TableColumn<>("Cidade");
        TableColumn<Cliente, String> colunaRua = new TableColumn<>("Rua");
        TableColumn<Cliente, String> colunaBairro = new TableColumn<>("Bairro");
        TableColumn<Cliente, String> colunaCep = new TableColumn<>("CEP");
        TableColumn<Cliente, Integer> colunaNumero = new TableColumn<>("Número");
        TableColumn<Cliente, String> colunaComplemento = new TableColumn<>("Complemento");

        colunaId.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tipo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        colunaCpfOuCnpj.setCellValueFactory(new PropertyValueFactory<Cliente, String>("numeroDeCpfOuCnpj"));
        colunaRg.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rg"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory<Cliente, String>("estado"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cidade"));
        colunaRua.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rua"));
        colunaBairro.setCellValueFactory(new PropertyValueFactory<Cliente, String>("bairro"));
        colunaCep.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cep"));
        colunaNumero.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("numero"));
        colunaComplemento.setCellValueFactory(new PropertyValueFactory<Cliente, String>("complemento"));

        tableView.getColumns().addAll(
                colunaId, colunaTipo, colunaNome, colunaCpfOuCnpj,
                colunaRg, colunaTelefone, colunaEmail, colunaEstado,
                colunaCidade, colunaRua, colunaBairro, colunaCep,
                colunaNumero, colunaComplemento
        );


        vBox.getChildren().addAll(campoNome, tableView, botaoBuscar);
        borderPane.setCenter(vBox);

        TelaPrincipal.painelCentral.setContent(borderPane);
    }
}
