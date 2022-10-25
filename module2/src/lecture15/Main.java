package lecture15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class Main {
    public static final String RED_UNDERLINED = "\033[4;31m";
    public static final String WHITE = "\033[0;37m"; 
     
    public static void main(String[] args) {
       
        try {
            StadiumController manager = new StadiumController();
            manager.book();
        } catch (NotEnoughSeatsException ex) {
            System.out.println(RED_UNDERLINED+ex.getMessage()+WHITE);
        }         
        
    }
}
