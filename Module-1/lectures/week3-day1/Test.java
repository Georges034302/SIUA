import java.util.Arrays;
import java.util.Scanner;

public class Test{
    static Scanner in = new Scanner(System.in);    
    public static void main(String[] args){
        System.out.print("Size = ");
        int size = in.nextInt();        
        int s[] = new int[size];
        
        for(int i=0; i < s.length; i++){
            System.out.print("Value = ");
            s[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(s));
        
        for(int i=0; i < s.length; i++){            
            s[i] = (int)Math.pow(s[i],2);
        }
        
        System.out.println(Arrays.toString(s));
    }
}
