import java.util.Random;

public class Randomizer{
    static Random r = new Random();
    
    public static int randomInt(int size){
        return r.nextInt(size);
    }
}
