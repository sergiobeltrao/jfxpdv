package com.sergio.jfxpdv.modelo;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String nivelDeAcesso;

    public Usuario(String nome, String login, String senha, String nivelDeAcesso) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public Usuario(String login, String senha, String nivelDeAcesso) {
        this.login = login;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }
}
