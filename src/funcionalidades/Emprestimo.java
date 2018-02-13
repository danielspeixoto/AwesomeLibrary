package funcionalidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import book.Livro;
import strategy.TempoDeEmprestimo;
import user.Usuario;

public class Emprestimo {
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Usuario usuarioAssociado;
	private Livro livroAssociado;
	private Calendar dataDeEmprestimo;
	private Calendar dataDeDevolucao;
	private String status;
	
	public Emprestimo(Usuario usuarioAssociado, Livro livroAssociado) {
		this.usuarioAssociado = usuarioAssociado;
		this.livroAssociado = livroAssociado;
		
		Calendar c = Calendar.getInstance();
		this.dataDeEmprestimo = c;
		
		Calendar d = Calendar.getInstance();
		d.add(Calendar.DATE, usuarioAssociado.getPeriodoDeEmprestimo());
		this.dataDeDevolucao = d;
		this.status = "Em curso";
		
	}

	public Date getDataDeDevolucao() {
		return dataDeDevolucao.getTime();
	}
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo.getTime();
	}
	
	public String getDataDeDevolucaoString() {
		return dateFormat.format(dataDeDevolucao.getTime());
	}
	
	public String getDataDeEmprestimoString() {
		return dateFormat.format(dataDeEmprestimo.getTime());
	}
	


	public Usuario getUsuarioAssociado() {
		return usuarioAssociado;
	}

	public Livro getLivroAssociado() {
		return livroAssociado;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String setStatus(String status) {
		return this.status = status;
	}
	
	
}
