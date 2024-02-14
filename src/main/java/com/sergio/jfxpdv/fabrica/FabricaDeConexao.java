package com.sergio.jfxpdv.fabrica;

import com.sergio.jfxpdv.modelo.ConfiguracoesDoAplicativo;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FabricaDeConexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String enderecoDoServidor;
    private static String usuario;
    private static String senha;
    private static String porta;
    private static String nomeDoBanco;

    public FabricaDeConexao(String enderecoDoServidor, String usuario, String senha, String porta, String nomeDoBanco) {
        FabricaDeConexao.enderecoDoServidor = enderecoDoServidor;
        FabricaDeConexao.usuario = usuario;
        FabricaDeConexao.senha = senha;
        FabricaDeConexao.porta = porta;
        FabricaDeConexao.nomeDoBanco = nomeDoBanco;
    }

    public FabricaDeConexao() throws IOException {

        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();

        String[] valores = configuracoesDoAplicativo.lerConfiguracoes();

        FabricaDeConexao.usuario = valores[3];
        FabricaDeConexao.senha = valores[0];
        FabricaDeConexao.enderecoDoServidor = valores[4]; // Endereco do servidor
        FabricaDeConexao.porta = valores[1];
        FabricaDeConexao.nomeDoBanco = valores[2];
    }

    public Connection iniciarConexao() {

        // jdbc:mysql://ENDERECO:PORTA/NOME_DO_BANCO
        String urlDeConexao = "jdbc:mysql://" + enderecoDoServidor + ":" + porta + "/" + nomeDoBanco;

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(urlDeConexao, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setHeaderText(null);
            alerta.setTitle("Aviso!");
            alerta.setContentText("Problemas com o banco.");
            alerta.showAndWait();

            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText(null);
            erro.setTitle("Erro");
            erro.setContentText("Detalhes do erro: " + ex.getMessage());
            erro.showAndWait();

            throw new RuntimeException("Problemas com o banco. Por favor verifique:", ex);
        }
    }

    public static void fecharConexao(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt) {

        fecharConexao(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {

        fecharConexao(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
