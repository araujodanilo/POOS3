package com.danilo.tipoGenericos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public class ListBasket<E> extends Basket<E> {

    private List<E> list;

    public ListBasket(){
        list = new ArrayList<>();
    }

    @Override
    public void put(E item){
        list.add(item);
    }

    @Override
    public E next(){
        Random r = new Random(System.currentTimeMillis());
        int index = abs(r.nextInt() % (list.size()));
        return list.remove(index);
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void addAll(Collection<? extends E> collection){
        for (E item: collection){
            put(item);
        }
    }

    public void getAll(Collection<? super E> collection){
        while(!isEmpty()){
            collection.add(next());
        }
    }

}
