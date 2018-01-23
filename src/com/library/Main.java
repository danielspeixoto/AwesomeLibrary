package library;

import java.util.Scanner;
import comando.*;

public class Main {
	
	public static void main(String [] args){
		Scanner input= new Scanner(System.in);
		Sistema sistema = new Sistema();
		
		String operacao = input.nextLine();
		Dados dado = new Dados(input.nextInt(),input.nextInt());
		
		sistema.servico(input.nextLine(),dado);
		
		
	}
}
