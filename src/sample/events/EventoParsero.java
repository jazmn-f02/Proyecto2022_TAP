package sample.events;

public class EventoParsero {

    public String[] morse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."," ","\n","-----",".----","..---",
            "...--","....-",".....","-....","--...","---..","----.",".-.-.-","--..--","..--..",".----.","-.-.--",
            "-..-.","-.--.","-.--.-",".-...","---...","-.-.-.","-...-",".-.-.","-....-","..--.-",".-..-.","...-..-",
            ".--.-.","..-.-","--...-"};
    public String[] abc={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W",
            "X","Y","Z"," ","\n","0","1","2","3","4","5","6","7","8","9",".",",","?","'","!","/","(",")","&",":",";",
            "=","+","-","_","\"","$","@","¿","¡"};

public String traductor(String data) {

        String trad = "";
        String mayus = "";
        String let = "";
        mayus = data.toUpperCase();
        for (int i = 1; i < data.length(); i++) {
            let = mayus.substring(i -1, i);
            for (int j = 0; j < abc.length; j++) {
                if (let.equals(abc[j])) {
                    trad = trad + morse[j] + " ";
                }
            }
        }

        return trad;
    }
}