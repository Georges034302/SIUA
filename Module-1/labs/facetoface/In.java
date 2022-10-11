
import java.util.Scanner;

public class In{
    static Scanner in = new Scanner(System.in);

    public static int readInt(String prompt){
        System.out.print(prompt);
        return in.nextInt();
    }

    public static int nextInt(){        
        return in.nextInt();
        //in.nextLine();
    }

    public static char nextChar(){
        return in.nextLine().charAt(0);
    }

    public static char nextChar(String prompt){
        System.out.print(prompt);
        return in.nextLine().charAt(0);
    }

    public static double nextDouble(String prompt){
        System.out.print(prompt);
        return in.nextDouble();
    }

    public static double nextDouble(){
        return in.nextDouble();
    }
    
    public static String nextLine(String prompt){
        System.out.print(prompt);
        return in.nextLine();
    }
    
    public static String nextLine(){
        return in.nextLine();
    }
}
