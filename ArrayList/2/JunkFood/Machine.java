import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Machine {
    
    private ArrayList<Slot> slots = new ArrayList<>();
    private float profit = 0;
    private float cash = 0;
    private int capacity;
    
    private static DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US); 
    private static DecimalFormat df = new DecimalFormat("0.00", symbols);

    public Machine(int capacity){

        this.capacity = capacity;
        for(int i = 0; i < this.capacity; i++){
            slots.add(new Slot("empty", 0, 0));

        }

    }

    public Slot getSlot(int index){
        return slots.get(index);
    }

    public float getProfit() {
        return profit;
    }

    public float getCash() {
        return cash;
    }

    public void setSlot(int index, Slot slot){

        if(slots.size() > index){
            slots.set(index, slot);

        } else {
            System.out.println("fail: indice nao existe");
        }

    }

    public void clearSlot(int index){
        
        // remove
        slots.set(index, new Slot("empty", 0, 0));

    }

    public void insertCash(float cash){
        this.cash += cash;
    }

    public float withdrawCash(){

        float troco = cash;
        if(cash > 0){

            cash = 0;
            System.out.println("voce recebeu " + df.format(troco) + " RS");

        } else {

            System.out.println("fail: Voce nao tem troco");

        }

        return troco;

    }

    public void buyItem(int index){

        if(slots.size() > index){

            var elem = slots.get(index);

            if(elem.getPrice() <= cash){

                if(elem.getQuantity() > 0){

                    slots.get(index).setQuantity(elem.getQuantity() - 1); // subtrai da maquina
                    cash -= elem.getPrice(); // subtrai do caixa
                    profit += elem.getPrice(); // lucro

                } else {
                    System.out.println("fail: espiral sem produtos");
                }

            } else {
                System.out.println("fail: saldo insuficiente");

            }

        } else {
            System.out.println("fail: indice nao existe");
        }

    }

    @Override
    public String toString(){

        String message = "saldo: " + df.format(cash) + "\n";

        int cont = 0;
        for(; cont < slots.size() - 1; cont++){

            message += cont + " " + slots.get(cont).toString() + "\n";

        }

        message += cont + " " + slots.get(cont).toString();

        return message;

    }

}
