import java.util.ArrayList;
import java.util.List;

public class Contato {
    
    private boolean favorited;
    List<Fone> fones;
    private String name;

    public Contato(String name){

        this.name = name;
        fones = new ArrayList<>();
        favorited = false;

    }

    public void addFone(String id, String fone){

        Fone f = new Fone(id, fone);

        if(f.isValid()){
            fones.add(f);
        
        } else {
            System.out.println("fail: invalid number");

        }
    
    }

    public void rmFone(int index){

        if(index > -1 && index < fones.size()){
            fones.remove(index);

        } else {
            System.out.println("fail: invalid index");

        }

    }

    public void toogleFavorited(){
        this.favorited = !this.favorited;

    }

    public boolean isFavorited(){
        return this.favorited;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){

        String msg = this.favorited ? "@ " : "- ";

        msg += name + " " + fones;

        return msg;
    }
}
