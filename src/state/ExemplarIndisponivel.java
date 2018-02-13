package state;

import book.Exemplar;
import book.Livro;
import user.Usuario;

public class ExemplarIndisponivel implements EstadoExemplar {


	@Override
	public String getStatus() {
		return "Indisponível";
	}

}
