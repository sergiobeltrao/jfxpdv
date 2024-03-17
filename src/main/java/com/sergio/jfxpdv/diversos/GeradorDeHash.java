package com.sergio.jfxpdv.diversos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorDeHash {

    public String geradorDeHash(String senha) throws NoSuchAlgorithmException {
        // Algoritimos: MD5, SHA-1, SHA-256, SHA-384 ou SHA-512.
        String algoritmoDeHash = "SHA-256";
        MessageDigest digest = MessageDigest.getInstance(algoritmoDeHash);
        digest.reset();
        byte[] hash = digest.digest(senha.getBytes());
        return bytesParaStringHex(hash);
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
