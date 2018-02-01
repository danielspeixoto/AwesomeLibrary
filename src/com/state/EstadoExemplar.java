package state;

import book.Exemplar;
import book.Livro;
import user.Usuario;

public interface EstadoExemplar {
	public void emprestarExemplar(Usuario usuario, Livro livro, Exemplar ex);
	public void devolverExemplar();
	public void reservarExemplar();
	public String getStatus();
}
