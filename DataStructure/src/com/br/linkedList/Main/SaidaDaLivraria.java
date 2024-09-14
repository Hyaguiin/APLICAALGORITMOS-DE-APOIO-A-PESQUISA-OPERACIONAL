package com.br.linkedList.Main;

import com.br.Livro.model.Livro;
import com.br.Livro.metodos.LivroService;

import javax.swing.*;

public class SaidaDaLivraria {
    private static LivroService livroService = new LivroService();

    public static void main(String[] args) {
        while (true) {
            String[] opcao = {
                "Adicionar Livro", 
                "Listar Livros", 
                "Buscar Livro por ID", 
                "Remover Livro por ID", 
                "Ordenar por Título", 
                "Ordenar por Autor", 
                "Sair"
            };
            int escolherOpcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Sistema de Livraria",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);

            switch (escolherOpcao) {
                case 0: adicionarLivro(); break;
                case 1: listarLivros(); break;
                case 2: buscarLivroPorId(); break;
                case 3: removerLivroPorId(); break;
                case 4: sortTitulo(); break;
                case 5: sortAutor(); break;
                case 6: System.exit(0); break;
            }
        }
    }

    private static void adicionarLivro() {
        try {
            String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
            String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
            int anoPublicacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de publicação do livro:"));
            
            Livro livro = new Livro(titulo, autor, anoPublicacao);
            livroService.adicionarLivro(livro);
            JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano de publicação deve ser um número.");
        }
    }

    private static void listarLivros() {
        String livros = livroService.listarLivros();
        JOptionPane.showMessageDialog(null, livros.isEmpty() ? "Nenhum livro encontrado." : livros);
    }

    private static void buscarLivroPorId() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do livro:"));
            String livro = livroService.buscarLivroPorId(id);
            JOptionPane.showMessageDialog(null, livro.isEmpty() ? "Livro não encontrado." : livro);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID deve ser um número.");
        }
    }

    private static void removerLivroPorId() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do livro para remover:"));
            livroService.removerLivroPorId(id);
            JOptionPane.showMessageDialog(null, "Livro removido (se existia)!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID deve ser um número.");
        }
    }

    private static void sortTitulo() {
        livroService.sortTitulo();
        JOptionPane.showMessageDialog(null, "Livros ordenados por título:\n" + livroService.listarLivros());
    }

    private static void sortAutor() {
        livroService.SortAutor();
        JOptionPane.showMessageDialog(null, "Livros ordenados por autor:\n" + livroService.listarLivros());
    }
}
