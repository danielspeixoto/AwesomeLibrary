package comando;

import fachada.Facade;
import library.Dados;

public class DevolucaoCommand implements Command {
	//Utilização do Singleton
	private static DevolucaoCommand instancia;
			
	private DevolucaoCommand(){}
			
	public static DevolucaoCommand getInstancia(){
		if(instancia == null)
			instancia = new DevolucaoCommand();
		return instancia;
	}



	@Override
	public Object execute(Dados dado) {
		Facade.getInstancia().realizarDevolucao();
		
		return null;
	}

}
