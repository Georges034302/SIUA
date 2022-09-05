import java.util.Scanner;

public class Activity2{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        int javaCount = 0;
          
        System.out.print("Next Word or STOP: ");
        String word = in.nextLine();
        
        while(!word.equalsIgnoreCase("STOP")){          
            
            if(word.equalsIgnoreCase("Java"))
                javaCount++;    
                
            System.out.print("Next Word or STOP: ");
            word = in.nextLine();
        }
        System.out.println("Java count = "+javaCount);
    }
}
