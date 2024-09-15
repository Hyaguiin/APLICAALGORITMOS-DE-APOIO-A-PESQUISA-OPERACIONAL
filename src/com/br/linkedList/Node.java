package com.br.linkedList;

public class Node<T> {
    public Node<T> next;
    public T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
