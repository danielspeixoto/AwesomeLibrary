package user;

import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import strategy.TempoDeEmprestimo;

public class Aluno extends Usuario {
	
	public Aluno(String id, String nome, TempoDeEmprestimo tipo) {
		super(id, nome,tipo);
	}
	
	public void registrarObservadorDeLivro(Livro livro){}

	
	
	public int getPeriodoDeEmprestimo(){
		return 5;
	}
	
}
