package com.danilo.provacopadomundo.data;

import java.util.List;

public interface GenericDAO<Type>{

    void save(Type type);
    void update(Type type);
    void erase(Type type);
    Type search(int id);
    List<Type> searchAll();
}
