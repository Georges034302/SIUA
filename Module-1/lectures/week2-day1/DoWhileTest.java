import java.util.Scanner;

public class DoWhileTest{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        int n=0;
        do{            
            System.out.print("N = ");
            n = in.nextInt();
            System.out.println("You entered "+n);

        }while(n != -5);
    }
}
