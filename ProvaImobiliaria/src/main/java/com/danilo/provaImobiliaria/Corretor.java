package com.danilo.provaImobiliaria;

public class Corretor extends Pessoa {
    private String creci;
    private double comissao;

    public Corretor(String cpf, String nome, String telefone, String creci, double comissao) {
        super(cpf, nome, telefone);
        this.creci = creci;
        this.comissao = comissao;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public void mostrarDadosPessoas() {
        System.out.println("------ Corretor ------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Telfone: " + this.getTelefone());
        System.out.println("Creci: " + this.getCreci());
        System.out.println("Comissão: " + this.getComissao());
        System.out.println("\n");
    }
}
