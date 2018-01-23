package comando;

import fachada.Facade;
public class EmprestimoCommand implements Command {
	//Utiliza��o do Singleton
	private static EmprestimoCommand instancia;
	
	private EmprestimoCommand(){}
	
	public static EmprestimoCommand getInstancia(){
		if(instancia == null)
			instancia = new EmprestimoCommand();
		return instancia;
	}
	
	

	@Override
	public Object execute() {
		Facade.getInstancia().realizarEmprestimo();
		
		return null;
	}

}
