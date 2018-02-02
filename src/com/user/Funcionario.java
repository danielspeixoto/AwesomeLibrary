package user;

import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import strategy.TempoDeEmprestimo;


public class Funcionario extends Usuario {

	public Funcionario(String id, String nome, TempoDeEmprestimo tipo) {
		super(id, nome, tipo);
	}
	
	public void registrarObservadorDeLivro(Livro livro){}
	
	public int getPeriodoDeEmprestimo(){
		return 2;
	}
	
	public int getMaximosEmprestimos(){
		return 3;
	}
}
