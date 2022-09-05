import java.util.Scanner;

public class MeasureString{
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("String: ");
        String s = keyboard.nextLine();
        
        while(s.charAt(0) != '*'){
            System.out.println("Length of s = "+s.length());
            System.out.print("String: ");
            s = keyboard.nextLine();
        }
    }
}
