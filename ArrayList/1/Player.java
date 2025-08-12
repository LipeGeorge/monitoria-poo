public class Player {
    
    private int label;
    private int pos;
    private boolean free;

    // Constructor
    public Player(int label){
        setLabel(label);
        setPos(0);
        setFree(true);
    
    }

    // Getters e Setters
    public int getLabel() {
        return label;
    }

    public int getPos() {
        return pos;
    }

    public boolean isFree() {
        return free;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Player" + getLabel();
    }

}
