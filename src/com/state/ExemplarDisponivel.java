package state;

import book.Exemplar;
import book.Livro;
import user.Usuario;

public class ExemplarDisponivel implements EstadoExemplar {

	@Override
	public void emprestarExemplar(Usuario usuario, Livro livro, Exemplar ex) {
		System.out.println("O exemplar " + livro.getTitulo() + " Foi emprestado para " + usuario.getNome() + " Com sucesso");
		ex.setEstadoAtual(new ExemplarIndisponivel());
	}

	@Override
	public void devolverExemplar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reservarExemplar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStatus() {
		return "Disponível";
	}

}
