package user;

import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import strategy.TempoDeEmprestimo;


public class Funcionario extends Usuario implements TempoDeEmprestimo {

	public Funcionario(String id, String nome) {
		super(id, nome);
	}
	
	public void registrarObservadorDeLivro(Livro livro){}

	@Override
	public Calendar getDataDevolucao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPeriodoDeEmprestimo() {
		return 2;
	}
	

}
