package strategy;

import java.util.Calendar;

import book.Exemplar;
import book.Livro;
import funcionalidades.Emprestimo;
import state.EstadoExemplar;
import state.ExemplarDisponivel;
import state.ExemplarIndisponivel;
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
			if(ex.getEstadoAtual().getStatus() == "Disponível") {
				boolean impedeEmprestimo = false;
				if(usuario.getEmprestimos().size() < usuario.getMaximosEmprestimos()) {
					Calendar c = Calendar.getInstance();
					if(usuario.getEmprestimos().size() > 0) {
						for(int j=0;j<usuario.getEmprestimos().size();j++) {
							if(usuario.getEmprestimos().get(j).getDataDeDevolucao().compareTo(c.getTime()) < 0) {
								System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo()
								+ " Pois o usuário " + usuario.getNome() + " está devedor");
								impedeEmprestimo = true;
								break;
							}
							if(usuario.getEmprestimos().get(j).getLivroAssociado().getId() == livro.getId()) {
								System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo()
								+ " pois o usuário " + usuario.getNome() + " ja possui um empréstimo corrente deste livro");
								impedeEmprestimo = true;
								break;
							}
						}
					}
					if(livro.getQuantidadeDeReservas() >= livro.getQuantidadeDeExemplares() && impedeEmprestimo == false) {
						for(int k=0;k<livro.getReservas().size();k++) {
							if(livro.getReservas().get(k).getUsuarioResponsavel().getId() == usuario.getId()) {
								for(int j=0;j<usuario.getQuantidadeDeReservas();j++) {
									if(usuario.getReservas().get(j).getLivroAssociado().getId() == livro.getId()) {
										System.out.println("O exemplar " + livro.getTitulo() + " que estava reservado foi emprestado para " + usuario.getNome() + " com sucesso");
										ex.setEstadoAtual(new ExemplarIndisponivel());
										usuario.addEmprestimo(new Emprestimo(usuario,livro));
										usuario.getReservas().remove(j);
										break;
									}
								}
							}
							if(i == livro.getReservas().size() - 1) {
								System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo()
								+ " Pois o usuário " + usuario.getNome() + " não possui reserva e todos os exemplares já estão reservados");
							}
						}						
					}
					else if (impedeEmprestimo == false){
						boolean temReserva = false;
						for(int j=0;j<usuario.getQuantidadeDeReservas();j++) {
							if(usuario.getReservas().get(j).getLivroAssociado().getId() == livro.getId()) {
								temReserva = true;
							}
						}
						if(temReserva == true) {
							System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " + usuario.getNome() + " com sucesso e a reserva foi concluida");
							ex.setEstadoAtual(new ExemplarIndisponivel());
							usuario.addEmprestimo(new Emprestimo(usuario,livro));
							if(usuario.getQuantidadeDeReservas() > 0) {
								for(int j=0;j<usuario.getQuantidadeDeReservas();j++) {
									if(usuario.getReservas().get(j).getLivroAssociado().getId() == livro.getId()) {
										usuario.getReservas().remove(j);
									}
								}
							}	
						}
						else{
							System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " + usuario.getNome() + " com sucesso");
							ex.setEstadoAtual(new ExemplarIndisponivel());
							usuario.addEmprestimo(new Emprestimo(usuario,livro));
						}
					}
				}
				else {
					System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo() + " Pois o usuário " + usuario.getNome() + " Já realizou o número máximo de empréstimos");
				}
				break;
			}
			else if(i==livro.getQuantidadeDeExemplares()-1) {
				System.out.println("Não foi possivel realizar o empréstimo do livro " +
			livro.getTitulo() + " Para " + usuario.getNome() + " pois todos os exemplares estão Indisponíveis");
			}
		}
		
	}

}
