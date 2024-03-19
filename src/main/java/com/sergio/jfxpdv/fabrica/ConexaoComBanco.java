package com.sergio.jfxpdv.fabrica;

import com.sergio.jfxpdv.diversos.ConfiguracoesDoAplicativo;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoComBanco {

    private final String usuario;
    private final String senha;
    private final String enderecoDoServidor;
    private final String porta;
    private final String nomeDoBanco;

    public ConexaoComBanco(String usuario, String senha, String enderecoDoServidor, String porta, String nomeDoBanco) {
        this.usuario = usuario;
        this.senha = senha;
        this.enderecoDoServidor = enderecoDoServidor;
        this.porta = porta;
        this.nomeDoBanco = nomeDoBanco;
    }

    public ConexaoComBanco() {

        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        String[] valores = configuracoesDoAplicativo.lerConfiguracoes();

        this.usuario = valores[0];
        this.senha = valores[1];
        this.enderecoDoServidor = valores[2];
        this.porta = valores[3];
        this.nomeDoBanco = valores[4];
    }

    public Connection iniciarConexao() {

        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String urlDeConexao = "jdbc:mysql://" + enderecoDoServidor + ":" + porta + "/" + nomeDoBanco;

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(urlDeConexao, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {

            JanelasDeDialogo.dialogoPadrao("Erro no banco de dados", "Encontramos um problema ao acessar o banco de dados. Detalhes do erro: " + ex.getMessage(), Alert.AlertType.ERROR);
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
