package state;

import book.Exemplar;
import book.Livro;
import user.Usuario;

public class ExemplarEmprestado implements EstadoExemplar {


	@Override
	public void emprestarExemplar(Usuario usuario, Livro livro, Exemplar ex) {
		// TODO Auto-generated method stub
		
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
		return "Emprestado";
	}


}
