package user;

import java.util.ArrayList;

import book.Exemplar;
import book.Livro;
import funcionalidades.*;
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
	
	public void fazerDevolucao(Livro livro){
		if(this.getEmprestimos().size() == 0) {
			System.out.println("O exemplar " + livro.getTitulo() + " não pode ser devolvido por " +
		this.getNome() + " pois não há exemplares emprestados");
		}
		for(int i=0;i<this.getEmprestimos().size();i++) {
			if(this.getEmprestimos().get(i).getLivroAssociado().getId() == livro.getId()) {
				Emprestimo emp = this.getEmprestimos().get(i);
				this.getEmprestimos().remove(i);
				emp.setStatus("Finalizado");
				this.historico.add(emp);
				System.out.println("O exemplar " + livro.getTitulo() + " que estava emprestado para "
				+ this.getNome() + " foi devolvido com sucesso");

				for(int j=0;j<emp.getLivroAssociado().getQuantidadeDeExemplares();j++) {
					Exemplar ex = livro.getExemplares().get(j);
					if(ex.getStatus() == "Indisponível") {
						ex.setStatus("Disponível");
						break;
					}
				}
			}
			else if(i == this.getEmprestimos().size()-1) {
				System.out.println("O exemplar " + livro.getTitulo() + " não pode ser devolvido por " + this.getNome() + " pois não há exemplares emprestados");
			}
		}
	}
	
	public void apresentarHistorico(){
		
		System.out.println("Empréstimos correntes: ");
		//historico de emprestimos correntes
		for(int i = 0; i < emprestimos.size(); i++){
			Emprestimo emp = emprestimos.get(i);
			System.out.println("Título: "+emp.getLivroAssociado().getTitulo());
			System.out.println("Data de Empréstimo: "+emp.getDataDeEmprestimoString());
			String status = emp.getStatus();
			
			System.out.println("Status: "+status);
			
			if(status.equals("Finalizado"))
				System.out.println("Data de de devolução finalizada: "+emp.getDataDeDevolucaoString());
			else
				System.out.println("Data de de devolução prevista: "+emp.getDataDeDevolucaoString());
			
		}
		
		System.out.println("Empréstimos passados: ");
		
		//historico de emprestimos passados
		for(int i = 0; i < historico.size(); i++){
			Emprestimo emp = historico.get(i);
			System.out.println("Título: "+emp.getLivroAssociado().getTitulo());
			System.out.println("Data de Empréstimo: "+emp.getDataDeEmprestimoString());
			String status = emp.getStatus();
			
			System.out.println("Status: "+status);
			
			if(status.equals("Finalizado"))
				System.out.println("Data de de devolução finalizada: "+emp.getDataDeDevolucaoString());
			else
				System.out.println("Data de de devolução prevista: "+emp.getDataDeDevolucaoString());
			
		}
		
		System.out.println("Reservas: ");
		for(int i = 0; i < reservas.size(); i++){
			Reserva res = reservas.get(i);
			System.out.println("Título: "+res.getLivroAssociado().getTitulo());
			System.out.println("Data de Solicitação: "+res.getDataDeReservaString());
			
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
