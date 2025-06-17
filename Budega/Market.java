package Listas.Budega;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Market {
    
	// atributos obrigatórios
    private ArrayList<Person> counters;
    private List<Person> queue;
    
    // atributos auxiliares
    private Map<Integer, String> budega;
    Person client;
    
    private boolean validatedIndex(int index){

        if(index > -1 && counters.size() > index){
            return true;
            
        }

        return false;
    }

    public Market(int counterCount){
    	
        counters = new ArrayList<Person>(counterCount);
        
        for(int count = 0; count < counterCount; count++) {
        	
        	counters.add(null);
        	
        }
        queue = new ArrayList<>();

    }

    public void arrive(Person person){
        queue.add(person);
        
    }

    public boolean call(int index){

        if(queue.size() == 0) {
        	System.out.println("fail: sem clientes");
        	return false;
        
        } else if (counters.get(index) != null) {
        	System.out.println("fail: caixa ocupado");
        	return false;
        	
        } else {
        	// chamando o cliente para o caixa
        	counters.set(index, queue.get(0));
        	
        	// atualizando a lista, dando um shift em todos
        	for(int i = 0; i < queue.size() - 1; i++) {
        		
        		if(queue.size() > 1) {
        			queue.set(i, queue.get(i + 1));
        		}
        	}
        	
        	//tornando o último espaço vazio
        	queue.remove(queue.size() - 1);
        	
        	return true;
        }

    }
    
    public Person finish(int index) {
    	
    	if(validatedIndex(index) == true){
    		if(counters.get(index) != null) {
    			
    			client = counters.get(index);
    			counters.set(index, null);
    			
    			return client;
    			
    		} else {
    			
    			System.out.println("fail: caixa vazio");
    			return null;
    			
    		}
            
        }
    	
    	System.out.println("fail: caixa inexistente");
    	
    	return null;
    	
    }
    
    public boolean cutInLine(Person sneaky, String gullible) {
    	
    	for(int i = 0; i < queue.size(); i++) {
    		if(queue.get(i).getName().equals(gullible)) {
    			
    			// duplico o último elemento
    			queue.add(queue.get(queue.size()-1));
    			
    			//vou voltando a partir do novo penultimo (que é o que está repetido)
    			for(int index = queue.size() - 1; index > i; index--) {
    				
    				//fazendo com que o antepenultimo seja o penultimo e assim sucessivamente
    				queue.set(index, queue.get(index - 1));
    				
    			}
    			
    			// por fim, o index do gullible estará repetido
    			// então apenas substituo o da frente
    			queue.set(i, sneaky);
    			return true;
    			
    		}
    		
    	}
    	
    	return false;
    	
    }
    
    public boolean giveUp(String quitter) {
    	
    	for(int i = 0; i < queue.size(); i++) {
    		if(queue.get(i).getName().equals(quitter)) {
    			
    			queue.remove(i);
    			return true;
    			
    		}
    		
    	}
    	
    	return true;
    	
    }

    public String toString() {
    	
    	String naFila = "[", caixas = "[";
    	
    	if(queue.size() > 0) {
    		
    		naFila += queue.get(0).getName();
	    	for(int i = 1; i < queue.size(); i++) {	
	    		
	    		naFila = String.join(",", naFila, queue.get(i).getName());
	    		
	    	}
	    	
    	}
    	naFila += "]";
    	
    	
    	if(counters.size() > 0) {
    		
    		budega = new HashMap<Integer, String>();
        	for(int i = 0; i < counters.size(); i++) {
        		
        		if(counters.get(i) == null) {
        			budega.put(i, "-----");
        			
        		} else {
        			budega.put(i, counters.get(i).getName());
        			
        		}
        		
        	}
        	
        	
        	caixas += budega.get(0);
        	for(int i = 1; i < budega.size(); i++) {
        		
        		caixas = String.join(",", caixas, budega.get(i));
        		
        	}
        	
    		
    	}
    	caixas += "]";
    	
    	
    	return "Caixas: " + caixas
    			+ "\nEspera: " + naFila;
    	
    }
    
}










