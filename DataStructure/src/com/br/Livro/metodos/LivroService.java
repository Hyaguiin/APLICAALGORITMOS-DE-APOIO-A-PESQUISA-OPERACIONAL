package com.br.Livro.metodos;

import com.br.Livro.model.Livro;
import com.br.linkedList.LinkedList;
import com.br.linkedList.Exception.FailedToCreate;
import com.br.linkedList.Exception.FailedToDelete;
import com.br.linkedList.Exception.NotFound;
import com.br.linkedList.Providers.LivroIdProvider;
import com.br.linkedList.bubbleSort.BubbleSort;

public class LivroService {
	private LinkedList<Livro> livros;
	private LivroIdProvider idProvider;

	public LivroService() {
		this.livros = new LinkedList<>();
		this.idProvider = new LivroIdProvider();
	}

	public void adicionarLivro(Livro livro) {
		try {
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