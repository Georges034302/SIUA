import java.util.*;

public class Hand{
    private List<Card> cards = new ArrayList();
    
    public void take(Card card){
        this.cards.add(card);
    }
    
    public int value(){
        int sum = 0;
        for(Card card: cards)
            sum += (card.value()) > 10 ? 10 : card.value();
        return sum;
    }
    
    @Override
    public String toString(){
        return this.cards.toString();
    }
}
