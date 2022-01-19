package br.com.spring.sistemagerenciamento.modelo;

public class Produto {

    private String nome;
    private Boolean caseiro;
    private Double preco;
    private String descricao;

    public Produto() {}
    
    public Produto(String nome, Boolean caseiro, Double preco, String descricao) {

        this.nome = nome;
        this.caseiro = caseiro;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getCaseiro() {
        return caseiro;
    }

    public void setCaseiro(Boolean caseiro) {
        this.caseiro = caseiro;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {

        return "Produto{" +
        "nome='" + nome + '\'' +
        ", caseiro=" + caseiro +
        ", preco=" + preco +
        ", descricao='" + descricao + '\'' +
        '}';
    }
}
