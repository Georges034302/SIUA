package lab13;

import java.util.Random;

/**
 *
 * @author George
 */
public class User {
    private int ID;
    
    public User(){
        this.ID = (new Random()).nextInt(100);
    }

    public int getID() {
        return ID;
    }    
    
    public boolean match(int ID){
        return this.ID == ID;
    }

    @Override
    public String toString() {
        return String.format("User--%02d", ID);
    }    
}
