package library;

import java.util.Scanner;
import java.util.StringTokenizer;

import comando.*;

public class Main {
	
	public static void main(String [] args){
		Scanner input= new Scanner(System.in);
		Sistema sistema = new Sistema();
		Dados dado = new Dados();
		String operacao = new String();
		boolean logado = true;
		
		while(logado){
		
			StringTokenizer leitura = new StringTokenizer(input.nextLine());
			
			
			switch(leitura.countTokens()){
			case 3:
				operacao = leitura.nextToken();
				dado.setIdUsuario(leitura.nextToken());
				dado.setIdLivro(leitura.nextToken());
				break;
				
			case 2:
				operacao = leitura.nextToken();
				
				if(operacao.equals("liv"))
					dado.setIdLivro(leitura.nextToken());
				else
					dado.setIdUsuario(leitura.nextToken()); //pode ser ID do livro ou ID do usuario
				break;
			
			default:
				logado = false;
				break;
			
			}
			
			if(logado)
				sistema.servico(operacao, dado);
				
		}
		
	
	}
}
