package funcionalidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import book.Livro;
import user.Usuario;

public class Reserva {
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Usuario usuarioResponsavel;
	private Livro livroAssociado;
	private Calendar dataDeReserva;
	
	public Reserva(Usuario usuarioResponsavel, Livro livroAssociado) {
		this.usuarioResponsavel = usuarioResponsavel;
		this.livroAssociado = livroAssociado;
		this.dataDeReserva = Calendar.getInstance();
	}


	public Date getDataDeReserva() {
		return dataDeReserva.getTime();
	}
	
	public String getDataDeReservaString() {
		return dateFormat.format(dataDeReserva.getTime());
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
