package strategy;

import java.util.Calendar;

import funcionalidades.Emprestimo;

public interface TempoDeEmprestimo {
	public Calendar getDataDevolucao(Emprestimo emprestimo);
	public int getPeriodoDeEmprestimo();
	public void fazerEmprestimo();

}
