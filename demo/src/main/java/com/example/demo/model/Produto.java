package com.example.demo.model;

public class Produto {

    // #region Atributos
    private Integer id;
    private String nome;
    private double preco;
    private Integer quantidade;
    private String observacoes;

    public Produto(int id, String nome, double preco, int quantidade, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.observacoes = observacoes;
    }
    // #endregion

    // #region Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    // #endregion

}
