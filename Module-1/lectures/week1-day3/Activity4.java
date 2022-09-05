import java.util.Scanner;

public class Activity4{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("String 1: ");
        String s1 = in.nextLine();
        System.out.print("String 2: ");
        String s2 = in.nextLine();
        
        if(s1.length() == s2.length()){
            System.out.println("equal length");
        }else if (s1.length() > s2.length()){
            System.out.println(s1.length());
        }else{
            System.out.println(s2.length());
        }
    }
}
