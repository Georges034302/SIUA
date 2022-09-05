import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class LinearSearch{
    static Scanner in = new Scanner(System.in);    
    public static void main(String[] args){
        System.out.print("Size = ");
        int size = in.nextInt();        
        int x[] = new int[size];
        
        Random r = new Random();
        for(int i=0; i < x.length; i++){            
            x[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(x));
        
        System.out.print("Target = ");
        int e = in.nextInt();
        int pos = 0;
        boolean found = false;
        
        for(int i=0; i< x.length; i++){
            if(x[i] == e){
                pos = i;
                found = true;
                break;
            }
        }
        
        if(found) 
            System.out.println(e+" is found at position "+pos);
        else
            System.out.println(e+" does not exist!!!");
    }
}
