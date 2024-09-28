package com.br.linkedList.TreeNode;

import com.br.Livro.model.Livro;

public class BinaryTree {
    private Tree root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Livro livro) {
        root = insertRec(root, livro);
    }

    private Tree insertRec(Tree root, Livro livro) {
        if (root == null) {
            root = new Tree(livro);
            return root;
        }
        if (livro.getTitulo().compareTo(root.getValue().getTitulo()) < 0) {
            root.setLeft(insertRec(root.getLeft(), livro));
        } else if (livro.getTitulo().compareTo(root.getValue().getTitulo()) > 0) {
            root.setRight(insertRec(root.getRight(), livro));
        }
        return root;
    }
    
    
    
    
    

    public String searchByAuthor(String author) {
        return searchByAuthorRec(root, author);
    }

    private String searchByAuthorRec(Tree root, String author) {
        if (root == null) {
            return "";
        }
        String result = "";
        if (root.getValue().getAutor().equalsIgnoreCase(author)) {
            result += root.getValue().toString() + "\n";
        }
        result += searchByAuthorRec(root.getLeft(), author);
        result += searchByAuthorRec(root.getRight(), author);
        return result;
    }
}
