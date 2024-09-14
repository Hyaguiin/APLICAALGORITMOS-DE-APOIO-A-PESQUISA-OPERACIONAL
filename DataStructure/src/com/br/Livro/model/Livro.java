package com.br.Livro.model;

public class Livro {
    private static int nextId = 1; 
    private int id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;

    public Livro(String titulo, String autor, Integer anoPublicacao) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "===========================" + "\n" +
                "ID: " + id + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Ano de Publicação: " + (anoPublicacao != null ? anoPublicacao.toString() : "ano não foi cadastrado") + "\n";
    }
}
