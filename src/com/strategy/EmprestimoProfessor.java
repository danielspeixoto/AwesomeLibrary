package strategy;

import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import user.Usuario;

public class EmprestimoProfessor implements TempoDeEmprestimo {

	@Override
	public Calendar getDataDevolucao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPeriodoDeEmprestimo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fazerEmprestimo(Usuario usuario, Livro livro) {
		// TODO Auto-generated method stub
		
	}

}
