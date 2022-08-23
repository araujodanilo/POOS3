package com.danilo.livraria;

public class Editora {
    private String cnpj;
    private String razaoSocial;

    public Editora() {
    }

    public Editora(String razaoSocial, String cnpj) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void mostrarDados() {
        System.out.println("Razao social: " + this.razaoSocial + "\nCNPJ: " + this.cnpj);
    }
}
