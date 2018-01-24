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
	
	//emp
	public void realizarEmprestimo(String idUsuario, String idLivro){
		
	}
	
	//dev
	public void realizarDevolucao(String idUsuario, String idLivro){
		
	}
	
	//res
	public void realizarReserva(String idUsuario, String idLivro){
		
	}
	
	
	//obs
	public void observarLivro(String idUsuario, String idLivro){
		
	}
	
	//liv
	public void obterInformacoesLivro(String idLivro){
		
	}
	
	//ntf
	public void obterNotificacoes(String idUsuario){
		
	}
	
	//usu
	public void obterHistorico(String idUsuario){
		
	}
	
}
