package book;

import java.util.ArrayList;

import funcionalidades.Reserva;
import observer.*;
import user.Usuario;

public class Livro implements Subject{
	private final String id;
	private final String titulo;
	private final String editora;
	private final String autores;
	private final String edicao;
	private final String anoDePublicacao;
	private ArrayList<Reserva> reservas = new ArrayList();
	private ArrayList<Exemplar> exemplares = new ArrayList();
	private ArrayList<Observer> observers =  new ArrayList();

		
	public Livro(String id, String titulo, String editora, String autores, String edicao, String anoDePublicacao) {
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoDePublicacao = anoDePublicacao;		
		
	}
	

	public void adicionaExemplar(String codigo){
		exemplares.add(new Exemplar(codigo));
	}
	
	public void reservarLivro(Usuario usuario){
		
		if(usuario.getQuantidadeDeReservas() == 3)
			System.out.println("Impossível efetuar reserva do livro "+this.getTitulo()+", o usuario "+
		usuario.getNome()+" tem 3 reservas de livros, limite máximo permitido.");
		
		else if(usuario.existeReservaDoMesmoLivro(this))
			System.out.println("Este livro já foi reservado anteriormente.");
		
		else{
			//adiciona reserva ao livro
			reservas.add(new Reserva(usuario,this));
			
			//adiciona reserva ao usuario
			usuario.getReservas().add(new Reserva(usuario,this));
			
			System.out.println("Reserva do livro "+this.getTitulo()+", feita pelo usuario "+
					usuario.getNome()+" realizada com sucesso.");
			
			this.verificaReservasSimultaneas();
		}
					
		
	}
	
	public void verificaReservasSimultaneas(){
		
		if(reservas.size() > 2)
			this.notifyObservers();
	}
	
	
	@Override
	public void registerObservers(Observer o) {
		observers.add(o);
		
	}


	@Override
	public void removeObservers(Observer o) {
		int i = observers.indexOf(o);
		
		if(i >= 0)
			observers.remove(i);
		
	}


	@Override
	public void notifyObservers() {

		for(int i = 0; i < observers.size(); i++){
	           Observer o = (Observer)observers.get(i);
	           o.update();
		}
		
	}
	
	public void mostrarInformacoes(){
		System.out.println("Título: "+this.getTitulo());
		System.out.println("Quantidade de reservas: "+this.getQuantidadeDeReservas());
		
		if(this.getQuantidadeDeReservas() > 0){
			System.out.println("Usuários Responsáveis:");
			this.mostrarUsuariosResponsaveisPorReserva();
		}
		
		this.getInformacoesDosExemplares();
	}
	
	
	public void mostrarUsuariosResponsaveisPorReserva(){
		for(int i = 0; i < this.getQuantidadeDeReservas(); i++)
			System.out.println(this.getReservas().get(i).getUsuarioResponsavel().getNome());
	}
	
	
	
	public void getInformacoesDosExemplares(){
		System.out.println("Exemplares:");
		
		for(int i = 0; i < this.getQuantidadeDeExemplares(); i++){
			Exemplar exemplar = this.getExemplares().get(i);
			String status = exemplar.getStatus();
			
			System.out.println("Código: "+exemplar.getCodigo());
			System.out.println("Status: "+status);
			
			if(status.equals("Emprestado")){
				Usuario usuario = exemplar.getUsuarioResponsavelPorEmprestimo();
				System.out.println("Usuario Responsável: "+usuario.getNome());
				System.out.println("Data de Empréstimo: "+exemplar.getEmprestimo().getDataDeEmprestimo());
				System.out.println("Data prevista para devolução: "+exemplar.getEmprestimo().getDataDeDevolucao());
			}
		}
	}
	

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public String getId() {
		return id;
	}

	public String getEditora() {
		return editora;
	}

	public String getAutores() {
		return autores;
	}

	public String getEdicao() {
		return edicao;
	}
	
	public String getAnoDePublicacao() {
		return anoDePublicacao;
	}
	

	public String getTitulo() {
		return titulo;
	}
	
	public int getQuantidadeDeReservas(){
		return reservas.size();
	}
	
	public int getQuantidadeDeExemplares(){
		return exemplares.size();
	}
	
	
	
	
}
