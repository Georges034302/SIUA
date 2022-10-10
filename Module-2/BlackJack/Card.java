
public class Card{
    private int number;
    private String suit;
    
    public Card(int number, String suit){
        this.number = number;
        this.suit = suit;
    }
    
    public int value(){
        return this.number;
    }
    
    private String face(){
        switch(number){
            case 1: return "ACE";
            case 2: return "TWO";
            case 3: return "THREE";
            case 4: return "FOUR";
            case 5: return "FIVE";
            case 6: return "SIX";
            case 7: return "SEVEN";
            case 8: return "EIGHT";
            case 9: return "NINE";
            case 10: return "TEN";
            case 11: return "JACK";
            case 12: return "QUEEN";
            case 13: return "KING";
        }
        return "";
    }
    
    @Override
    public String toString(){
        return face()+""+suit;
    }
}
