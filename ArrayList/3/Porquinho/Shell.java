import java.util.ArrayList;
import java.util.Scanner;

public class Shell {

    public static void main(String[] _args) {

        Pig pig = new Pig(0);
        ArrayList<Coin> coins;
        ArrayList<Item> itens;

        while (true) {

            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                
                int maxVolume = Integer.parseInt(par[1]);
                pig = new Pig(maxVolume);

            }
            else if (cmd.equals("show")) {
                System.out.println(pig.toString());
            
            }
            else if (cmd.equals("addCoin")) {
                
                var coin = par[1];
                
                if(coin.equals("10")){
                    pig.addCoin(Coin.C10);

                } else if (coin.equals("25")) {
                    pig.addCoin(Coin.C25);

                } else if (coin.equals("50")) {
                    pig.addCoin(Coin.C50);

                } else if (coin.equals("100")){
                    pig.addCoin(Coin.C100);

                }

            }
            else if (cmd.equals("addItem")) {
                var item = par[1];
                var volume = Integer.parseInt(par[2]);

                pig.addItem(new Item(item, volume));

            }
            else if (cmd.equals("break")) {
                pig.breakPig();
            
            }
            else if (cmd.equals("extractCoins")) {
                // Obtenha as moedas usando o método extractCoins
                coins = pig.extractCoins();

                // Imprima as moedas obtidas
                System.out.println(coins);

            }
            else if (cmd.equals("extractItems")) {
                // Obtenha os itens usando o método extractItems
                itens = pig.extractItens();

                // Imprima os itens obtidos
                System.out.println(itens);

            }
            else {
                System.out.println("fail: invalid command");
            }
        }
    }

    public static Scanner scanner = new Scanner(System.in);
}