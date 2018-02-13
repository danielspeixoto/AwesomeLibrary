package state;

import java.util.Calendar;

import book.Exemplar;
import book.Livro;
import funcionalidades.Emprestimo;
import user.Usuario;

public class ExemplarDisponivel implements EstadoExemplar {


	@Override
	public String getStatus() {
		return "Disponível";
	}

}
