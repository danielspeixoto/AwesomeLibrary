package strategy;

import java.util.Calendar;

import book.Exemplar;
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
		boolean impedeEmprestimo = false;
		for(int i=0;i<livro.getQuantidadeDeExemplares();i++) {
			Exemplar ex = livro.getExemplares().get(i);
			if(ex.getStatus() == "Dispon�vel") {
				for(int j=0;j<usuario.getEmprestimos().size();j++) {
					if(usuario.getEmprestimos().get(i).getLivroAssociado().getId() == livro.getId()) {
						System.out.println("N�o foi poss�vel realizar o empr�stimo do livro " + livro.getTitulo()
						+ " pois o usu�rio " + usuario.getNome() + " ja possui um empr�stimo corrente deste livro");
						impedeEmprestimo = true;
						break;
					}
				}
				if(!impedeEmprestimo) {
					System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " + usuario.getNome() + " com sucesso");
					ex.setStatus("Indispon�vel");
					usuario.addEmprestimo(new Emprestimo(usuario,livro));
				}
				break;
			}
			else if(i==livro.getQuantidadeDeExemplares()-1) {
				System.out.println("N�o foi possivel realizar o empr�stimo do livro " +
			livro.getTitulo() + " Para " + usuario.getNome() + " pois todos os exemplares est�o Indispon�veis");
			}
		}
		
	}

}
