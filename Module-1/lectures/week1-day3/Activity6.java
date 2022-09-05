import java.util.Scanner;

public class Activity6{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("String: ");
        String s = in.nextLine();
        
        if(s.isEmpty())
            System.out.println("s is empty");
        else
            System.out.println(s.length());
    }   
}
   

