package com.sergio.jfxpdv.modelo;

public class Cliente {

    private int id;
    private String tipo;
    private String nome;
    private String numeroDeCpfOuCnpj;
    private String rg;
    private String telefone;
    private String email;
    private String estado;
    private String cidade;
    private String rua;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;

    public Cliente(String tipo, String nome, String numeroDeCpfOuCnpj, String rg, String telefone, String email, String estado, String cidade, String rua, String bairro, String cep, String numero, String complemento) {
        this.tipo = tipo;
        this.nome = nome;
        this.numeroDeCpfOuCnpj = numeroDeCpfOuCnpj;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDeCpfOuCnpj() {
        return numeroDeCpfOuCnpj;
    }

    public void setNumeroDeCpfOuCnpj(String numeroDeCpfOuCnpj) {
        this.numeroDeCpfOuCnpj = numeroDeCpfOuCnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
