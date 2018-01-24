package comando;

import fachada.Facade;
import library.Dados;
public class EmprestimoCommand implements Command {
	//Utilização do Singleton
	private static EmprestimoCommand instancia;
	
	private EmprestimoCommand(){}
	
	public static EmprestimoCommand getInstancia(){
		if(instancia == null)
			instancia = new EmprestimoCommand();
		return instancia;
	}
	
	

	@Override
	public Object execute(Dados dado) {
		Facade.getInstancia().realizarEmprestimo(dado.getIdUsuario(),dado.getIdLivro());
		
		return null;
	}

}
