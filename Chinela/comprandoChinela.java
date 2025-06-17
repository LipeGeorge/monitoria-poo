package modificadores_Acesso.Chinela;

import java.util.Scanner;

public class comprandoChinela {
	
	public static void main(String[] args) {
	
		Chinela chinela = new Chinela();
		Scanner input = new Scanner(System.in);
		
		int tamanho;
		while(chinela.getTamanho() == 0) {
			
			System.out.print("Digite o tamanho da chinela que você quer comprar: ");
			tamanho = input.nextInt();
			chinela.setTamanho(tamanho);
			
		}
		
		System.out.println("Parabéns! Você comprou uma chinela no tamanho " + chinela.getTamanho());
		input.close();
		
	}
	
}
