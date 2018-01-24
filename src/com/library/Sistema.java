package library;

import java.util.ArrayList;
import java.util.HashMap;

import book.*;
import comando.*;
import user.*;

public class Sistema {
	private HashMap comandos;
	private ArrayList usuarios;
	
	public Sistema(){
		comandos = new HashMap();
		usuarios = new ArrayList();
		
		this.iniciarComandos();
		this.registraUsuarios();
				
	}
	
	private void iniciarComandos(){
		//Emprestar livro
		comandos.put("emp", EmprestimoCommand.getInstancia());
		
		//Devolver livro
		comandos.put("dev", DevolucaoCommand.getInstancia());
		
		//Reservar livro
		comandos.put("res", ReservaCommand.getInstancia());
		
		//Observar livro
		comandos.put("obs", ObservacaoCommand.getInstancia());
		
		//Obter Informações do livro
		comandos.put("liv", InformacaoCommand.getInstancia());
		
		//Obter quantidade de notificações
		comandos.put("ntf", NotificacaoCommand.getInstancia());
		
		//Obter historico do usuário
		comandos.put("usu", HistoricoCommand.getInstancia());
		
		//Sair
		//comandos.put("sai", SaidaCommand.getInstancia());
	}
	
	private void registraUsuarios(){
		//TODO retirar dependencia de Usuario com Sistema
		usuarios.add(new Funcionario("123","João da Silva"));
		usuarios.add(new Aluno("456","Luiz Fernando Rodrigues"));
		usuarios.add(new Funcionario("789","Pedro Paulo"));
		usuarios.add(new Professor("100","Carlos Lucena"));
	}
	
	private void registraExemplares(){
		new Exemplar("100","Engenharia de Software","AddisonWesley","Ian Sommervile","6a","2000","01");
		new Exemplar("100","Engenharia de Software","AddisonWesley","Ian Sommervile","6a","2000","02");
		
		new Exemplar("101","UML – Guia do Usuário","Campus","Grady Booch,James Rumbaugh,Ivar Jacobson","7a","2000","03");
		
		new Exemplar("200","Code Complete","Microsoft Press","Steve McConnell","2a","2014","04");
		
		new Exemplar("201","Agile SoftwareDevelopment,Principles,Patterns,and Practices","Prentice Hall","Robert Martin","1a","2002","05");
		
		new Exemplar("300","Refactoring:Improving the Design of Existing Code","Addison-Wesley Professional","Martin Fowler","1a","1999","06");
		new Exemplar("300","Refactoring:Improving the Design of Existing Code","Addison-Wesley Professional","Martin Fowler","1a","1999","07");
		
		//livro com exemplar nao disponivel
		new Livro("301","Software Metrics: A Rigorous and Practical Approach","CRC Press","Norman Fenton, James Bieman","3a","2014");
		
		new Exemplar("400","UML Distilled: A Brief Guide to the Standard Object Modeling Language","Addison-Wesley Professional","Martin Fowler","3a","2003","08");
		new Exemplar("400","Engenharia de Software","AddisonWesley","Ian Sommervile","6a","2000","09");
	}
	
	public void servico(String comando, Dados dado){
		
		Command c = (Command) comandos.get(comando);
		
		c.execute(dado);
	}
	
}
