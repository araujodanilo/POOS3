package com.danilo.interfacebanco;

public class SeguroVida extends Produto implements ITributavel{
    private double premio;

    public SeguroVida(String descricao, Cliente cliente, double premio) {
        super(descricao, cliente);
        this.premio = premio;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Cliente: "+this.getCliente().getNome() + "\nProduto: " + this.getDescricao() + "\tPremio: " + this.getPremio());
    }

    @Override
    public void calcularTributo() {
        System.out.println("Descrição: " + this.getDescricao() + "\tCliente: " + this.getCliente().getNome());
        System.out.println("Tributo: " + this.getPremio()*0.07 + "\tPremio: " + this.getPremio());
        //return this.getPremio()*0.07;
    }
}
