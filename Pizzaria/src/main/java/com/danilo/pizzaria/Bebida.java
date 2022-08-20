package com.danilo.pizzaria;

public abstract class Bebida extends Produto {
    private int quantidadeEstoque;

    public Bebida(String descricao, double preco, int quantidadeEstoque) {
        super(descricao, preco);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
