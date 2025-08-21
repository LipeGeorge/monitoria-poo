import java.util.Scanner;

public class Shell {

    public static void main(String[] args) {
        
        Machine machine = new Machine(0);

        while(true){

            var line = scanner.nextLine();
			System.out.println("$" + line);

			var par = line.split(" ");
			var cmd = par[0];

            if (cmd.equals("end")) {
				break;
			} else if (cmd.equals("init")) {
				
				var capacity = Integer.parseInt(par[1]);
				machine = new Machine(capacity);
				
			} else if (cmd.equals("show")) {
				
				System.out.println(machine.toString());
				
			} else if (cmd.equals("set")) {
				
				var index = Integer.parseInt(par[1]);
                var name = par[2];
                var capacity = Integer.parseInt(par[3]);
                var price = Float.parseFloat(par[4]);
                
                machine.setSlot(index, new Slot(name, price, capacity));
				
			} else if (cmd.equals("limpar")) {
				
				var index = Integer.parseInt(par[1]);				
                machine.clearSlot(index);
				
			} else if (cmd.equals("dinheiro")) {
				
				var cash = Float.parseFloat(par[1]);
                machine.insertCash(cash);
				
			} else if (cmd.equals("troco")) {
				
				machine.withdrawCash();
				
			} else if (cmd.equals("comprar")) {
				
				var index = Integer.parseInt(par[1]);
				machine.buyItem(index);
				
			} else {
				System.out.println("fail: comando invalido");

			}

        }

    }

    static Scanner scanner = new Scanner(System.in);
    
}