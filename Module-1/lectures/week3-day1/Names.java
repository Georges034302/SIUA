
import java.util.Scanner;

public class Names{
    static Scanner in = new Scanner(System.in);    
    public static void main(String[] args){
       
        String names[] = new String[4];
        
        for(int i=0; i < names.length; ++i){
            System.out.print("Name = ");
            names[i] = in.nextLine();
        }       

        for(int i=0; i < names.length; ++i){
            System.out.println(names[i]);            
        }  
    }
}
