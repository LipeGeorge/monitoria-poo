import java.util.ArrayList;

public class Machine {
    
    private ArrayList<Slot> slots;
    private float profit;
    private float cash;
    private int capacity;

    public Machine(int capacity){

        for(int i = 0; i < capacity; i++){
            this.slots.add(new Slot("empty", 0, 0f));

        }

    }

    public float getProfit(){
        return 0f;
    }

    public ArrayList<Slot> getSlots() {
        return slots;

    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;

    }

    public void clearSlot(int index){
        slots.set(
            index, new Slot("empity", 0, 0f)
        );

    }

    public void insertCash(float cash){

        this.cash += cash;

    }


    public float withdrawCash(){

        // troco
        return 0f;

    }

    // Falta implementar os outros métodos e fazer todos os tratamentos de erros.



}
