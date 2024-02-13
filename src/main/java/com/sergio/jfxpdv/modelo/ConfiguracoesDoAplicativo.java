package com.sergio.jfxpdv.modelo;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.*;

public class ConfiguracoesDoAplicativo {

    private String pastaInicialDoUsuario = System.getProperty("user.home");
    private String caminhoDaPasta = pastaInicialDoUsuario + File.separator + "AppData" + File.separator + "Roaming" + File.separator + "jfxpdv";
    private String localDoArquivoDeConfiguracao = caminhoDaPasta + File.separator + "configuracoes.cfg";
    Properties properties = new Properties();

    public void novaConfiguracao(String nomeDaConfiguracao, String valorAtribuido) throws IOException {
        // Cria o diretório se ele não existir
        File pasta = new File(caminhoDaPasta);
        pasta.mkdirs();

        // Carrega as propriedades existentes, se houverem
        File arquivo = new File(localDoArquivoDeConfiguracao);
        if (arquivo.exists()) {
            FileInputStream fileInput = new FileInputStream(arquivo);
            properties.load(fileInput);
            fileInput.close();
        }

        // Adiciona a nova propriedade
        properties.setProperty(nomeDaConfiguracao, valorAtribuido);

        // Salva as propriedades no arquivo
        OutputStream outputStream = new FileOutputStream(localDoArquivoDeConfiguracao);
        properties.store(outputStream, null);
        outputStream.close();
    }

    public int verificaConfiguracaoDoBanco() throws IOException {

        File arquivo = new File(localDoArquivoDeConfiguracao);

        if (arquivo.exists()) {
            FileInputStream fileInput = new FileInputStream(localDoArquivoDeConfiguracao);
            properties.load(fileInput);

            boolean todasAsConfiguracoesForamEncontradas = properties.containsKey("banco.senhaDoUsuario") &&
                    properties.containsKey("banco.portaDeConexao") &&
                    properties.containsKey("banco.nomeDoBanco") &&
                    properties.containsKey("banco.nomeDoUsuario") &&
                    properties.containsKey("banco.enderecoDoServidor");

            fileInput.close();

            if (todasAsConfiguracoesForamEncontradas) {
                return 0;
            } else {
                return 2;
            }
        } else {
            System.out.println();
            return 1;
        }
    }

    public void avisoDePrimeiraConfiguracao(int codigoDeVerificacao) {

        Alert avisoBemVindo = new Alert(Alert.AlertType.WARNING);
        avisoBemVindo.setHeaderText(null);

        if (codigoDeVerificacao == 0) {
            System.out.println("Todos os parâmetros do banco estão presentes no arquivo de configuração.");
        } else if (codigoDeVerificacao == 1) {
            avisoBemVindo.setTitle("Bem-vindo!");
            avisoBemVindo.setContentText("Olá! Antes de iniciar o sistema você precisa configurar o banco. " +
                    "Use o icone da engrenagem no seu canto infrior direito para fornecer as informações.");
            avisoBemVindo.showAndWait();
        } else if (codigoDeVerificacao == 2) {
            avisoBemVindo.setTitle("Ops!");
            avisoBemVindo.setContentText("Faltam parâmetros do banco no arquivo de configuração. " +
                    "Verifique as configurações do banco.");
            avisoBemVindo.showAndWait();
        }
    }

    public String[] lerConfiguracoes() throws IOException {
        File arquivo = new File(localDoArquivoDeConfiguracao);
        String[] configuracoes = new String[5];

        if (arquivo.exists()) {
            FileInputStream arquivoDeEntrada = new FileInputStream(localDoArquivoDeConfiguracao);
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
