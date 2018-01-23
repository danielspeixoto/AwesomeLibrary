package comando;

import fachada.Facade;

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
	public Object execute() {
		Facade.getInstancia().realizarDevolucao();
		
		return null;
	}

}
