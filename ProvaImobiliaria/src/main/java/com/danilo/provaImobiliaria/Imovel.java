package com.danilo.provaImobiliaria;

public abstract class Imovel {
    private Proprietario proprietario;
    private String endereco;
    private double areaConstriuda;
    private int vagaGaragem;
    private double valorAluguel;

    public Imovel(Proprietario proprietario, String endereco, double areaConstriuda, int vagaGaragem, double valorAluguel) {
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.areaConstriuda = areaConstriuda;
        this.vagaGaragem = vagaGaragem;
        this.valorAluguel = valorAluguel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getAreaConstriuda() {
        return areaConstriuda;
    }

    public void setAreaConstriuda(double areaConstriuda) {
        this.areaConstriuda = areaConstriuda;
    }

    public int getVagaGaragem() {
        return vagaGaragem;
    }

    public void setVagaGaragem(int vagaGaragem) {
        this.vagaGaragem = vagaGaragem;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public abstract void mostrarDadosImovel();
}
