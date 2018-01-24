package library;

import java.util.HashMap;

import comando.*;

public class Sistema {
	private HashMap comandos;
	
	public Sistema(){
		comandos = new HashMap();
		
		this.iniciarComandos();
				
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
	
	public void servico(String comando, Dados dado){
		
		Command c = (Command) comandos.get(comando);
		
		c.execute(dado);
	}
	
}
