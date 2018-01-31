package fachada;

import java.util.ArrayList;

import book.Livro;
import funcionalidades.Emprestimo;
import state.*;
import strategy.*;
import user.*;

public class Facade {
	private static Facade instancia;
	private ArrayList<Usuario> usuarios = new ArrayList();
	private ArrayList<Livro> livros = new ArrayList();
	
	private Facade(){}
	
	public static  Facade getInstancia() {
		
		if(instancia == null){
			instancia = new Facade();
		}
		
		return instancia;
	}
	
	public void registrarUsuarios(){
		usuarios.add(new Funcionario("123","João da Silva", new EmprestimoFuncionarioAluno()));
		usuarios.add(new Aluno("456","Luiz Fernando Rodrigues", new EmprestimoFuncionarioAluno()));
		usuarios.add(new Funcionario("789","Pedro Paulo", new EmprestimoFuncionarioAluno()));
		usuarios.add(new Professor("100","Carlos Lucena", new EmprestimoProfessor()));
	}
	
	public void registrarLivros(){
		
		livros.add(new Livro("100","Engenharia de Software","AddisonWesley","Ian Sommervile","6a","2000"));
		livros.add(new Livro("101","UML – Guia do Usuário","Campus","Grady Booch,James Rumbaugh,Ivar Jacobson","7a","2000"));
		livros.add(new Livro("200","Code Complete","Microsoft Press","Steve McConnell","2a","2014"));
		livros.add(new Livro("201","Agile SoftwareDevelopment,Principles,Patterns,and Practices","Prentice Hall","Robert Martin","1a","2002"));
		livros.add(new Livro("300","Refactoring:Improving the Design of Existing Code","Addison-Wesley Professional","Martin Fowler","1a","1999"));
		livros.add(new Livro("301","Software Metrics: A Rigorous and Practical Approach","CRC Press","Norman Fenton, James Bieman","3a","2014"));
		livros.add(new Livro("400","UML Distilled: A Brief Guide to the Standard Object Modeling Language","Addison-Wesley Professional","Martin Fowler","3a","2003"));

	}
	
	public void registrarExemplares(){
		livros.get(0).adicionaExemplar("01",new ExemplarDisponivel());
		livros.get(0).adicionaExemplar("02",new ExemplarDisponivel());
		livros.get(1).adicionaExemplar("03",new ExemplarDisponivel());
		livros.get(2).adicionaExemplar("04",new ExemplarDisponivel());
		livros.get(3).adicionaExemplar("05",new ExemplarDisponivel());
		livros.get(4).adicionaExemplar("06",new ExemplarDisponivel());
		livros.get(4).adicionaExemplar("07",new ExemplarDisponivel());
		livros.get(5).adicionaExemplar("08",new ExemplarDisponivel());
		livros.get(5).adicionaExemplar("09",new ExemplarDisponivel());
	}
	
	public Livro obterLivroPorId(String idLivro){
		Livro livro = null;
		
		for(int i = 0; i < livros.size(); i++)
			if(livros.get(i).getId().equals(idLivro))
				livro = livros.get(i);
		
		return livro;
	}
	
	public Usuario obterUsuarioPorId(String idUsuario){
		Usuario usuario = null;
		
		for(int i = 0; i < usuarios.size(); i++)
			if(usuarios.get(i).getId().equals(idUsuario))
				usuario = usuarios.get(i);
		
		return usuario;
	}
	
	
	//emp
	public void realizarEmprestimo(String idUsuario, String idLivro){
		Livro livro = Facade.getInstancia().obterLivroPorId(idLivro);
		Usuario usuario = Facade.getInstancia().obterUsuarioPorId(idUsuario);
		
		usuario.requerirEmprestimo();
		
	}
	
	//dev
	public void realizarDevolucao(String idUsuario, String idLivro){
		Livro livro = Facade.getInstancia().obterLivroPorId(idLivro);
		Usuario usuario = Facade.getInstancia().obterUsuarioPorId(idUsuario);
	}
	
	//res
	public void realizarReserva(String idUsuario, String idLivro){
		Livro livro = Facade.getInstancia().obterLivroPorId(idLivro);
		Usuario usuario = Facade.getInstancia().obterUsuarioPorId(idUsuario);
		
		livro.reservarLivro(usuario);
		
	}
	
	
	//obs
	public void observarLivro(String idUsuario, String idLivro){
		Livro livro = Facade.getInstancia().obterLivroPorId(idLivro);
		Usuario usuario = Facade.getInstancia().obterUsuarioPorId(idUsuario);
		
		usuario.registrarObservadorDeLivro(livro);
	}
	
	//liv
	public void obterInformacoesLivro(String idLivro){
		Livro livro = Facade.getInstancia().obterLivroPorId(idLivro);
		
		livro.getInformacoesDosExemplares();
	}
	
	//ntf
	public void obterNotificacoes(String idUsuario){
		//TODO: modificar construtor para atender a mais tipos de usuarios
		Professor usuario = (Professor) Facade.getInstancia().obterUsuarioPorId(idUsuario);
		
		usuario.retornarNotificacoes();
	}
	
	//usu
	public void obterHistorico(String idUsuario){
		
	}
	
}
