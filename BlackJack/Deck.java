import java.util.*;

public class Deck{
    public Card topCard(){
        Random r = new Random();
        int number = r.nextInt(13)+1;
        
        String suit="";
        
        switch(r.nextInt(3)){
            case 0: suit = "\u2665";break;
            case 1: suit = "\u2666";break;
            case 2: suit = "\u2663";break;
            default: suit = "\u2660";break;
        }
        
        return new Card(number,suit);
    }
}
