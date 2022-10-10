import java.util.*;

public class Player{
    private String name;
    private Hand hand;
    private String status;

    public Player(String name){
        this.name = name;
        hand = new Hand();
        this.status = "Playing";
    }

    public void take(Card card){
        hand.take(card);
    }

    public int score(){
        return hand.value();
    }

    public void setStatus(){
        if(score() < 21)
            this.status = "Playing";
        if(score() > 21)
            this.status = "Lost";
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

    public void play(Dealer dealer){
        if(score() <= 21){
            char c = readChoice(name+" (H)it or (S)tand ? ");
            if(c == 'H' && status.equalsIgnoreCase("Playing")){
                dealer.deal(this);     
                setStatus();
            }else{
                this.status = "Standing";
            }   
        }         
    }

    public void showHand(){
        System.out.printf("%-7s has: %-10s %n",name,hand);
    }

    @Override
    public String toString(){
        return String.format("%-7s has: %-10s is %s",name,hand,status);
    }
}
