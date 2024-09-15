package com.br.testesBasicos;

import com.br.Livro.model.Livro;
import com.br.linkedList.LinkedList;
import com.br.linkedList.Providers.IdProvider;
import com.br.linkedList.Providers.LivroIdProvider;
import com.br.linkedList.bubbleSort.BubbleSort;

public class TesteMain {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Fla", "Cla", 2003);
        Livro livro2 = new Livro("Bla", "Lla", 2002);
        Livro livro3 = new Livro("Ala", "Qla", 2022);
        
        LinkedList<Livro> lista = new LinkedList<>();
        
        IdProvider<Livro> provider = Livro::getId;
        
        lista.append(livro1);
        lista.append(livro2);
        lista.append(livro3);

        
        BubbleSort.sortByAutor(lista);
        System.out.println(lista.getAll());

    System.out.println("*************");
    BubbleSort.sortByTitulo(lista);
    System.out.println(lista.getAll());
    
    
   System.out.println("Livro encontrado: " + lista.findById(1, provider)); 
   System.out.println("Livro removido esperado: 1 ");
   lista.removeById(1, provider);
   System.out.println(lista.getAll());
   

    
    }
}
