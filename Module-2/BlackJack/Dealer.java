import java.util.*;

public class Dealer{
    private Deck deck;
    private Hand hand;
    private String status;
    
    public Dealer(){
        this.deck = new Deck();
        this.hand = new Hand();
        this.status = "Playing";
    }
    
    public void take(){
        Card card = deck.topCard();
        hand.take(card);
    }
    
    public void takeTwo(){
        take();
        take();
    }
    
    public void deal(Player player){
        Card card = deck.topCard();
        player.take(card);
    }
    
    public void dealTwo(Player player){
        deal(player);
        deal(player);
    }
    
    public int score(){
        return hand.value();
    }
    
    public void setStatus(){
        if(score() < 17)
            this.status = "Playing";
        if(score() > 21)
            this.status = "Lost";
        if(score() <=21 && score() >= 17)
            this.status = "Standing";
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public boolean playing(){
        return this.status.equalsIgnoreCase("Playing");
    }
    
    private char readChoice(String prompt){
        System.out.print(prompt);
        return In.nextChar();
    }
    
    public void play(){
        if(score() < 17){
            char c = readChoice("Dealer (H)it or (S)tand ? ");
            if(c == 'H' && status.equalsIgnoreCase("Playing")){
                this.take();   
                setStatus();
            }            
        }
    }
    
    public void showHand(){
        setStatus();
        System.out.printf("%-7s has: %-10s %n","Dealer",hand);
    }
    
    @Override
    public String toString(){
        return String.format("%-7s has: %-10s is %s","Dealer",hand,status);
    }
}
