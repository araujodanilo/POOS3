package com.danilo.universidade;

public class Professor extends Pessoa{
    private String matricula;
    private String titulacao;

    public Professor(String cpf, String nome, String matricula, String titulacao) {
        super(cpf, nome);
        this.matricula = matricula;
        this.titulacao = titulacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public void monstrarDados() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Matricula: "+this.matricula);
        System.out.println("Titulação: "+this.titulacao+"\n");
    }
}
