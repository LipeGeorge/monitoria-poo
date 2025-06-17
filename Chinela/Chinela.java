package modificadores_Acesso.Chinela;

public class Chinela {
	
	int tamanho;
	
	public Chinela() {
		
		this.tamanho = 0;
		
	}
	
	public void setTamanho(int tamanho) {
	
		if(tamanho > 19 && tamanho < 51) {
			
			this.tamanho = tamanho;
			
		} else {
			System.out.println("Tamanho inexistente.");
		}
			
	}
	
	public int getTamanho() {
		
		return tamanho;
		
	}

}
