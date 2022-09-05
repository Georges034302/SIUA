import java.util.*;

public class Stores{
    public static void main(String[] args){
        ArrayList<Integer> tests = new ArrayList<>(2);

        
        System.out.println(Arrays.deepToString(tests.toArray()));
        for(int i=0; i< 3; i++)
            tests.add(i);
        System.out.println(Arrays.deepToString(tests.toArray()));   
    }
}
