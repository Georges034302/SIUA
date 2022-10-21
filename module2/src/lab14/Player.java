package lab14;

import java.util.Random;

/**
 *
 * @author George
 */
public class Player {
    private int score;
    private String name;
    
    public Player(int index){
        this.score = (new Random()).nextInt(11);
        this.name = "Player-"+(index+1);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-8s --> %02d", name,score);
    }    
    
}
