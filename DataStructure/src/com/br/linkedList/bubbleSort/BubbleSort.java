package com.br.linkedList.bubbleSort;

import com.br.linkedList.LinkedList;
import com.br.linkedList.Node;
import com.br.Livro.model.Livro;

public class BubbleSort {

    private static void bubbleSort(LinkedList<Livro> list, java.util.function.Function<Livro, String> keyExtractor) {
        if (list.head == null || list.head.getNext() == null) {
            return; 
        }

        boolean foiTrocado;
        do {
            foiTrocado = false;
            Node<Livro> current = list.head;
            Node<Livro> previous = null;

            while (current != null && current.getNext() != null) {
                Node<Livro> next = current.getNext();
                if (keyExtractor.apply(current.getValue()).compareTo(keyExtractor.apply(next.getValue())) > 0) {
                    if (previous != null) {
                        previous.setNext(next);
                    } else {
                        list.head = next;
                    }
                    current.setNext(next.getNext());
                    next.setNext(current);
                    foiTrocado = true;
                    previous = next;
                } else {
                    previous = current;
                }
                current = current.getNext();
            }
        } while (foiTrocado);
    }

    public static void sortByTitulo(LinkedList<Livro> list) {
        bubbleSort(list, Livro::getTitulo);
    }

    public static void sortByAutor(LinkedList<Livro> list) {
        bubbleSort(list, Livro::getAutor);
    }
}
