import java.util.Scanner;

public class Counter{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Character: ");
        char c = in.nextLine().charAt(0);
        int count = 0;
        
        while(c != '*'){
            
            //if((int)c >= 65 && (int)c <= 90){
            if(Character.isUpperCase(c)){
                count++;
            }
            
            System.out.print("Character: ");
            c = in.nextLine().charAt(0);
        }
        
        System.out.println("Total count = "+count);
    }
}
