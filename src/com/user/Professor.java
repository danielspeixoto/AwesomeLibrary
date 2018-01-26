package user;

import java.util.ArrayList;

import book.Livro;
import observer.*;

public class Professor extends Usuario implements Observer {
	
	private final int tempoDeEmprestimo = 7;
	private int notificacoesDeReserva;
	private Subject livroObservado;
	
	public Professor(String id, String nome) {
		super(id, nome);
		
		this.notificacoesDeReserva = 0;
	}
	
	public void registrarObservadorDeLivro(Livro livro){
		livroObservado.registerObservers(this);
	}

	@Override
	public void update() {
		this.notificacoesDeReserva++;
		
		System.out.println("Professor "+this.getNome()+" notificado "+this.notificacoesDeReserva+" vezes.");
		
	}


	
}
