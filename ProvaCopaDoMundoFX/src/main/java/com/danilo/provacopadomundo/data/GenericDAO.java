package com.danilo.provacopadomundo.data;

import java.util.List;

public interface GenericDAO<Type>{
    void salvar(Type type);
    void atualizar(Type type);
    void excluir(Type type);
    Type buscar(int id);
    List<Type> buscarTodos();
}
