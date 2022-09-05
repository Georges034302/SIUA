import java.util.Scanner;

public class ZCount{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Character: ");
        char c = in.nextLine().toLowerCase().charAt(0);
        int count = 0;

        while(c != '*'){
            
            //if("zZ".contains(""+c))
            if(c == 'z')            
                count++;
            
            System.out.print("Character: ");
            c = in.nextLine().toLowerCase().charAt(0);
        }
        
        System.out.println("Z count = "+count);
    }
}
