package com.danilo.interfacebanco;

public class Principal {
    public static void main(String[] args) {
        Cliente danilo = new Cliente("Danilo", "12345678911");
        Cliente murilo = new Cliente("Murilo", "12345678910");

        Conta corrente = new Corrente("Conta Corrente", danilo, "123", 6000, 10000);
        Conta poupanca = new Poupanca("Conta Poupança", murilo, "124", 8000, 7);

        SeguroVida svc = new SeguroVida("Seguro de vida", danilo, 100000);

        System.out.println("Contas: ");
        corrente.mostrarDados();
        System.out.println();
        poupanca.mostrarDados();

        System.out.println("\nClientes: ");
        danilo.mostrarDados();
        System.out.println();
        murilo.mostrarDados();

        System.out.println("Seguro de vida: ");
        svc.mostrarDados();

        System.out.println("\nTributos: ");
        ((Corrente) corrente).calcularTributo();
        System.out.println();
        svc.calcularTributo();
    }
}
