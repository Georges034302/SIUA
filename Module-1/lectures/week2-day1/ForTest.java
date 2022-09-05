import java.util.Scanner;

public class ForTest{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("N = ");
        int n = in.nextInt();

        while(n >= 0){
            int f = 1;

            if(n == 0)
                System.out.println("Factorial("+n+") = "+f);            
            else{
                for(int i = 2 ; i <= n ; i++)
                    f *= i;
                System.out.println("Factorial("+n+") = "+f);
            }
            System.out.print("N = ");
            n = in.nextInt();
        }
    }
}
