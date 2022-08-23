package com.danilo.escoladbfx;

import com.danilo.escoladbfx.data.CidadeSQLiteDAO;
import com.danilo.escoladbfx.model.Cidade;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        CidadeSQLiteDAO cidadeSQLiteDAO = new CidadeSQLiteDAO();
        List<Cidade> cidades = cidadeSQLiteDAO.buscarTodos();

        for (Cidade c: cidades){
            c.mostrarDados();
        }

        Cidade cidade = new Cidade("Araraquara");
        cidade.mostrarDados();
    }
}
