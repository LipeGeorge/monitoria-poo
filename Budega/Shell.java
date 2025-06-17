package Listas.Budega;

import java.util.*;

public class Shell {
	public static void main(String[] _args) {
		
		Market mercado = new Market(0);
		Person pessoa;

		while (true) {
			var line = scanner.nextLine();
			System.out.println("$" + line);

			var par = line.split(" ");
			var cmd = par[0];

			if (cmd.equals("end")) {
				break;
			} else if (cmd.equals("init")) {
				
				var qtd_caixas = Integer.parseInt(par[1]);
				mercado = new Market(qtd_caixas);
				
			} else if (cmd.equals("show")) {
				
				System.out.println(mercado.toString());
				
			} else if (cmd.equals("arrive")) {
				
				var nome = par[1];
				pessoa = new Person(nome);
				
				mercado.arrive(pessoa);
				
			} else if (cmd.equals("call")) {
				
				var indice = Integer.parseInt(par[1]);
				mercado.call(indice);
				
			} else if (cmd.equals("finish")) {
				
				var indice = Integer.parseInt(par[1]);
				mercado.finish(indice);
				
			} else if (cmd.equals("cut")) {
				
				Person sneaky = new Person(par[1]);
				var gullible = par[2];
				
				mercado.cutInLine(sneaky, gullible);
				
			} else if (cmd.equals("quit")) {
				
				var quitter = par[1];
				
				mercado.giveUp(quitter);
				
			} else {
				System.out.println("fail: comando invalido");

			}
		}
	}

	static Scanner scanner = new Scanner(System.in);
}