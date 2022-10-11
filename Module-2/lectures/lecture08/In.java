import java.util.Scanner;

public class In{
    private static Scanner in = new Scanner(System.in);

    public static int readInt(){
        return in.nextInt();
    }
    
    public static int readInt(String prompt){
        System.out.print(prompt);
        return In.readInt();
    }
    
    public static double readDouble(){
        return in.nextDouble();
    }
    
    public static double readDouble(String prompt){
        System.out.print(prompt);
        return In.readDouble();
    }
    
    public static String readString(){
        return in.nextLine();
    }
    
    public static String readString(String prompt){
        System.out.print(prompt);
        return in.nextLine();
    }
    
    public static char readChar(){
        return in.nextLine().charAt(0);
    }
    
    public static char readChar(String prompt){
        System.out.print(prompt);
        return in.nextLine().charAt(0);
    }
}
