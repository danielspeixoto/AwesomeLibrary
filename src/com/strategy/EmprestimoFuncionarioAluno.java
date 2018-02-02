package strategy;

import java.util.Calendar;

import book.Exemplar;
import book.Livro;
import funcionalidades.Emprestimo;
import state.EstadoExemplar;
import state.ExemplarDisponivel;
import user.Usuario;

public class EmprestimoFuncionarioAluno implements TempoDeEmprestimo {

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
		for(int i=0;i<livro.getQuantidadeDeExemplares();i++) {
			Exemplar ex = livro.getExemplares().get(i);
			if(ex.getEstadoAtual() instanceof ExemplarDisponivel) {
				ex.getEstadoAtual().emprestarExemplar(usuario, livro, ex);
				break;
			}
			else if(i==livro.getQuantidadeDeExemplares()-1) {
				System.out.println("Não foi possivel realizar o empréstimo do livro " +
			livro.getTitulo() + " Para " + usuario.getNome() + " pois todos os exemplares estão Indisponíveis");
			}
		}
		
	}

}
