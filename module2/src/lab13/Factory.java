package lab13;

/**
 *
 * @author George
 */
public class Factory {
    interface PlayerFactory{
        Player create(int index);
    }
    
    public static Player player(int index){
        PlayerFactory factory = Player::new ;
        return factory.create(index);
    }
}
