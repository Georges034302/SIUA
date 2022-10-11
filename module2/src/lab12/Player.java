package lab12;
import java.util.*;

public class Player{
    private String name;
    private int score;
    
    public Player(int index){
        this.name = "Player_"+index;
        this.score = (new Random()).nextInt(101);
    }
    
    public int score(){
        return this.score;
    }
    
    public boolean match(Player p){
        return p.score < this.score;
    }
    
    public boolean equal(Player p){
        return p.score == this.score;
    }
    
    @Override
    public String toString(){
        return this.name+" score: "+this.score;
    }
}
