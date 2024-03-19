package com.sergio.jfxpdv.diversos;

import com.sergio.jfxpdv.fabrica.JanelasDeDialogo;
import javafx.scene.control.Alert;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorDeHash {

    public String geradorDeHash(String senha) {
        // Algoritimos de Hashing (MessageDigest): MD5, SHA-1, SHA-256, SHA-384 ou SHA-512.
        String algoritmoDeHash = "SHA-256";

        try {
            MessageDigest digest = MessageDigest.getInstance(algoritmoDeHash);
            digest.reset();
            byte[] hash = digest.digest(senha.getBytes());
            return bytesParaStringHex(hash);
        } catch (NoSuchAlgorithmException ex) {

            JanelasDeDialogo.dialogoPadrao("Erro", "O algoritmo de criptografia " + algoritmoDeHash + " não está disponível. Verifique se foi especificado corretamente.", Alert.AlertType.ERROR);
        }

        return null;
    }

    private String bytesParaStringHex(byte[] bytes) {
        char[] caracteresHex = new char[bytes.length * 2];
        final char[] arrayHex = "0123456789ABCDEF".toCharArray();
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            caracteresHex[i * 2] = arrayHex[v >>> 4];
            caracteresHex[i * 2 + 1] = arrayHex[v & 0x0F];
        }
        return new String(caracteresHex);
    }
}
