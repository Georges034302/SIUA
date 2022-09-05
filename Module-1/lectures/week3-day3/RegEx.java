import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegEx{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("String: ");
        String s = in.nextLine();
        
        while(!s.equals("END")){
            System.out.print("Reg-EX: ");
            String regex = in.nextLine();
            
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);
            
            System.out.print("Replacement: ");
            String replacement = in.nextLine();
            
            s = m.replaceAll(replacement);
            
            System.out.println("New String: "+s);
            
            System.out.print("String: ");
            s = in.nextLine();
        }
    }
}
