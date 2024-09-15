package com.br.linkedList;

import com.br.linkedList.Providers.IdProvider;

public class LinkedList<T> {
    /*
     * Como não fizemos com Array interno, e sim só lista genérica, não dá pra ordenar com bubblesort padrao, já que é pra int
     * */
    public Node<T> head;

    public LinkedList() {
        head = null;
    }

    public void append(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();

            }
            lastNode.setNext(newNode);
        }
    }

    public String getAll() {
        Node<T> allNode = head;
        StringBuilder nodeString = new StringBuilder();
        if (allNode == null) {
            return "Não existem objetos registrados";
        }
        while (allNode != null) {
            nodeString.append(allNode.getValue());
            allNode = allNode.getNext();
        }
        return nodeString.toString();
    }

    public String findById(int id, IdProvider<T> idProvider) {
        Node<T> nodeId = head;
        StringBuilder nodeString = new StringBuilder();

        while (nodeId != null) {
            T item = nodeId.getValue();
            if (idProvider.getId(item) == id) {
                nodeString.append(item.toString()).append("\n");
                return nodeString.toString();
            }
            nodeId = nodeId.getNext();
        }

        return "Não existem objetos registrados com esse id";
    }

    public String removeById(int id, IdProvider<T> idProvider) {
        if (head == null) {
            return "A lista está vazia";
        }

        if (idProvider.getId(head.getValue()) == id) {
            head = head.getNext();
            return "Nó removido com sucesso";
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && idProvider.getId(current.getValue()) != id) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return "Não foi encontrado nenhum nó com o id fornecido";
        }

        previous.setNext(current.getNext());
        return "Nó removido com sucesso";

    }

}