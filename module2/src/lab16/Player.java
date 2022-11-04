package lab16;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author George
 */
public class Player implements Serializable{
    private String name;
    private int score;
    
    public Player(int index){
        this.name = String.format("Player-%02d", index);
        this.score = (new Random()).nextInt(101);
    }

    @Override
    public String toString() {
        return name + " score: " + score ;
    }    
}
