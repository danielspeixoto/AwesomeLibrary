package funcionalidades;

import book.Livro;
import user.Usuario;

public class Reserva {
	private Usuario usuarioResponsavel;
	private Livro livroAssociado;
	
	
	public Reserva(Usuario usuarioResponsavel, Livro livroAssociado) {
		this.usuarioResponsavel = usuarioResponsavel;
		this.livroAssociado = livroAssociado;
	}


	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}


	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}


	public Livro getLivroAssociado() {
		return livroAssociado;
	}


	public void setLivroAssociado(Livro livroAssociado) {
		this.livroAssociado = livroAssociado;
	}
}
