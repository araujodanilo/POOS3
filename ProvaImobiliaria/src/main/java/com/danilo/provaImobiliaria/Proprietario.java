package com.danilo.provaImobiliaria;

public class Proprietario extends Pessoa{
    private String banco;
    private String conta;

    public Proprietario(String cpf, String nome, String telefone, String banco, String conta) {
        super(cpf, nome, telefone);
        this.banco = banco;
        this.conta = conta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Override
    public void mostrarDadosPessoas() {
        System.out.println("------ Proprietario ------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Telfone: " + this.getTelefone());
        System.out.println("Conta: " + this.getConta() + "\tBanco: " + this.getBanco());
        System.out.println("\n");

    }
}
