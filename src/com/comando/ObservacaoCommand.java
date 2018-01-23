package comando;

import fachada.Facade;

public class ObservacaoCommand implements Command {
	//Utiliza��o do Singleton
	private static ObservacaoCommand instancia;
	
	private ObservacaoCommand(){}
	
	public static ObservacaoCommand getInstancia(){
		if(instancia == null)
			instancia = new ObservacaoCommand();
		return instancia;
	}
	
	@Override
	public Object execute() {
		Facade.getInstancia().observarLivro();
		
		return null;
	}

}
