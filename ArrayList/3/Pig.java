import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pig {
    
    private boolean broken = false;
    ArrayList<Coin> coins = new ArrayList<>();
    ArrayList<Item> itens = new ArrayList<>();
    private int volumeMax;

    public Pig(int volumeMax) { 
        
        this.volumeMax = volumeMax;
    
    }

    public boolean addCoin(Coin coin){

        if(broken){

            System.out.println("fail: the pig is broken");
            return false;
        
        } else {

            if((getVolume() + coin.getVolume()) <= volumeMax){

                coins.add(coin);
                return true;
            
            } else {

                System.out.println("fail: the pig is full");
                return false;
            
            }

        }

    }


    public boolean addItem(Item item){

        if(broken){

            System.out.println("fail: the pig is broken");
            return false;
        
        } else {

            if((getVolume() + item.getVolume()) <= volumeMax){

                itens.add(item);
                return true;
            
            } else {

                System.out.println("fail: the pig is full");
                return false;
            
            }

        }

    }

    public int getVolume(){

        int volume = 0;
        if(!broken){

            for(Item i: itens){
                volume += i.getVolume();

            }

            for(Coin c: coins){
                volume +=c.getVolume();

            }

        }

        return volume;

    }

    public double getValue(){

        double value = 0;
        for(Coin c: coins){

            value += c.getValue();

        }

        return value;

    }


    public boolean breakPig(){

        if(!broken){
            broken = true;

        } else {
            System.out.println("fail: the pig is already broken");

        }

        return broken;
    }

    public ArrayList<Coin> extractCoins(){

        ArrayList<Coin> totalCoins = new ArrayList<>();
        if(broken){

            for(Coin c: coins){
                totalCoins.add(c); // adiciona o elemento no array de retorno

            }

            coins.clear(); // remove os elementos do cofre

        } else {
            System.out.println("fail: you must break the pig first");

        }

        return totalCoins;

    }

    public ArrayList<Item> extractItens(){

        ArrayList<Item> totalItens = new ArrayList<>();
        if(broken){

            for(Item i: itens){
                totalItens.add(i); // adiciona o elemento no array de retorno

            }

            itens.clear(); // remove os elementos do cofre

        } else {
            System.out.println("fail: you must break the pig first");

        }

        return totalItens;

    }


    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("0.00");
        String estado;

        if(broken){
            estado = "broken";
        
        } else {
            estado = "intact";

        }

        return "state=" + estado + " : coins=" + coins.toString() + 
                " : items=" + itens.toString() + " : value=" 
                + df.format(getValue()) + " : volume=" + getVolume() + "/" + volumeMax;
    }

}
