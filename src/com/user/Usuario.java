package user;

import java.util.ArrayList;

public abstract class Usuario {
	private final String id;
	private final String nome;
	
	public Usuario(String id, String nome){
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
}
