package comando;

import fachada.Facade;

public class NotificacaoCommand implements Command{
	//Utilização do Singleton
	private static NotificacaoCommand instancia;
	
	private NotificacaoCommand(){}
	
	public static NotificacaoCommand getInstancia(){
		if(instancia == null)
			instancia = new NotificacaoCommand();
		return instancia;
	}

	@Override
	public Object execute() {
		Facade.getInstancia().obterNotificacoes();;
		
		return null;
	}
}
