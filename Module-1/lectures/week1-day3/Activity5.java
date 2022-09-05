import java.util.Scanner;

public class Activity5{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Character: ");
        char c = in.nextLine().charAt(0);       
            
        if((int)c >= 65 && (int)c <=90){
            int lower = (int)c + 32;
            System.out.println((char)lower);
        }else
            System.out.println(c+" is lowercase");
    }   
}
