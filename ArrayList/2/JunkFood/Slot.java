import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Slot {
    
    private String name;
    private float price;
    private int quantity;

    public Slot(String name, float price, int quantity){
        
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public String getName(){
        return name;
        
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name){
        this.name = name;

    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US); 
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        String message = String.format("[%8s : " + quantity + " U : " + df.format(price) + " RS]", name); 

        return message;

    }

    

}
