import java.util.ArrayList;

public class Tabuleiro {
    
    private ArrayList<Integer> trapList = new ArrayList<>();
    private ArrayList<Player> players;
    private boolean running = true;
    private int boardSize;

    public Tabuleiro(int nPlayers, int boardSize){

        players = new ArrayList<>(nPlayers);

        Player player;
        for(int label = 1; label < nPlayers + 1; label++){

            player = new Player(label);
            players.add(player);

        }

        this.boardSize = boardSize;

    }

    public void addTrap(int pos){
        trapList.add(pos);

    }

    public void rollDice(int value){
        
        if(running){

            var jog = players.get(0);

            if(jog.isFree()){
                
                if(jog.getPos() + value > 11){
                    jog.setPos(11);

                } else jog.setPos(jog.getPos() + value);

                System.out.println(jog.toString() + " andou para a " + jog.getPos());

                for(int trap: trapList) {
                    if(jog.getPos() == trap) {

                        jog.setFree(false);
                        System.out.println(jog.toString() + " caiu em uma armadilha");
                    
                    }
                }

            } else {

                if(value % 2 == 0) {

                    jog.setFree(true);
                    System.out.println(jog.toString() + " se libertou");
                
                } else System.out.println(jog.toString() + " continua preso");
            
            }

            
            if(jog.getPos() > boardSize){

                running = false;
                System.out.println(jog.toString() + " ganhou");

                int posicao = 0;
                int posF = 0;
                for(Player ord: players){

                    for(posF = posicao; posF < players.size(); posF++){
                        if(players.get(posF).getLabel() == posicao){

                            break;

                        }
                    }

                    if(ord.getLabel() != posicao){
                        
                        Player aux;
                        for(int i = posicao; i < posF - 1; i++){

                            aux = players.get(i);
                            players.set(i, players.get(i + 1));
                            players.set(i + 1, aux);

                        }

                    }

                    posicao++;

                }

            
            } else {

                Player aux;
                for(int i = 0; i < players.size() - 1; i++){

                    aux = players.get(i);
                    players.set(i, players.get(i + 1));
                    players.set(i + 1, aux);

                }

            }


        } else {
            System.out.println("game is over");
        
        }
        

    }

    @Override
    public String toString(){

        String tabuleiro = "";
        int pos;

        for(Player p : players){

            tabuleiro += p.toString() + ":";

            pos = p.getPos();
            for(int c = 0; c < boardSize + 2; c++){

                if(c == pos) tabuleiro += " " + p.getLabel();
                else tabuleiro += " .";

            }
            tabuleiro += "\n";

        }

        tabuleiro += "traps__: .";

        int p = 0;
        for(int t = 0; t < trapList.size(); t++){

            pos = trapList.get(t);
            for(; p < pos + 1; p++){

                if(p == pos - 1) tabuleiro += " x";
                else tabuleiro += " .";

            }


        }
        if(p < 12){
            for(; p < 11; p++){
                
                tabuleiro += " .";
            
            }
        }

        return tabuleiro;

    }

}