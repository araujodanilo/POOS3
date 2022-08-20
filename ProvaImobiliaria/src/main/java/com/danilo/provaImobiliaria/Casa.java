package com.danilo.provaImobiliaria;

public class Casa extends Imovel {
    private String quadra;
    private String lote;

    public Casa(Proprietario proprietario, String endereco, double areaConstriuda, int vagaGaragem, double valorAluguel, String quadra, String lote) {
        super(proprietario, endereco, areaConstriuda, vagaGaragem, valorAluguel);
        this.quadra = quadra;
        this.lote = lote;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public void mostrarDadosImovel() {
        System.out.println("------ Casa ------");
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Area contruida: " + this.getAreaConstriuda());
        System.out.println("Vaga garagem: " + this.getVagaGaragem());
        System.out.println("Quadra: " + this.getQuadra());
        System.out.println("Lote: " + this.getLote());
        System.out.println("Valor: " + this.getValorAluguel());
        System.out.println("\n");
    }
}
