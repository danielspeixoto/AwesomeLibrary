package state;

import java.util.Calendar;

import book.Exemplar;
import book.Livro;
import funcionalidades.Emprestimo;
import user.Usuario;

public class ExemplarDisponivel implements EstadoExemplar {

	@Override
	public void emprestarExemplar(Usuario usuario, Livro livro, Exemplar ex) {
		boolean impedeEmprestimo = false;
		if(usuario.getEmprestimos().size() < usuario.getMaximosEmprestimos()) {
			Calendar c = Calendar.getInstance();
			if(usuario.getEmprestimos().size() > 0) {
				for(int i=0;i<usuario.getEmprestimos().size();i++) {
					if(usuario.getEmprestimos().get(i).getDataDeDevolucao().compareTo(c.getTime()) < 0) {
						System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo()
						+ " Pois o usuário " + usuario.getNome() + " está devedor");
						impedeEmprestimo = true;
						break;
					}
					if(usuario.getEmprestimos().get(i).getLivroAssociado().getId() == livro.getId()) {
						System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo()
						+ " pois o usuário " + usuario.getNome() + " ja possui um empréstimo corrente deste livro");
						impedeEmprestimo = true;
						break;
					}
				}
			}
			if(livro.getQuantidadeDeReservas() >= livro.getQuantidadeDeExemplares() && impedeEmprestimo == false) {
				for(int i=0;i<livro.getReservas().size();i++) {
					if(livro.getReservas().get(i).getUsuarioResponsavel().getId() == usuario.getId()) {
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
					System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " + usuario.getNome() + " Com sucesso e a reserva foi concluida");
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
					System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " + usuario.getNome() + " Com sucesso");
					ex.setEstadoAtual(new ExemplarIndisponivel());
					usuario.addEmprestimo(new Emprestimo(usuario,livro));
				}
			}
		}
		else {
			System.out.println("Não foi possível realizar o empréstimo do livro " + livro.getTitulo() + " Pois o usuário " + usuario.getNome() + " Já realizou o número máximo de empréstimos");
		}
	}

	@Override
	public void devolverExemplar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reservarExemplar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStatus() {
		return "Disponível";
	}

}
