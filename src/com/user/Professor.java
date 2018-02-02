package user;

import java.util.ArrayList;
import java.util.Calendar;

import book.Livro;
import funcionalidades.Emprestimo;
import observer.*;
import strategy.TempoDeEmprestimo;

public class Professor extends Usuario implements Observer {
	
	private int notificacoesDeReserva;
	private Subject livroObservado;
	
	public Professor(String id, String nome, TempoDeEmprestimo tipo) {
		super(id, nome, tipo);
		
		this.notificacoesDeReserva = 0;
	}
	
	public void registrarObservadorDeLivro(Livro livro){
		livroObservado.registerObservers(this);
	}

	@Override
	public void update() {
		this.notificacoesDeReserva++;
		
	}
	
	public void retornarNotificacoes(){
		System.out.println("O professor "+this.getNome()+" foi notificado "+this.getNotificacoesDeReserva()+" vezes.");
	}

	public int getNotificacoesDeReserva() {
		return notificacoesDeReserva;
	}

	@Override
	public Calendar getDataDevolucao(Emprestimo emprestimo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPeriodoDeEmprestimo() {
		return 7;
	}
	
	public int getMaximosEmprestimos(){
		return Integer.MAX_VALUE;
	}
	


	
}
