package user;

import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import strategy.TempoDeEmprestimo;

public class Aluno extends Usuario implements TempoDeEmprestimo {
	
	public Aluno(String id, String nome) {
		super(id, nome);
	}
	
	public void registrarObservadorDeLivro(Livro livro){}

	@Override
	public Calendar getDataDevolucao(Emprestimo emprestimo) {
		int i = this.getEmprestimos().indexOf(emprestimo);
		
		Emprestimo e = this.getEmprestimos().get(i);
		
		return e
	}
	
	public int getPeriodoDeEmprestimo(){
		return 5;
	}


}
