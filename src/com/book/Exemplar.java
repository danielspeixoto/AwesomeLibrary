package book;

import java.util.ArrayList;

import funcionalidades.Emprestimo;
import state.EstadoExemplar;
import user.Usuario;

public class Exemplar  {
	private final String codigo;
	private EstadoExemplar estadoAtual;
	private Emprestimo emprestimo;
	
	public Exemplar(String codigo, EstadoExemplar estadoInicial) {
		this.codigo = codigo;
		this.estadoAtual = estadoInicial;
	}
	
	public void associarEmprestimo(Emprestimo emprestimo){
		this.emprestimo = emprestimo;
	}
	
	public String retornarStatus(){
		return this.getEstadoAtual().getStatus();
	}
	
	public Usuario getUsuarioResponsavelPorEmprestimo(){
		return this.getEmprestimo().getUsuarioAssociado();
	}


	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public EstadoExemplar getEstadoAtual() {
		return estadoAtual;
	}


	public void setEstadoAtual(EstadoExemplar estadoAtual) {
		this.estadoAtual = estadoAtual;
	}


	public String getCodigo() {
		return codigo;
	}


	
	
}
