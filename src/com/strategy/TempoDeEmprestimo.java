package strategy;

import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import user.Usuario;

public interface TempoDeEmprestimo {
	public Calendar getDataDevolucao(Emprestimo emprestimo);
	public int getPeriodoDeEmprestimo();
	public void fazerEmprestimo(Usuario usuario, Livro livro);

}
