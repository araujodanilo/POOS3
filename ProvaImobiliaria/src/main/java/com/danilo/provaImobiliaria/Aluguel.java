package com.danilo.provaImobiliaria;

public class Aluguel {
    private String inicioContrato;
    private String fimContrato;
    private int diaPagamento;
    private Imovel imovel;
    private Inquilino inquilino;
    private Corretor corretor;

    public Aluguel(String inicioContrato, String fimContrato, int diaPagamento, Imovel imovel, Inquilino inquilino, Corretor corretor) {
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
        this.diaPagamento = diaPagamento;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.corretor = corretor;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public String getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public String getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(String fimContrato) {
        this.fimContrato = fimContrato;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public void mostrarDadosAluguel(){
        System.out.println("--- Aluguel / Contrato ---");
        System.out.println("Data do inicio contrato: " + this.getInicioContrato());
        System.out.println("Data do final contrato: " + this.getFimContrato());
        System.out.println("Dia do pagamento previsto: " + this.getDiaPagamento());
        System.out.println("Nome do inquiino: " + this.getInquilino().getNome());
        System.out.println("Nome do corretor: " + this.getCorretor().getNome());
        System.out.println("Nome do Propietario: " + this.getImovel().getProprietario().getNome());
        System.out.println("\n");
    }

}
