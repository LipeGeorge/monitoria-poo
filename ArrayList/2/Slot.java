public class Slot {

    private String name = "empty";
    private int qtt = 0;
    private float price = 0;

    public Slot(String name, int qtt, float price){

        this.name = name;
        this.qtt = qtt;
        this.price = price;

    }
    
    public String getName() {
        return name;
    }
    public int getQtt() {
        return qtt;
    }
    public float getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQtt(int qtt) {
        this.qtt = qtt;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "[ " + getName() + " : " + getQtt() + " U : " + getPrice() + " RS ]";
    }
    
}
