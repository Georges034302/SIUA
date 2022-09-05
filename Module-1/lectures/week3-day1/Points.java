import java.util.Scanner;
import java.util.Arrays;

public class Points{
    static Scanner in = new Scanner(System.in);    

    public static void main(String[] args){
        int x [][] = new int[2][3];
        
        for(int i=0; i < x.length; i++){
            for(int j=0 ; j < x[i].length; j++){
                System.out.print("Value = ");
                x[i][j] = in.nextInt();
            }
        }
        
        String output = Arrays.deepToString(x);
        System.out.println(output);
    }
}
