package com.danilo.interfacebanco;

public class Corrente extends Conta implements ITributavel {
    private double limiteDisponivel;

    public Corrente(String descricao, Cliente cliente, String numero, double saldo, double limiteDisponivel) {
        super(descricao, cliente, numero, saldo);
        this.limiteDisponivel = limiteDisponivel;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Descrição: " + getDescricao() + "\nCliente: " + getCliente().getNome() + "\nLimite disponivel: " + this.getLimiteDisponivel() + "\nSaldo: " + this.getSaldo() + "\nNumero Conta: " + this.getNumero());
    }

    @Override
    public void calcularTributo() {
        System.out.println("Descrição: " + this.getDescricao() + "\tCliente: " + this.getCliente().getNome());
        System.out.println("Tributo: " + this.getSaldo()*0.05 + "\tSaldo: " + this.getSaldo());
        //return this.getSaldo()*0.05;
    }
}
