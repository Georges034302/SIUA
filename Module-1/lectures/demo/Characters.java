import java.util.*;

public class Characters{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Char: ");
        char x = input.nextLine().charAt(0);
        int y = 32;
        char result = (char)(x - y);
        System.out.println(result);    
        System.out.println((int)result);
        y += (int) result;
        System.out.println(y);
    }
}
