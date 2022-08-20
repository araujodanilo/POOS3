package com.danilo.provaImobiliaria;

public class Inquilino extends Pessoa {
    private double rendaMensal;

    public Inquilino(String cpf, String nome, String telefone, double rendaMensal) {
        super(cpf, nome, telefone);
        this.rendaMensal = rendaMensal;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    @Override
    public void mostrarDadosPessoas() {
        System.out.println("------ Inquilino ------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Telfone: " + this.getTelefone());
        System.out.println("Renda mensal: " + this.getRendaMensal());
        System.out.println("\n");

    }
}
