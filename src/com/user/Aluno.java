package user;

public class Aluno extends Usuario {
	private final int tempoDeEmprestimo = 5;
	
	public Aluno(String id, String nome) {
		super(id, nome);
	}
	
}
