import java.util.Scanner;
public class Test{
    
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("String: ");
        String s = in.nextLine(); 
        StringBuffer sb = new StringBuffer();
        
        for(int i = s.length()-1; i >=0; i--)
            sb.append(s.charAt(i));
        System.out.println(sb);

    }
}
