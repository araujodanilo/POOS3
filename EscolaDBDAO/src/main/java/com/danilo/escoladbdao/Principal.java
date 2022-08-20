package com.danilo.escoladbdao;

import com.danilo.escoladbdao.data.AlunoSQLiteDAO;
import com.danilo.escoladbdao.data.CidadeSQLiteDAO;
import com.danilo.escoladbdao.data.CursoSQLiteDAO;
import com.danilo.escoladbdao.data.GenericDAO;
import com.danilo.escoladbdao.model.Aluno;
import com.danilo.escoladbdao.model.Cidade;
import com.danilo.escoladbdao.model.Curso;
import com.danilo.escoladbdao.model.IMostrarDados;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Cidade> listaCidade = new ArrayList<>();
        List<Curso> listaCurso = new ArrayList<>();
        List<Aluno> listaAluno = new ArrayList<>();

        Cidade cidade1 = new Cidade(1, "São Carlos");
        Cidade cidade2 = new Cidade(2, "Araquara");
        Cidade cidade3 = new Cidade(3, "Ribeirão Preto");

        listaCidade.add(cidade1);
        listaCidade.add(cidade2);
        listaCidade.add(cidade3);


        Curso curso1 = new Curso(1, "ACS");
        Curso curso2 = new Curso(2, "TMA");
        Curso curso3 = new Curso(3, "TPG");

        listaCurso.add(curso1);
        listaCurso.add(curso2);
        listaCurso.add(curso3);


        Aluno aluno1 = new Aluno(1, "123456", "Danilo", curso1, cidade1);
        Aluno aluno2 = new Aluno(2, "123457", "Murilo", curso2, cidade2);
        Aluno aluno3 = new Aluno(3, "123458", "Isabela", curso3, cidade3);

        listaAluno.add(aluno1);
        listaAluno.add(aluno2);
        listaAluno.add(aluno3);

        //Salvar lista no banco
        AlunoSQLiteDAO alunoDAO = new AlunoSQLiteDAO();
        CursoSQLiteDAO cursoDAO = new CursoSQLiteDAO();
        CidadeSQLiteDAO cidadeDAO = new CidadeSQLiteDAO();

        salvarLista(listaAluno, alunoDAO);
        salvarLista(listaCidade, cidadeDAO);
        salvarLista(listaCurso, cursoDAO);

        System.out.println("Lista Aluno");
        mostarLista(listaAluno);
        System.out.println("\n");

        System.out.println("Lista Cidade");
        mostarLista(listaCidade);
        System.out.println("\n");

        System.out.println("Lista Curso");
        mostarLista(listaCurso);
        System.out.println("\n");

        //Alterando valores
        curso1.setNome("ADS");
        cursoDAO.atualizar(curso1);

        aluno1.setNome("Araujo");
        alunoDAO.atualizar(aluno1);


        cidade1.setNome("São Paulo");
        cidadeDAO.atualizar(cidade1);


        System.out.println("Alterado os valores no banco... Print logo em seguida\n");

        listaAluno = alunoDAO.buscarTodos();
        listaCurso = cursoDAO.buscarTodos();
        listaCidade = cidadeDAO.buscarTodos();

        System.out.println("Lista Aluno");
        mostarLista(listaAluno);
        System.out.println("\n");

        System.out.println("Lista Cidade");
        mostarLista(listaCidade);
        System.out.println("\n");

        System.out.println("Lista Curso");
        mostarLista(listaCurso);
        System.out.println("\n");

        int idBusca = 1;
        System.out.println("Buscar aluno com id : " + idBusca);
        Aluno buscarAluno = alunoDAO.buscar(idBusca);
        buscarAluno.mostrarDados();


        //Apagar Lista do Banco
        apagarLista(listaAluno, alunoDAO);
        apagarLista(listaCidade, cidadeDAO);
        apagarLista(listaCurso, cursoDAO);


    }

    private static <Type> void mostarLista(List<Type> lista){
        for(Type type : lista){
            try{
                IMostrarDados teste = ((IMostrarDados) type);
                teste.mostrarDados();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static <Type> void salvarLista(List<Type> lista, GenericDAO genericDAO){
        for(Type type : lista){
            genericDAO.salvar(type);
        }
    }

    private static <Type> void apagarLista(List<Type> lista, GenericDAO genericDAO){
        for(Type type : lista){
            genericDAO.apagar(type);
        }
    }

}