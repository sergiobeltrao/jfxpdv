package com.sergio.jfxpdv.diversos;

import java.util.Objects;

public class Constantes {
    public final static int resHorizontalMin = 1280;
    public final static int resVerticalMin = 720;

    public final static String cssTelaDeLogin = "/com/sergio/jfxpdv/css/tela-de-login.css";
    public final static String cssTelaPrincipal = "/com/sergio/jfxpdv/css/tela-principal.css";
    public final static String cssMenu = "/com/sergio/jfxpdv/css/menu.css";
    public final static String cssCamposPadronizados = "/com/sergio/jfxpdv/css/campos-padronizados.css";

    public final static int txtFieldGrande = 340;
    public final static int txtFieldMedio = 160;
    public final static int txtFieldPequeno = 90;
    public final static int boxEspacamento = 15;
    public final static int hBoxLarguraMinima = 950;
    public final static int alturaMinimaCampos = 30;

    public static String obterCss(String localDoCSS) {
        return Objects.requireNonNull(Constantes.class.getResource(localDoCSS)).toExternalForm();
    }
}
