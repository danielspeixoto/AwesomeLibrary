package book;

import java.util.ArrayList;

public class Exemplar extends Livro {
	private final String codigo;
	
	private ArrayList exemplares = new ArrayList();
	
	public Exemplar(String id, String titulo, String editora, String autores, String edicao, String anoDePublicacao,
			String codigo) {
		
		super(id, titulo, editora, autores, edicao, anoDePublicacao);
		this.codigo = codigo;
		
		exemplares.add(this);
		
	}


	public String getCodigo() {
		return codigo;
	}


	
	
}
