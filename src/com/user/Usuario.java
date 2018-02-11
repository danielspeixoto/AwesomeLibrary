package user;

import java.util.ArrayList;

import book.Exemplar;
import book.Livro;
import funcionalidades.*;
import state.ExemplarDisponivel;
import state.ExemplarIndisponivel;
import strategy.TempoDeEmprestimo;

public abstract class Usuario {
	private final String id;
	private final String nome;
	private ArrayList<Reserva> reservas;
	private ArrayList<Emprestimo> emprestimos;
	private ArrayList<Emprestimo> historico;
	private TempoDeEmprestimo tipo;
	
	
	
	public Usuario(String id, String nome, TempoDeEmprestimo tipo){
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		reservas = new ArrayList();
		emprestimos = new ArrayList();
		historico = new ArrayList();
	}
	
	public void requerirEmprestimo(Livro livro){
		tipo.fazerEmprestimo(this, livro);
	}
	
	public void fazerDevolução(Livro livro){
		if(this.getEmprestimos().size() == 0) {
			System.out.println("O exemplar " + livro.getTitulo() + " não pode ser devolvido por " + this.getNome() + " pois não há exemplares emprestados");
		}
		for(int i=0;i<this.getEmprestimos().size();i++) {
			if(this.getEmprestimos().get(i).getLivroAssociado().getId() == livro.getId()) {
				Emprestimo emp = this.getEmprestimos().get(i);
				this.getEmprestimos().remove(i);
				emp.setStatus("Finalizado");
				this.historico.add(emp);
				System.out.println("O exemplar " + livro.getTitulo() + " que estava emprestado para " + this.getNome() + " foi devolvido com sucesso");
				for(int j=0;j<emp.getLivroAssociado().getQuantidadeDeExemplares();j++) {
					Exemplar ex = livro.getExemplares().get(j);
					if(ex.getEstadoAtual().getStatus() == "Indisponível") {
						ex.setEstadoAtual(new ExemplarDisponivel());
						break;
					}
				}
			}
			else if(i == this.getEmprestimos().size()-1) {
				System.out.println("O exemplar " + livro.getTitulo() + " não pode ser devolvido por " + this.getNome() + " pois não há exemplares emprestados");
			}
		}
	}
	
	public void registrarObservadorDeLivro(Livro livro){}

	
	public int getQuantidadeDeReservas(){
		return reservas.size();
	}
	
	public void adicionaReserva(Livro livro){
		
	}
	
	public boolean existeReservaDoMesmoLivro(Livro livro){
		for(int i = 0; i < reservas.size(); i++)
			if(reservas.get(i).getLivroAssociado().getId().equals(livro.getId()))
				return true;
		
		return false;		
	}
	

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public void addEmprestimo(Emprestimo emprestimo){
		this.getEmprestimos().add(emprestimo);
	}
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public ArrayList<Emprestimo> getHistorico() {
		return historico;
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPeriodoDeEmprestimo(){
		return 0;
	}
	
	public int getMaximosEmprestimos(){
		return 0;
	}
	
}
