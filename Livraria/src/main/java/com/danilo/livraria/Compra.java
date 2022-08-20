package com.danilo.livraria;

import java.util.Arrays;

public class Compra {
    private String numeroCompra;
    private String dataCompra;
    private double totalCompra;
    private ItensCompra[] itensCompra = new ItensCompra[5];

    public Compra(String numeroCompra, String dataCompra, ItensCompra[] itensCompra) {
        this.numeroCompra = numeroCompra;
        this.dataCompra = dataCompra;
        this.itensCompra = itensCompra;
    }

    public Compra() {
    }

    public String getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(String numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public ItensCompra[] getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItensCompra[] itensCompra) {
        this.itensCompra = itensCompra;
    }

    public void calcularValorTotal(){
        double result = 0;

        for(ItensCompra item : this.getItensCompra()){
            if (!(item == null)){
                result += item.getLivro().getPreco()* item.getQuantidade();
            }
        }

        this.setTotalCompra(result);
    }

    public void mostrarDados() {
        System.out.println("Numero da Compra: " + this.numeroCompra + "\nData: " + this.dataCompra + "\nValor total: " + this.totalCompra + "\n");
    }
}
