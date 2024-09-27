package com.br.linkedList.TreeNode;

import com.br.Livro.model.Livro;

public class Tree {
    private Livro value;
    private Tree left;   
    private Tree right;  // n pode ser previous e nem next, n é linkedlist

    public Tree(Livro value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Livro getValue() {
        return value;
    }

    public void setValue(Livro value) {
        this.value = value;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
