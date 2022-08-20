package com.danilo.pizzaria;

public class Cerveja extends Bebida{
    private double teorAlcoolico;

    public Cerveja(String descricao, double preco, int quantidadeEstoque, double teorAlcoolico) {
        super(descricao, preco, quantidadeEstoque);
        this.teorAlcoolico = teorAlcoolico;
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Preço: R$" + this.getPreco());
        System.out.println("Estoque: " + this.getQuantidadeEstoque());
        System.out.println("Origem: " + this.teorAlcoolico);
        System.out.println();
    }
}
