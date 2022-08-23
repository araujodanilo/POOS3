package com.danilo.livrariaComArrayList;

import java.util.List;

public class Compra {
    private String numeroCompra;
    private String dataCompra;
    private Cliente cliente;
    private double varlorTotal;
    private List<ItensCompra> itensCompras;

    public void calcularValorTotalCompra(){

        for(ItensCompra ic: itensCompras){
            this.varlorTotal = this.varlorTotal + ic.getValorParcial();
        }

    }

    public Compra(){

    }

    public Compra(String numeroCompra, String dataCompra, Cliente cliente) {
        this.numeroCompra = numeroCompra;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
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

    public double getVarlorTotal() {
        return varlorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVarlorTotal(double varlorTotal) {
        this.varlorTotal = varlorTotal;
    }

    public List<ItensCompra> getItensCompras() {
        return itensCompras;
    }

    public void setItensCompras(List<ItensCompra> itensCompras) {
        this.itensCompras = itensCompras;
    }

    public void mostrarDados(){
        System.out.println("-=-=-=- Compra -=-=-=-");
        System.out.println("Numero compra: " + this.numeroCompra + "\nData: " + this.dataCompra);
        cliente.mostrarDados();
        calcularValorTotalCompra();
        System.out.println("Valor total: " + this.varlorTotal);
        System.out.println("-=-=-=- -=-=-=- -=-=-=-\n");
        for (ItensCompra itensCompra : this.itensCompras){
            itensCompra.mostrarDados();
        }
    }
}
