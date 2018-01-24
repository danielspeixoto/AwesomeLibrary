package book;

import java.util.ArrayList;

public class Livro {
	private final String id;
	private final String titulo;
	private final String editora;
	private final String autores;
	private final String edicao;
	private final String anoDePublicacao;
	
	private ArrayList livros = new ArrayList();
	
	
	public Livro(String id, String titulo, String editora, String autores, String edicao, String anoDePublicacao) {
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoDePublicacao = anoDePublicacao;
		
		//TODO modificar construtores de Exemplar e Livro, para que nao adicione livros repetidos ao ArrayList
		livros.add(this);
	}

	public String getId() {
		return id;
	}

	public String getEditora() {
		return editora;
	}

	public String getAutores() {
		return autores;
	}

	public String getEdicao() {
		return edicao;
	}
	
	public String getAnoDePublicacao() {
		return anoDePublicacao;
	}
	
	
	
}
