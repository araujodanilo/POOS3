package com.danilo.universidade;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Aluno> alunoList = new ArrayList<>();

        Curso c1 = new Curso("Analise e desenvolcimento de sistemas", "ADS");
        Curso c2 = new Curso("Tecnologo de manutenção de areonaves", "TMA");

        Aluno ag1 = new AlunoGraduacao("54325887925","Patricia Sousa","SC2159515",7.14,c1, 100);
        Aluno ag2 = new AlunoGraduacao("25495925948","Serjo Almeida","SC2194985",6,c2, 200);

        alunoList.add(ag1);
        alunoList.add(ag2);

        Professor p1 = new Professor("6512481312", "Aline Teodoro", "SC000000X", "O brabo");
        Aluno apg1 = new AlunoPosGraduacao("5665451554", "Antonio Sampaio", "SC6454811", 9, c1, "O mestre", p1);

        alunoList.add(apg1);

        for (Aluno a : alunoList){
            a.monstrarDados();
        }

        System.out.println("Professor (1)");
        p1.monstrarDados();
    }
}
