package com.danilo.tipoGenericos;

import java.util.Collection;

public abstract class Basket<E> {

    public abstract void put(E item);

    public abstract E next();

    public abstract boolean isEmpty();

    public abstract void addAll(Collection<? extends E> collection);

    public abstract void getAll(Collection<? super E> collection);

}
