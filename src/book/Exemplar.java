package book;

import java.util.ArrayList;

import funcionalidades.Emprestimo;
import user.Usuario;

public class Exemplar  {
	private final String codigo;
	private Emprestimo emprestimo;
	private String status;
	
	public Exemplar(String codigo) {
		this.codigo = codigo;
		this.status = "Disponível";
	}
	
	public void associarEmprestimo(Emprestimo emprestimo){
		this.emprestimo = emprestimo;
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

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodigo() {
		return codigo;
	}


	
	
}
