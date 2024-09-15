package com.br.linkedList.Providers;

@FunctionalInterface
public interface IdProvider<T> {
    int getId(T item);
}

//NAO MEXAM NESSA INTFC, ELA É A RESPONSÁVEL PELO ID DAS CLASSES GENERICAS P LINKEDLIST
