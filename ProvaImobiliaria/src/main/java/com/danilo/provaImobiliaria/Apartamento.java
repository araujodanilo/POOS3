package com.danilo.provaImobiliaria;

public class Apartamento extends Imovel {

    private String nomeEdificio;
    private int andar;

    public Apartamento(Proprietario proprietario, String endereco, double areaConstriuda, int vagaGaragem, double valorAluguel, String nomeEdificio, int andar) {
        super(proprietario, endereco, areaConstriuda, vagaGaragem, valorAluguel);
        this.nomeEdificio = nomeEdificio;
        this.andar = andar;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    @Override
    public void mostrarDadosImovel() {
        System.out.println("------ Apartamento ------");
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Area contruida: " + this.getAreaConstriuda());
        System.out.println("Vaga garagem: " + this.getVagaGaragem());
        System.out.println("Nome do Edifiio: " + this.getNomeEdificio() + "\tAndar: " + this.getAndar());
        System.out.println("Valor: " + this.getValorAluguel());
        System.out.println("\n");

    }
}
