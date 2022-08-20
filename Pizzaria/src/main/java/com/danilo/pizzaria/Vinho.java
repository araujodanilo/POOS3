package com.danilo.pizzaria;

public class Vinho extends Bebida{
    private String uva;
    private String paisOrigiem;

    public Vinho(String descricao, double preco, int quantidadeEstoque, String uva, String paisOrigiem) {
        super(descricao, preco, quantidadeEstoque);
        this.uva = uva;
        this.paisOrigiem = paisOrigiem;
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public String getPaisOrigiem() {
        return paisOrigiem;
    }

    public void setPaisOrigiem(String paisOrigiem) {
        this.paisOrigiem = paisOrigiem;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Preço: R$" + this.getPreco());
        System.out.println("Estoque: " + this.getQuantidadeEstoque());
        System.out.println("Uva: " + this.uva);
        System.out.println("Origem: " + this.paisOrigiem);
        System.out.println();
    }
}
