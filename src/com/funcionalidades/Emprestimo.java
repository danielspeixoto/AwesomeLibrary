package funcionalidades;

import java.util.Calendar;
import java.util.Date;

import book.Livro;
import strategy.TempoDeEmprestimo;
import user.Usuario;

public class Emprestimo {
	private Usuario usuarioAssociado;
	private Livro livroAssociado;
	private Calendar dataDeEmprestimo;
	private Calendar dataDeDevolucao;
	
	public Emprestimo(Usuario usuarioAssociado, Livro livroAssociado) {
		this.usuarioAssociado = usuarioAssociado;
		this.livroAssociado = livroAssociado;
		this.dataDeEmprestimo = Calendar.getInstance();	
		this.dataDeDevolucao = Calendar.getInstance();	
		
		this.setDataDeDevolucao(dataDeEmprestimo);
	}

	public Date getDataDeDevolucao() {
		return dataDeDevolucao.getTime();
	}
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo.getTime();
	}

	public void setDataDeDevolucao(Calendar dataDeDevolucao) {
		
	}


	public Usuario getUsuarioAssociado() {
		return usuarioAssociado;
	}

	public Livro getLivroAssociado() {
		return livroAssociado;
	}
	
	
	
	
}
