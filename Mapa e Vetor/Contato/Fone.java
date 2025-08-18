public class Fone {
    
    private String id;
    private String number;

    public Fone(String id, String number){

        this.id = id;
        this.number = number;

    }

    public boolean isValid(){
        
        String validos = "0123456789().";

        for(int ch = 0; ch < number.length(); ch++){

            // Verifica se "validos" contém os caracteres que estão em number.
            if(!validos.contains(
                        String.valueOf(
                            number.charAt(ch)
                        )
                    )
                )
            {
                
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
        return "";
    }

}
