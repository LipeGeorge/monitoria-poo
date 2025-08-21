public class Fone {
    
    private String id;
    private String number;

    public Fone(String id, String number){

        this.id = id;
        this.number = number;

    }

    public boolean isValid(){
        
        String validos = "0123456789().";

        // For each percorrendo cada elemento do numero passado.
        for(char c: this.number.toCharArray()){

            // verificando com String.indefOf que retorna a posição da ocorrência do char
            // ou então -1 se não encontrar
            if(validos.indexOf(c) == -1){

                return false;

            }

        }

        return true;

    }

    public String getId() {
        return id;

    }

    public String getNumber() {
        return number;

    }

    @Override
    public String toString(){
        return id+":"+number;
    }

}
