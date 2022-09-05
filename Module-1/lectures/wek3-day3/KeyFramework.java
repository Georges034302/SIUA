import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class KeyFramework{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Size = ");
        int size = in.nextInt();
        int x[] = new int[size];
        
        Random r = new Random();
        for(int i=0 ; i < x.length ; i++)
            x[i] = r.nextInt(8);
        
        int sum = 0;
        for(int i=0 ; i < x.length ; i++)
            if( x[i] %2 == 0) 
                sum += x[i];
           
        System.out.println(Arrays.toString(x));
        System.out.println("Even-Sum = "+sum);
    }
}
