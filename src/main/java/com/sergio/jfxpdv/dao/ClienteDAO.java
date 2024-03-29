package com.sergio.jfxpdv.dao;

import com.sergio.jfxpdv.fabrica.ConexaoComBanco;
import com.sergio.jfxpdv.fabrica.JanelasDeDialogo;
import com.sergio.jfxpdv.modelo.Cliente;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public void cadastroCliente(Cliente cliente) {
        Connection conexao = new ConexaoComBanco().iniciarConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO CLIENTES(TIPO, NOME, CPF_CNPJ, TELEFONE, EMAIL, ESTADO, CIDADE, RUA, BAIRRO, CEP, NUMERO, COMPLEMENTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, cliente.getTipo());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getNumeroDeCpfOuCnpj());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getEstado());
            stmt.setString(7, cliente.getCidade());
            stmt.setString(8, cliente.getRua());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getCep());
            stmt.setString(11, cliente.getNumero());
            stmt.setString(12, cliente.getComplemento());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JanelasDeDialogo.dialogoPadrao("Erro ao cadastrar cliente!", "Detalhes do erro: " + ex.getMessage(), Alert.AlertType.ERROR);
        } finally {
            ConexaoComBanco.fecharConexao(conexao, stmt);
        }
    }
}
