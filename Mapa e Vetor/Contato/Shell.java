import java.util.Scanner;

public class Shell{

    public static void main(String[] Args) {
        // DEL!
        Contato contact = new Contato("");
        // ADD!
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] args = line.split(" ");
            
            if (args[0].equals("end")) {
                break;
            }
            else if (args[0].equals("init")) {
                // COM!
                var name = args[1];
                // DEL!
                contact = new Contato(name);
            }
            else if (args[0].equals("show")) {
                // DEL!
                System.out.println(contact.toString());
            }
            else if (args[0].equals("add")) {
                // COM!
                var id = args[1];
                var number = args[2];
                // DEL!
                contact.addFone(id, number);
            }
            else if (args[0].equals("rm")) {
                // COM!
                var index = Integer.parseInt(args[1]);
                // DEL!
                contact.rmFone(index);
            }
            else if (args[0].equals("tfav")) {
                // DEL!
                contact.toogleFavorited();
            }
            else {
                System.out.println("fail: invalid command");
            }
        }
    }
    static Scanner scanner = new Scanner(System.in);
}