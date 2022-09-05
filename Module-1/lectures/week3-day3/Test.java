
import java.util.Scanner;

public class Test{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Next Char: ");
        char next = in.nextLine().charAt(0);
        
        int sum =0;
        while(next != '.'){
            sum+= (int)next;
            
            System.out.print("Next Char: ");
            next = in.nextLine().charAt(0);
        }
        
        System.out.println("Sum char = "+sum);
    }
}
