package com.sergio.jfxpdv.dao;

import com.sergio.jfxpdv.fabrica.FabricaDeConexao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public String iniciarSessao(String login, String senha) throws IOException {
        FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
        Connection conexaoBanco = fabricaDeConexao.iniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nivelDeAcesso = null;
        String[] niveisDeAcessoParaVerificar = {"ADMINISTRADOR", "GERENTE", "CAIXA"};

        try {
            for (String nivelDeAcessoVerificado : niveisDeAcessoParaVerificar) {
                stmt = conexaoBanco.prepareStatement("SELECT * FROM USUARIOS WHERE LOGIN = ? AND SENHA = ? AND NIVEL_DE_ACESSO = ?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                stmt.setString(3, nivelDeAcessoVerificado);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    nivelDeAcesso = nivelDeAcessoVerificado;
                    break;
                } else {
                    nivelDeAcesso = "Inválido";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaDeConexao.closeConnection(conexaoBanco, stmt, rs);
        }
        return nivelDeAcesso;
    }
}
