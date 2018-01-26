package book;

import java.util.ArrayList;

import funcionalidades.Reserva;
import observer.*;
import state.EstadoExemplar;
import state.EstadoLivro;
import user.Usuario;

public class Livro implements Subject{
	private final String id;
	private final String titulo;
	private final String editora;
	private final String autores;
	private final String edicao;
	private final String anoDePublicacao;
	private ArrayList<Reserva> reservas;
	private ArrayList exemplares = new ArrayList();
	private ArrayList observers;
	
	private EstadoLivro estadoAtual;
	
	
	public Livro(String id, String titulo, String editora, String autores, String edicao, String anoDePublicacao, EstadoLivro estadoInicial) {
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoDePublicacao = anoDePublicacao;		
		this.estadoAtual = estadoInicial;
		
	}
	

	public void adicionaExemplar(String codigo, EstadoExemplar estadoInicial){
		exemplares.add(new Exemplar(codigo,estadoInicial));
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
			this.notifyObserver();
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
	public void notifyObserver() {

		for(int i = 0; i < observers.size(); i++){
	           Observer o = (Observer)observers.get(i);
		}
		
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
	
	public EstadoLivro getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(EstadoLivro estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	
	
}
