package com.danilo.escoladbdao.data;

import java.util.List;

public interface GenericDAO<Type> {
    void salvar(Type type);
    void atualizar(Type type);
    void apagar(Type type);
    Type buscar(int idType);
    List<Type> buscarTodos();
}
