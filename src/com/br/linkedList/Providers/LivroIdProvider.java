package com.br.linkedList.Providers;

import com.br.Livro.model.Livro;

public class LivroIdProvider implements IdProvider<Livro> {
    @Override
    public int getId(Livro livro) {
        return livro.getId();
    }
}

//CLASS Q IMPLEMENTA A DO ID P USO GENERICO, SERVINDO P CLASSE DOS LIVROS
