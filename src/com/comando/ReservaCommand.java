package comando;

import fachada.Facade;

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
	public Object execute() {
		Facade.getInstancia().realizarReserva();
		
		return null;
	}

}
