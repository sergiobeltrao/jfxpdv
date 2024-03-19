package com.sergio.jfxpdv.diversos;

import com.sergio.jfxpdv.fabrica.JanelasDeDialogo;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.*;

public class ConfiguracoesDoAplicativo {

    private final String homeDoUsuario = System.getProperty("user.home");
    private final String caminhoRelativo = File.separator + "AppData" + File.separator + "Roaming" + File.separator + "jfxpdv";
    private final String caminhoFinal = homeDoUsuario + caminhoRelativo;
    private final String arquivoDeConfiguracoes = caminhoFinal + File.separator + "configuracoes.cfg";

    private final Properties properties = new Properties();
    private final File file = new File(arquivoDeConfiguracoes);

    public void novaConfiguracao(String nomeDaConfiguracao, String valorAtribuido) {

        File pasta = new File(caminhoFinal);
        pasta.mkdirs();

        try {

            if (file.exists()) {
                FileInputStream fileInput = new FileInputStream(file);
                properties.load(fileInput);
                fileInput.close();
            }

            properties.setProperty(nomeDaConfiguracao, valorAtribuido);

            OutputStream outputStream = new FileOutputStream(arquivoDeConfiguracoes);
            properties.store(outputStream, null);
            outputStream.close();

        } catch (IOException ex) {
            JanelasDeDialogo.dialogoPadrao("Erro", "Encontramos um problema ao criar o arquivo de configurações. Detalhes do erro: " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public int verificaConfiguracaoDoBanco() {

        try {
            if (file.exists()) {
                FileInputStream arquivoDeEntrada = new FileInputStream(arquivoDeConfiguracoes);
                properties.load(arquivoDeEntrada);

                boolean todasAsConfiguracoesForamEncontradas = properties.containsKey("banco.nomeDoUsuario") &&
                        properties.containsKey("banco.senhaDoUsuario") &&
                        properties.containsKey("banco.enderecoDoServidor") &&
                        properties.containsKey("banco.portaDeConexao") &&
                        properties.containsKey("banco.nomeDoBanco");

                arquivoDeEntrada.close();

                if (todasAsConfiguracoesForamEncontradas) {
                    // Não há erros.
                    return 0;
                } else {
                    // Arquivo encontrado com configurações faltando.
                    return 1;
                }
            }
        } catch (IOException ex) {
            JanelasDeDialogo.dialogoPadrao("Erro", "Encontramos um problema ao ler o arquivo de configurações. Detalhes do erro: " + ex.getMessage(), Alert.AlertType.ERROR);
        }
        // Arquivo não encontrado.
        return 2;
    }

    public void avisosDeInicializacao() {

        int codigoDeVerificacao = verificaConfiguracaoDoBanco();

        if (codigoDeVerificacao == 1) {
            JanelasDeDialogo.dialogoPadrao("Aviso de configuração",
                    "Faltam parâmetros de conexão com o banco de dados no arquivo de configuração. " +
                            "Por favor, verifique e preencha as configurações necessárias.",
                    Alert.AlertType.WARNING);
        } else if (codigoDeVerificacao == 2) {
            JanelasDeDialogo.dialogoPadrao("Bem-vindo!", "Olá! Parece que esta é a primeira vez que você está executando o sistema. " +
                            "Antes de prosseguir, é necessário configurar as informações do banco de dados. " +
                            "Por favor, utilize o ícone da engrenagem no canto inferior direito para inserir as informações necessárias.",
                    Alert.AlertType.WARNING);
        }
    }

    public String[] lerConfiguracoes() {

        String[] configuracoes = new String[5];

        try {
            if (file.exists()) {
                FileInputStream arquivoDeEntrada = new FileInputStream(arquivoDeConfiguracoes);
                properties.load(arquivoDeEntrada);

                configuracoes[0] = properties.getProperty("banco.nomeDoUsuario", "");
                configuracoes[1] = properties.getProperty("banco.senhaDoUsuario", "");
                configuracoes[2] = properties.getProperty("banco.enderecoDoServidor", "");
                configuracoes[3] = properties.getProperty("banco.portaDeConexao", "");
                configuracoes[4] = properties.getProperty("banco.nomeDoBanco", "");

                arquivoDeEntrada.close();
            }

        } catch (IOException ex) {
            JanelasDeDialogo.dialogoPadrao("Erro", "Erro ao ler o arquivo de configurações. Detalhes do erro: " + ex.getMessage(), Alert.AlertType.ERROR);
        }

        return configuracoes;
    }
}
