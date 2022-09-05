import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Reals{
    public static void main(String[] args){
        ArrayList<Integer> reals = new ArrayList(5);
        Random r = new Random(10);

        for(int i= 0; i < 10; i ++)
            reals.add(r.nextInt(10));
            
        System.out.printf(Arrays.deepToString(reals.toArray()));
        
        ArrayList<Integer> evens = new ArrayList<>();
        
        for(int i=0 ; i < reals.size(); i++)
            if(reals.get(i) %2 == 0)
                evens.add(reals.get(i));
       System.out.printf("%n"+Arrays.deepToString(evens.toArray()));
    }
}
