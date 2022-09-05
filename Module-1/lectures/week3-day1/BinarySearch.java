import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class BinarySearch{
    static Scanner in = new Scanner(System.in);    
    public static void main(String[] args){
        System.out.print("Size = ");
        int size = in.nextInt();        
        int x[] = new int[size];        
        
        for(int i=0; i < x.length; i++){            
            x[i] = i*2;
        }
        System.out.println(Arrays.toString(x));
        
        System.out.print("Target = ");
        int e = in.nextInt();
        int pos = -1;
        int first = 0;
        int last = x.length;
        boolean found = false;
        
        while(first <= last){
            pos = (first+last)/2;
            if(x[pos] == e){
                found = true;
                break;
            }else if(x[pos] > e){
                last = pos - 1;
            }else{ //x[pos] < e
                first = pos + 1;
            }
        }
        
        if(found) 
            System.out.println(e+" is found at position "+pos);
        else
            System.out.println(e+" does not exist!!!");
    }
}
