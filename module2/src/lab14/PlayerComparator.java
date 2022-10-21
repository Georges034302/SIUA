package lab14;

import java.util.Comparator;

/**
 *
 * @author George
 */
public class PlayerComparator implements Comparator<Player>{
    @Override
    public int compare(Player p1, Player p2) {
        return p2.getScore() - p1.getScore();
    }   
}
