package com.danilo.escoladbfx.model;

public class Aluno implements IMostrarDados{
    private int idAluno;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;

    public Aluno(int idAluno, String prontuario, String nome, Curso curso, Cidade cidade) {
        this.idAluno = idAluno;
        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
    }
    public Aluno(){};

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrarDados(){
        System.out.println("Prontuario: "+this.getProntuario()+"\tAluno: "+this.getNome()+"\tID: "+this.getIdAluno()+"\tCurso: "+this.getCurso().getNome()+"\tCidade: "+this.getCidade().getNome());
    }
}
