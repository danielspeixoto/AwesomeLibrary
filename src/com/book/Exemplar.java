package book;

import java.util.ArrayList;

import state.EstadoExemplar;

public class Exemplar  {
	private final String codigo;
	private EstadoExemplar estadoAtual;
	
	public Exemplar(String codigo, EstadoExemplar estadoInicial) {
		this.codigo = codigo;
		this.estadoAtual = estadoInicial;
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
