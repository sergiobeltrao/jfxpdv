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

        VBox campoNome = new CamposPadronizados().textoAcimaDaBorda("Nome");
        Button botaoBuscar = new CamposPadronizados().botaoPadrao("Pesquisar");
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 20, 20, 20));

        TableView<Cliente> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Cliente, Integer> colunaId = new TableColumn<>("ID");
        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        TableColumn<Cliente, String> colunarg = new TableColumn<>("RG");
        TableColumn<Cliente, String> colunaCpf = new TableColumn<>("CPF");
        TableColumn<Cliente, String> colunaTelefone = new TableColumn<>("Telefone");
        TableColumn<Cliente, String> colunaCelular = new TableColumn<>("Celular");
        TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
        TableColumn<Cliente, String> colunaBairro = new TableColumn<>("Bairro");
        TableColumn<Cliente, String> colunaRua = new TableColumn<>("Rua");
        TableColumn<Cliente, Integer> colunaNumero = new TableColumn<>("Número");
        TableColumn<Cliente, String> colunaComplemento = new TableColumn<>("Complemento");
        TableColumn<Cliente, String> colunaCep = new TableColumn<>("CEP");
        TableColumn<Cliente, String> colunaCidade = new TableColumn<>("Cidade");
        TableColumn<Cliente, String> colunaEstado = new TableColumn<>("Estado");

        colunaId.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        colunarg.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rg"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        colunaCelular.setCellValueFactory(new PropertyValueFactory<Cliente, String>("celular"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        colunaBairro.setCellValueFactory(new PropertyValueFactory<Cliente, String>("bairro"));
        colunaRua.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rua"));
        colunaNumero.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("numero"));
        colunaComplemento.setCellValueFactory(new PropertyValueFactory<Cliente, String>("complemento"));
        colunaCep.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cep"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cidade"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory<Cliente, String>("estado"));

        tableView.getColumns().addAll(
                colunaId, colunaNome, colunarg,
                colunaCpf, colunaTelefone, colunaCelular,
                colunaEmail, colunaBairro, colunaRua,
                colunaNumero, colunaComplemento, colunaCep,
                colunaCidade, colunaEstado);


        vBox.getChildren().addAll(campoNome, tableView, botaoBuscar);
        borderPane.setCenter(vBox);

        TelaPrincipal.painelCentral.setContent(borderPane);
    }
}
