package fachada;

public class Facade {
	//utilização do Singleton
	private static Facade instancia;
	
	private Facade(){}
	
	public static Facade getInstancia() {
		
		if(instancia == null)
			instancia = new Facade();
		
		return instancia;
	}

	public void realizarEmprestimo(){
		
	}
	
	public void realizarDevolucao(){
		
	}
	
	public void realizarReserva(){
		
	}
	
	public void obterInformacoesLivro(){
		
	}
	
	public void observarLivro(){
		
	}
	
	public void obterNotificacoes(){
		
	}
	
	public void obterHistorico(){
		
	}
	
	public void sair(){
		
	}
	
}
