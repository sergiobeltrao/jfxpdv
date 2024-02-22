package com.sergio.jfxpdv.servicos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.jfxpdv.fabrica.Mensagens;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class ViaCEP {

    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public ViaCEP(String cep) {
        try {
            URL viaCEP = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpsURLConnection conexao = (HttpsURLConnection) viaCEP.openConnection();
            conexao.setRequestMethod("GET");
            int codigoDeResposta = conexao.getResponseCode();

            if (codigoDeResposta == HttpsURLConnection.HTTP_OK) {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(conexao.getInputStream());
                while (scanner.hasNext()) {
                    stringBuilder.append(scanner.nextLine());
                }
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {
                };
                HashMap<String, Object> jsonMap = objectMapper.readValue(stringBuilder.toString(), typeRef);

                this.logradouro = (String) jsonMap.get("logradouro");
                this.bairro = (String) jsonMap.get("bairro");
                this.localidade = (String) jsonMap.get("localidade");
                this.uf = (String) jsonMap.get("uf");
            } else {
                String mensagem = "Erro ao enviar a requisição. O servidor retornou o código HTTP " + codigoDeResposta + " como resposta.";
                new Mensagens().mensagemDeErro("Erro", mensagem);
            }
        } catch (IOException ex) {
            new Mensagens().mensagemDeErro("Erro", ex.getMessage());
        }
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }
}
