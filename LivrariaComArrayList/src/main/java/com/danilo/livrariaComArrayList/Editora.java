package com.danilo.livrariaComArrayList;

public class Editora {
    private String razaoSocial;
    private String cnpj;

    public Editora(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void mostrarDados(){
        System.out.println("o-o-o-o Editora o-o-o-o");
        System.out.println("Editora: " + this.razaoSocial + "\nCNPJ: " + this.cnpj);
        System.out.println("o-o-o-o o-o-o-o o-o-o-o");
    }
}
