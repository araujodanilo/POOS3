package com.danilo.universidade;

public class AlunoPosGraduacao extends Aluno{
    private String tituloMonografia;
    private Professor professor;

    public AlunoPosGraduacao(String cpf, String nome, String prontuario, double ira, Curso curso, String tituloMonografia, Professor professor) {
        super(cpf, nome, prontuario, ira, curso);
        this.tituloMonografia = tituloMonografia;
        this.professor = professor;
    }

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public void monstrarDados() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Curso: "+this.getCurso().getNome()
                +" sigla: "+this.getCurso().getSigla());
        System.out.println("Prontuario: "+this.getProntuario());
        System.out.println("Ira: "+this.getIra());
        System.out.println("Titulo Monografia: "+this.tituloMonografia+"\n");
    }
}
