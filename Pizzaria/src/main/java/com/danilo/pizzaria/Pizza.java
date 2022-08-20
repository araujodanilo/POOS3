package com.danilo.pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Produto {
    private boolean bordaRecheada;
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public Pizza(String descricao, double preco, boolean bordaRecheada) {
        super(descricao, preco);
        this.bordaRecheada = bordaRecheada;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void adicionarIngredientes(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public void retirarIngredientes(Ingrediente ingrediente){
        this.ingredientes.remove(ingrediente);
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isBordaRecheada() {
        return bordaRecheada;
    }

    public void setBordaRecheada(boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Preço: R$" + this.getPreco());
        if (this.bordaRecheada){
            System.out.println("Borda Recheada!");
        }else{
            System.out.println("Borda não Recheada! ='(");
        }
        System.out.println("Igredientes:");
        for(Ingrediente ingrediente : this.getIngredientes()){
            System.out.println(" "+ingrediente.getNome());
        }
        System.out.println();
    }
}
