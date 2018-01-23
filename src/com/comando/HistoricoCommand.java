package comando;

import fachada.Facade;

public class HistoricoCommand implements Command{
	//Utilização do Singleton
	private static HistoricoCommand instancia;
	
	private HistoricoCommand(){}
	
	public static HistoricoCommand getInstancia(){
		if(instancia == null)
			instancia = new HistoricoCommand();
		return instancia;
	}

	@Override
	public Object execute() {
		Facade.getInstancia().obterHistorico();
		
		return null;
	}
}
