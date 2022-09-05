import java.util.Scanner;

public class WhileTest{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        int i = 5;
        
        while (i <= 15){
            System.out.println(i+"\t--> \t"+Math.pow(i,2));
            i++;
        }
        
        System.out.print("N = ");
        int n = in.nextInt();
        
        int sum = 0;
        
        while(n != -1){
            sum += n;
            System.out.print("N = ");
            n = in.nextInt();
        }
        System.out.println(sum);
    }
}
