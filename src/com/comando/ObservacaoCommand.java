package comando;

import fachada.Facade;
import library.Dados;

public class ObservacaoCommand implements Command {
	//Utilização do Singleton
	private static ObservacaoCommand instancia;
	
	private ObservacaoCommand(){}
	
	public static ObservacaoCommand getInstancia(){
		if(instancia == null)
			instancia = new ObservacaoCommand();
		return instancia;
	}
	

	@Override
	public Object execute(Dados dado) {
		Facade.getInstancia().observarLivro(dado.getIdUsuario(),dado.getIdLivro());
		
		return null;
	}

}
