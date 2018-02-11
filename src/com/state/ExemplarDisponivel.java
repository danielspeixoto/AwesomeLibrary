package state;

import java.util.Calendar;

import book.Exemplar;
import book.Livro;
import funcionalidades.Emprestimo;
import user.Usuario;

public class ExemplarDisponivel implements EstadoExemplar {

	@Override
	public void emprestarExemplar(Usuario usuario, Livro livro, Exemplar ex) {
		
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
