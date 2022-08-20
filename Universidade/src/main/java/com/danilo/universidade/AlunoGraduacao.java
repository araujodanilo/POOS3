package com.danilo.universidade;

public class AlunoGraduacao extends Aluno{
    private double horasAtividadesComplementares;

    public AlunoGraduacao(String cpf, String nome, String prontuario, double ira, Curso curso, double horasAtividadesComplementares) {
        super(cpf, nome, prontuario, ira, curso);
        this.horasAtividadesComplementares = horasAtividadesComplementares;
    }

    public double getHorasAtividadesComplementares() {
        return horasAtividadesComplementares;
    }

    public void setHorasAtividadesComplementares(double horasAtividadesComplementares) {
        this.horasAtividadesComplementares = horasAtividadesComplementares;
    }

    @Override
    public void monstrarDados() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Curso: "+this.getCurso().getNome()
                +" sigla: "+this.getCurso().getSigla());
        System.out.println("Prontuario: "+this.getProntuario());
        System.out.println("Ira: "+this.getIra());
        System.out.println("Horas atividades complementares: "+this.horasAtividadesComplementares+"\n");
    }
}
