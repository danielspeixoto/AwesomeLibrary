package library;

import java.util.ArrayList;
import java.util.HashMap;

import book.*;
import comando.*;
import fachada.Facade;
import user.*;

public class Sistema {
	private HashMap comandos;
	
	public Sistema(){
		comandos = new HashMap();
		
		//inicializa livros e usuarios
		Facade.getInstancia().registrarUsuarios();
		Facade.getInstancia().registrarLivros();
		Facade.getInstancia().registrarExemplares();
		
		//inicializa hashmap
		iniciarComandos();
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
		
		//Obter Informa��es do livro
		comandos.put("liv", InformacaoCommand.getInstancia());
		
		//Obter quantidade de notifica��es
		comandos.put("ntf", NotificacaoCommand.getInstancia());
		
		//Obter historico do usu�rio
		comandos.put("usu", HistoricoCommand.getInstancia());
		
		//Sair
		//comandos.put("sai", SaidaCommand.getInstancia());
	}
	

	
	public void servico(String comando, Dados dado){
		
		Command c = (Command) comandos.get(comando);
		c.execute(dado);
	}
	
}
