package com.br.Livro.metodos;

import java.util.Random;

import com.br.Livro.model.Livro;
import com.br.linkedList.LinkedList;
import com.br.linkedList.Node;
import com.br.linkedList.Exception.FailedToCreate;
import com.br.linkedList.Exception.FailedToDelete;
import com.br.linkedList.Exception.NotFound;
import com.br.linkedList.Providers.LivroIdProvider;
import com.br.linkedList.TreeNode.BinaryTree;
import com.br.linkedList.bubbleSort.BubbleSort;

public class LivroService {
	private LinkedList<Livro> livros;
	private LivroIdProvider idProvider;
	private BinaryTree recomendacao;

	public LivroService() {
		this.livros = new LinkedList<>();
		this.idProvider = new LivroIdProvider();
		this.recomendacao = new BinaryTree();
	}
	
	
	 public String recomendarLivroAleatorioPorAutor(String autor) { //EEsse aqui foi pancada, plmds se for alterar, mandar em outra branch
	        Node<Livro> current = livros.head; 
	        LinkedList<Livro> livrosDoAutor = new LinkedList<>(); 

	        while (current != null) {
	            Livro livro = current.getValue();
	            if (livro.getAutor().equalsIgnoreCase(autor)) {
	                livrosDoAutor.append(livro);
	            }
	            current = current.getNext();
	        }

	        if (livrosDoAutor.head == null) {
	            return "Nenhum livro encontrado para o autor: " + autor;
	        }

	        Random rand = new Random();
	        int randomIndex = rand.nextInt(livrosDoAutor.getSize()); 
	        Node<Livro> randomNode = livrosDoAutor.head;

	       
	        for (int i = 0; i < randomIndex; i++) {
	            randomNode = randomNode.getNext();
	        }

	        return randomNode.getValue().toString();
	    }
	

	public void adicionarLivro(Livro livro) {  //Aqui vai tnt adicioanr a lista quanto a arvore
		try {
			recomendacao.insert(livro);
			livros.append(livro);
		} catch (FailedToCreate err) {
			throw new FailedToCreate("Não foi possível criar o Objeto livro", err);
		}
	}

	public String listarLivros() {
		try {

			return livros.getAll();

		} catch (NotFound err) {
			throw new NotFound("Livros não encontrados!", err);
		}

	}

	public String buscarLivroPorId(int id) {
		try {

			return livros.findById(id, idProvider);

		} catch (NotFound err) {
			throw new NotFound("Livro não encontrado pelo id! ", err);
		}

	}

	public void removerLivroPorId(int id) {
		
		try {

			 livros.removeById(id, idProvider);

		} catch (FailedToDelete err) {
			throw new FailedToDelete("Livro não eremovido pelo id! ", err);
		}
	}
	
	public String SortAutor() {
		try{
			BubbleSort.sortByAutor(livros);
			return livros.getAll();
		}catch(Exception err){
			throw new RuntimeException("Não foi possível sortear os livros pelo autor! ", err);
		}
		
	}

	
	public String sortTitulo() {
		try{
			BubbleSort.sortByTitulo(livros);
			return livros.getAll();
		}catch(Exception err){
			throw new RuntimeException("Não foi possível sortear os livros pelo título! ", err);

		}
	}
	
	
	
}