package comando;

import fachada.Facade;
import library.Dados;

public class InformacaoCommand implements Command{
	//Utilização do Singleton
	private static InformacaoCommand instancia;
	
	private InformacaoCommand(){}
	
	public static InformacaoCommand getInstancia(){
		if(instancia == null)
			instancia = new InformacaoCommand();
		return instancia;
	}


	@Override
	public Object execute(Dados dado) {
		Facade.getInstancia().obterInformacoesLivro();
		
		
		return null;
	}

}
