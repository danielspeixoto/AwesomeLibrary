package comando;

import fachada.Facade;
import library.Dados;

public class SaidaCommand implements Command {
	//Utilização do Singleton
	private static SaidaCommand instancia;
			
	private SaidaCommand(){}
			
	public static SaidaCommand getInstancia(){
		if(instancia == null)
			instancia = new SaidaCommand();
		return instancia;
	}


	@Override
	public Object execute(Dados dado) {
		Facade.getInstancia().sair();
		
		return null;
	}

}
