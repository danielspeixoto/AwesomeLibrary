package comando;

import fachada.Facade;
import library.Dados;

public class ReservaCommand implements Command {
	//Utilização do Singleton
	private static ReservaCommand instancia;
		
	private ReservaCommand(){}
		
	public static ReservaCommand getInstancia(){
		if(instancia == null)
			instancia = new ReservaCommand();
		return instancia;
	}


	@Override
	public Object execute(Dados dado) {
		Facade.getInstancia().realizarReserva();
		
		return null;
	}

}
