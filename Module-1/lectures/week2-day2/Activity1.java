import java.util.Scanner;

public class Activity1{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[]args){
        System.out.print("Next Char: ");
        char next = in.nextLine().charAt(0);        
        
        while(!Character.isDigit(next)){            
            System.out.print("Next Char: ");
            next = in.nextLine().charAt(0);
        }     
        System.out.println("Next digit is "+next);
        System.out.println(Math.sqrt(Integer.parseInt(""+next)));
    }
}
