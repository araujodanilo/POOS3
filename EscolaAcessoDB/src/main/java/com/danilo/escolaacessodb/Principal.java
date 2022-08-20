package com.danilo.escolaacessodb;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Curso> listaCurso = new ArrayList<>();
        List<Aluno> listaAluno = new ArrayList<>();
        List<Cidade> listaCidade = new ArrayList<>();

        Curso c = new Curso(1, "JAVA");
        listaCurso.add(c);
        c = new Curso(2, "DB1");
        listaCurso.add(c);
        c = new Curso(3, "PW2");
        listaCurso.add(c);

        System.out.println("Cursos");
        for (Curso curso : listaCurso){
            curso.mostrarDados();
            curso.salvar();
        }

        System.out.println("\nAtualizando o Curso \"Java\" para \"POO\"");
        c = Curso.buscar(1);
        c.setNome("POO");
        c.atualizar();

        System.out.println("\nCursos");
        listaCurso = Curso.buscarTodos();
        for (Curso curso : listaCurso){
            curso.mostrarDados();
        }

        Cidade cid = new Cidade(1, "São Carlos");
        listaCidade.add(cid);
        cid = new Cidade(2, "Ribeirão Preto");
        listaCidade.add(cid);
        cid = new Cidade(3, "Frio de Janeiro");
        listaCidade.add(cid);

        System.out.println("\nCidades");
        for (Cidade cidade : listaCidade){
            cidade.mostrarDados();
            cidade.salvar();
        }

        System.out.println("\nAtualizando Ciadade id = \"2\" para \"São Paulo\"");
        cid = Cidade.buscar(2);
        cid.setNome("São Paulo");
        cid.atualizar();

        System.out.println("\nCidades");
        listaCidade = Cidade.buscarTodos();
        for (Cidade cidade : listaCidade){
            cidade.mostrarDados();
        }

        Aluno aluno = new Aluno(1, "123456", "Danilo", Curso.buscar(1), Cidade.buscar(3));
        listaAluno.add(aluno);
        aluno = new Aluno(2, "123457", "Murilo", Curso.buscar(1), Cidade.buscar(2));
        listaAluno.add(aluno);
        aluno = new Aluno(3, "123458", "Isabela", Curso.buscar(2), Cidade.buscar(1));
        listaAluno.add(aluno);
        aluno = new Aluno(4, "123459", "Emanuella", Curso.buscar(2), Cidade.buscar(3));
        listaAluno.add(aluno);
        aluno = new Aluno(5, "123460", "Ivone", Curso.buscar(1), Cidade.buscar(1));
        listaAluno.add(aluno);

        System.out.println("\nAlunos");
        for (Aluno a : listaAluno){
            a.mostrarDados();
            a.salvar();
        }

        System.out.println("\nAtualizando nome... (ALL NAMES TO TESTE+(id))");
        for (Aluno a :listaAluno){
            String id = String.valueOf(a.getIdAluno());
            a.setNome("Teste"+id);
            a.atualizar();
        }

        System.out.println("\nAlunos");
        listaAluno = Aluno.buscarTodos();
        for (Aluno a : listaAluno){
            a.mostrarDados();
        }

        apagarDados();
    }
    public static void apagarDados(){

        List<Curso> listaCurso = Curso.buscarTodos();
        List<Aluno> listaAluno = Aluno.buscarTodos();
        List<Cidade> listaCidade = Cidade.buscarTodos();

        for (Aluno a : listaAluno){
            a.apagar();
        }

        for (Curso c : listaCurso){
            c.apagar();
        }
        for (Cidade c : listaCidade){
            c.apagar();
        }

    }
}