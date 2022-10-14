package lab13;

import java.util.Comparator;

/**
 *
 * @author George
 */
public class PlayerComparator implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        return o2.score() - o1.score();
    }    
}
