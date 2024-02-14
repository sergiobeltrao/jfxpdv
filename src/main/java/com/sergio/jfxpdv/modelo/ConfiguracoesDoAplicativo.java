package com.sergio.jfxpdv.modelo;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.*;

public class ConfiguracoesDoAplicativo {

    private final String pastaInicialDoUsuario = System.getProperty("user.home");
    private final String caminhoRelativo = File.separator + "AppData" + File.separator + "Roaming" + File.separator + "jfxpdv";
    private final String caminhoFinal = pastaInicialDoUsuario + caminhoRelativo;
    private final String arquivoDeConfiguracoes = caminhoFinal + File.separator + "configuracoes.cfg";

    private final Properties properties = new Properties();
    private final File arquivo = new File(arquivoDeConfiguracoes);

    public void novaConfiguracao(String nomeDaConfiguracao, String valorAtribuido) throws IOException {

        File pasta = new File(caminhoFinal);
        pasta.mkdirs();

        if (arquivo.exists()) {
            FileInputStream fileInput = new FileInputStream(arquivo);
            properties.load(fileInput);
            fileInput.close();
        }

        properties.setProperty(nomeDaConfiguracao, valorAtribuido);

        OutputStream outputStream = new FileOutputStream(arquivoDeConfiguracoes);
        properties.store(outputStream, null);
        outputStream.close();
    }

    public int verificaConfiguracaoDoBanco() throws IOException {

        if (arquivo.exists()) {
            FileInputStream arquivoDeEntrada = new FileInputStream(arquivoDeConfiguracoes);
            properties.load(arquivoDeEntrada);

            boolean todasAsConfiguracoesForamEncontradas = properties.containsKey("banco.senhaDoUsuario") &&
                    properties.containsKey("banco.portaDeConexao") &&
                    properties.containsKey("banco.nomeDoBanco") &&
                    properties.containsKey("banco.nomeDoUsuario") &&
                    properties.containsKey("banco.enderecoDoServidor");

            arquivoDeEntrada.close();

            if (todasAsConfiguracoesForamEncontradas) {
                return 0;
                // Não há erros.
            } else {
                // Arquivo encontrado com configurações faltando.
                return 1;
            }
        } else {
            // Arquivo não encontrado.
            return 2;
        }
    }

    public void avisosDeInicializacao() throws IOException {

        int codigoDeVerificacao = verificaConfiguracaoDoBanco();

        Alert mensagemInicial = new Alert(Alert.AlertType.WARNING);
        mensagemInicial.setHeaderText(null);

        if (codigoDeVerificacao == 1) {
            mensagemInicial.setTitle("Aviso de configuração");
            mensagemInicial.setContentText("Faltam parâmetros de conexão com o banco de dados no arquivo de configuração. " +
                    "Por favor, verifique e preencha as configurações necessárias.");
            mensagemInicial.showAndWait();
        } else if (codigoDeVerificacao == 2) {
            mensagemInicial.setTitle("Bem-vindo!");
            mensagemInicial.setContentText("Olá! Parece que esta é a primeira vez que você está executando o sistema. " +
                    "Antes de prosseguir, é necessário configurar as informações do banco de dados. " +
                    "Por favor, utilize o ícone da engrenagem no canto inferior direito para inserir as informações necessárias.");
            mensagemInicial.showAndWait();
        }
    }

    public String[] lerConfiguracoes() throws IOException {

        String[] configuracoes = new String[5];

        if (arquivo.exists()) {
            FileInputStream arquivoDeEntrada = new FileInputStream(arquivoDeConfiguracoes);
            properties.load(arquivoDeEntrada);

            configuracoes[0] = properties.getProperty("banco.senhaDoUsuario", "");
            configuracoes[1] = properties.getProperty("banco.portaDeConexao", "");
            configuracoes[2] = properties.getProperty("banco.nomeDoBanco", "");
            configuracoes[3] = properties.getProperty("banco.nomeDoUsuario", "");
            configuracoes[4] = properties.getProperty("banco.enderecoDoServidor", "");

            arquivoDeEntrada.close();
        }

        return configuracoes;
    }
}
