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
			
			if(ex.getStatus().equals("Dispon�vel")) {
				boolean impedeEmprestimo = false;
				
				if(usuario.getEmprestimos().size() < usuario.getMaximosEmprestimos()) {
					Calendar c = Calendar.getInstance();
					
					if(usuario.getEmprestimos().size() > 0) {
						for(int j=0;j<usuario.getEmprestimos().size();j++) {
							
							// (ii)
							if(usuario.getEmprestimos().get(j).getDataDeDevolucao().compareTo(c.getTime()) < 0) {
								System.out.println("N�o foi poss�vel realizar o empr�stimo do livro " + livro.getTitulo()
								+ " Pois o usu�rio " + usuario.getNome() + " est� devedor");
								impedeEmprestimo = true;
								break;
							}
							
						}
					}
					
					if(livro.getQuantidadeDeReservas() >= livro.getQuantidadeDeExemplares() && impedeEmprestimo == false) {
			
						for(int k=0;k<livro.getReservas().size();k++) {
							
							if(livro.getReservas().get(k).getUsuarioResponsavel().getId() == usuario.getId()) {
								
								//TODO: pq fazer esse for?
								for(int j=0;j<usuario.getQuantidadeDeReservas();j++) {
									
									if(usuario.getReservas().get(j).getLivroAssociado().getId() == livro.getId()) {
										
										System.out.println("O exemplar " + livro.getTitulo() 
										+ " que estava reservado foi emprestado para " + usuario.getNome() + " com sucesso");
										ex.setStatus("Indispon�vel");
										usuario.addEmprestimo(new Emprestimo(usuario,livro));
										usuario.getReservas().remove(j);
										break;
									}
								}
							}
							
							//TODO: pq fazer essa compara��o, e n�o as compara��es de tamanho do array
							//de reservas e exemplares disponiveis?
							if(i == livro.getReservas().size() - 1) {
								System.out.println("N�o foi poss�vel realizar o empr�stimo do livro " + livro.getTitulo()
								+ " Pois o usu�rio " + usuario.getNome() +
								" n�o possui reserva e todos os exemplares j� est�o reservados");
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
							
							System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " 
						+ usuario.getNome() + " com sucesso e a reserva foi concluida");
							ex.setStatus("Indispon�vel");
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
							System.out.println("O exemplar " + livro.getTitulo() +
									" Foi emprestado para " + usuario.getNome() + " com sucesso");
							
							ex.setStatus("Indispon�vel");
							usuario.addEmprestimo(new Emprestimo(usuario,livro));
						}
					}
				}
				
				// (iii)
				else {
					System.out.println("N�o foi poss�vel realizar o empr�stimo do livro " 
				+ livro.getTitulo() + " Pois o usu�rio " + usuario.getNome() 
				+ " J� realizou o n�mero m�ximo de empr�stimos");
				}
				break;
			}
			
			// (vi)
			else if(usuario.getEmprestimos().get(i).getLivroAssociado().getId() == livro.getId()) {
				System.out.println("N�o foi poss�vel realizar o empr�stimo do livro " + livro.getTitulo()
				+ " pois o usu�rio " + usuario.getNome() + " ja possui um empr�stimo corrente deste livro");

				break;
			}
			// (i)
			else if(i==livro.getQuantidadeDeExemplares()-1) {
				System.out.println("N�o foi possivel realizar o empr�stimo do livro " +
				livro.getTitulo() + " Para " + usuario.getNome() + " pois todos os exemplares est�o Indispon�veis");
				break;
			}
			
		}
		
	}

}
