package com.sergio.jfxpdv.modelo;

import java.util.Objects;

public class Constantes {
    public final static int resHorizontalMin = 1024;
    public final static int resVerticalMin = 576;

    public final static String cssTelaDeLogin = "/com/sergio/jfxpdv/css/tela-de-login.css";
    public final static String cssTelaPrincipal = "/com/sergio/jfxpdv/css/tela-principal.css";
    public final static String cssMenu = "/com/sergio/jfxpdv/css/menu.css";

    public static String obterCss(String localDoCSS) {
        return Objects.requireNonNull(Constantes.class.getResource(localDoCSS)).toExternalForm();
    }
}