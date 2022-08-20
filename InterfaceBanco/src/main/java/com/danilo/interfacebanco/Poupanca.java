package com.danilo.interfacebanco;

public class Poupanca extends Conta{
    private double redimentoAnual;

    public Poupanca(String descricao, Cliente cliente, String numero, double saldo, double redimentoAnual) {
        super(descricao, cliente, numero, saldo);
        this.redimentoAnual = redimentoAnual;
    }

    public double getRedimentoAnual() {
        return redimentoAnual;
    }

    public void setRedimentoAnual(double redimentoAnual) {
        this.redimentoAnual = redimentoAnual;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Descrição: " + getDescricao() + "\nCliente: " + getCliente().getNome() + "\nRendimento Anual: " + this.getRedimentoAnual() + "\nSaldo: " + this.getSaldo() + "\nNumero Conta: " + this.getNumero());
    }
    // Não está no diagrama
}
