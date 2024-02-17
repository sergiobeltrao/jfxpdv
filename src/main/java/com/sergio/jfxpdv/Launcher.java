package com.sergio.jfxpdv;

import com.sergio.jfxpdv.telas.TelaDeLogin;
import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        // Inicializar a aplicação JavaFX manualmente
        Application.launch(TelaDeLogin.class, args);
    }
}
