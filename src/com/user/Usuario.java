package user;

import java.util.ArrayList;

import book.Livro;
import funcionalidades.*;
import strategy.TempoDeEmprestimo;

public abstract class Usuario {
	private final String id;
	private final String nome;
	private ArrayList<Reserva> reservas;
	private ArrayList<Emprestimo> emprestimos;
	private ArrayList<Historico> historico;
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

	public ArrayList<Historico> getHistorico() {
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
