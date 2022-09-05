
/**
 * Populate an array of 5 integers randomly with seed 10
 * Then show the factorial of elements
 */
import java.util.Random;

public class Factorial{
    
    public static void main(String [] args){
        Random r = new Random();        
        int x[] = new int[5];
        
        for(int i=0 ; i < x.length; i++)
            x[i] = r.nextInt(10); //key
        
        for(int j=0 ; j < x.length; j++) {   
            int f = 1;
            for(int i =1; i <= x[j]; i++)    
                f *= i; //key
            System.out.println("x["+j+"] = "+f);
        }
    }    
}
