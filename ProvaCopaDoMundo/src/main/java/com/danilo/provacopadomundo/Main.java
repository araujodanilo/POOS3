package com.danilo.provacopadomundo;

import com.danilo.provacopadomundo.data.PartidaSQLiteDAO;
import com.danilo.provacopadomundo.data.TimeSQLiteDAO;
import com.danilo.provacopadomundo.model.Partida;
import com.danilo.provacopadomundo.model.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static private void listarTimes(){
        System.out.println("\nTimes: ");
        List<Time> timeList;
        timeList = new TimeSQLiteDAO().searchAll();

        for (Time time : timeList){
            time.mostrarDados();
        }
    }
    static private void listarPartidas(){
        System.out.println("\nPartidas: ");
        List<Partida> partidaList;
        partidaList = new PartidaSQLiteDAO().searchAll();

        for (Partida partida : partidaList){
            partida.mostrarDados();
        }
    }
    static private void cadastrarTime(){
        System.out.println("Cadastrar time:");
        System.out.print("Nome: ");
        Scanner scanner = new Scanner(System.in);
        String pais = scanner.nextLine();

        while(true){
            System.out.println("Deseja cadastrar o time: " + pais + "?");
            String op = scanner.nextLine();
            if (op.equalsIgnoreCase("sim") || op.equalsIgnoreCase("s") || op.equalsIgnoreCase("yes") || op.equalsIgnoreCase("y")){
                Time time = new Time();
                time.setPais(pais);
                new TimeSQLiteDAO().save(time);
                System.out.println("Time salvado com sucesso.");
                break;
            } else if (op.equalsIgnoreCase("nao") || op.equalsIgnoreCase("n") || op.equalsIgnoreCase("no") || op.equalsIgnoreCase("não")) {
                System.out.println("Time não salvado.");
                break;
            }else{
                System.out.println("Não entendi.");
            }
        }
    }
    static private void cadastrarPartida(){


        System.out.println("Cadastrar partida:");

        String dataJogo;

        while(true) {
                System.out.print("Digite a data do jogo (dd-MM-yyyy): ");
                dataJogo = new Scanner(System.in).nextLine();
                if (dataJogo == null) {
                    System.out.println("Ops.. Essa data está invalida.");
                } else {
                    break;
                }
        }

        listarTimes();
        Time time1;
        while(true){
            System.out.print("Digite o id do primeiro time: ");
            int idTime1 = new Scanner(System.in).nextInt();
            time1 = new TimeSQLiteDAO().search(idTime1);
            if (time1.getPais()  == null){
                System.out.println("Ops.. Esse time não existe.");
            }else{
                break;
            }
        }

        listarTimes();
        Time time2;
        while(true){
            System.out.print("Digite o id do segundo time: ");
            int idTime2 = new Scanner(System.in).nextInt();
            time2 = new TimeSQLiteDAO().search(idTime2);
            if (time2.getPais()  == null){
                System.out.println("Ops.. Esse time não existe.");
            }else{
                break;
            }
        }

        int placarTime1;
        while(true){
            System.out.print("Digite o placar do time " + time1.getPais() + ": ");
            placarTime1 = new Scanner(System.in).nextInt();
            if (placarTime1 < 0){
                System.out.println("Ops.. esse placar é invalido.");
            }else{
                break;
            }
        }

        int placarTime2;
        while(true){
            System.out.print("Digite o placar do time " + time2.getPais() + ": ");
            placarTime2 = new Scanner(System.in).nextInt();
            if (placarTime2 < 0){
                System.out.println("Ops.. esse placar é invalido.");
            }else{
                break;
            }
        }

        while(true){
            System.out.println("Partida...");
            System.out.println(time1.getPais() + " com: " + placarTime1 + " gols.");
            System.out.println(time2.getPais() + " com: " + placarTime2 + " gols.");
            System.out.print("\nInformações corretas? ");
            String op = new Scanner(System.in).nextLine();

            if (op.equalsIgnoreCase("sim") || op.equalsIgnoreCase("s") || op.equalsIgnoreCase("yes") || op.equalsIgnoreCase("y")){
                Partida partida = new Partida();
                partida.setTime1(time1);
                partida.setTime1(time2);
                partida.atualzarPlacar(placarTime1, placarTime2);
                System.out.println("Time salvado com sucesso.");
                break;
            } else if (op.equalsIgnoreCase("nao") || op.equalsIgnoreCase("n") || op.equalsIgnoreCase("no") || op.equalsIgnoreCase("não")) {
                System.out.println("Time não salvado.");
                break;
            }else{
                System.out.println("Não entendi.");
            }
        }
    }
    static private void editarTime(){
        while(true){
            listarTimes();
            System.out.println("Para editar o time digite o id: ");
            int id = new Scanner(System.in).nextInt();
            Time time = new TimeSQLiteDAO().search(id);
            if (time.getIdTime() != id){
                System.out.println("Time não foi encontrado! Tente novamente.");
            }else {
                while(true){
                    System.out.println("Editar time...\n");
                    time.mostrarDados();
                    System.out.print("Digite o nome: ");
                    String nome = new Scanner(System.in).nextLine();
                    if (nome.isEmpty()){
                        System.out.println("Nome está invalido!! Tente novamente.");
                    }else{
                        time.setPais(nome);
                        new TimeSQLiteDAO().update(time);
                        break;
                    }
                }
                break;
            }
        }
    }
    static private void editarPartida(){
        while(true){
            listarPartidas();
            System.out.println("Para editar a partida digite o id: ");
            int id = new Scanner(System.in).nextInt();
            Partida partida = new PartidaSQLiteDAO().search(id);
            if (partida.getIdPartida() != id){
                System.out.println("Partida não encontrada! Tente novamente.");
            }else{
                System.out.print("Editar partida...");
                partida.mostrarDados();

            }
        }
    }
    static private void showMenu(){
        System.out.println("\nOpções:");
        System.out.println("" +
                "1 - Listar Times" +
                "\n2 - Listar Partidas" +
                "\n3 - Cadastrar Time" +
                "\n4 - Cadastrar Partida" +
                "\n0 - Sair"
        );
    }

    public static void main(String[] args) {
        int op;
        do{
            showMenu();
            op = new Scanner(System.in).nextInt();
            switch (op){
                case 1:
                    listarTimes();
                    break;
                case 2:
                    listarPartidas();
                    break;
                case 3:
                    cadastrarTime();
                    break;
                case 4:
                    cadastrarPartida();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção invalida.");
                    break;

            }
        }while (op != 0);
    }

}
