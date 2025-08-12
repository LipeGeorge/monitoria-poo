import java.util.Scanner;

public class Shell {

    public static void main(String[] args) {
        
        Tabuleiro tabuleiro = new Tabuleiro(0, 0);

        while(true){

            var line = scanner.nextLine();
			System.out.println("$" + line);

			var par = line.split(" ");
			var cmd = par[0];

            if (cmd.equals("end")) {
				break;
			} else if (cmd.equals("init")) {
				
				var qtd_players = Integer.parseInt(par[1]);
                var sizeBoard = Integer.parseInt(par[2]);

				tabuleiro = new Tabuleiro(qtd_players, sizeBoard);
				
			} else if (cmd.equals("show")) {
				
				System.out.println(tabuleiro.toString());
				
			} else if (cmd.equals("addTrap")) {
				
				var pos_trap = Integer.parseInt(par[1]);
                tabuleiro.addTrap(pos_trap);
				
			} else if (cmd.equals("roll")) {
				
				var qtd_casas = Integer.parseInt(par[1]);
				tabuleiro.rollDice(qtd_casas);
				
			} else {
				System.out.println("fail: comando invalido");

			}

        }

    }

    static Scanner scanner = new Scanner(System.in);
    
}
