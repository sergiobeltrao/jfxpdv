package com.sergio.jfxpdv.fabrica;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FabricaDeConexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String enderecoDoBanco;
    private static String usuario;
    private static String senha;
    private static String porta;
    private static String nomeDoBanco;

    public FabricaDeConexao(String enderecoDoBanco, String usuario, String senha, String porta, String nomeDoBanco) {
        FabricaDeConexao.enderecoDoBanco = enderecoDoBanco;
        FabricaDeConexao.usuario = usuario;
        FabricaDeConexao.senha = senha;
        FabricaDeConexao.porta = porta;
        FabricaDeConexao.nomeDoBanco = nomeDoBanco;
    }

    // O método que será usado para estabelecer a conexão com o MySQL
    public Connection iniciarConexao() {

        // jdbc:mysql://ENDERECO:PORTA/NOME_DO_BANCO
        String urlDeConexao = "jdbc:mysql://" + enderecoDoBanco + ":" + porta + "/" + nomeDoBanco;

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

            throw new RuntimeException("Problemas com o banco. Por favor verifique.", ex);
        }

    }

    // Métodos para fechar a conexão
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
