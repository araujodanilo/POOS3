package com.danilo.funcionario;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    final static int TAM=1;
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Funcionario[] vet = new Funcionario[TAM];


        double soma = 0;
        for (int i = 0; i < TAM; i++) {
            System.out.println("Digite o nome: ");
            String nome = ent.nextLine();

            System.out.println("Digite o salario: ");
            double salario = ent.nextDouble();
            soma += salario;
            ent.nextLine();//limpeza de buffer
            vet[i] = new Funcionario(nome, salario);
        }
        double media = soma/TAM;
        System.out.printf("Media: %.2f\n\n", media);

        for(Funcionario f: vet){
            System.out.printf("Salario antigo: %.2f\n", f.getSalario());
            if (f.getSalario() >=media){
                f.setSalario(f.getSalario()*1.05);
            }else{
                f.setSalario(f.getSalario()*1.10);
            }
            System.out.printf("Salario atual: %.2f\n", f.getSalario());
        }

    }
}
