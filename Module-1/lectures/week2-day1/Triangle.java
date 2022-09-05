import java.util.Scanner;

public class Triangle{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("N = ");
        int n = in.nextInt();
        while (n > 0){
            for(int i = 0 ; i < n; ++i){
                for(int j = 0; j <= i; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
            System.out.print("N = ");
            n = in.nextInt();
            
        }
    }
}