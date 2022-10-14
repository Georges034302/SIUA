package lab13;

import java.util.Random;

/**
 *
 * @author George
 */
public class Player {
    private String name;
    private int score;
    
    public Player(int index){
        this.name = String.format("Player-%02d", index);
        this.score = (new Random()).nextInt(101);
    }
    
    public int score(){
        return this.score;
    }
    
    public void show(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " score: " + score ;
    }     
    
}
