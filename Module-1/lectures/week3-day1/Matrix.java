import java.util.Scanner;
import java.util.Arrays;

public class Matrix{
    static Scanner in = new Scanner(System.in); 
    public static void main(String[] args){
        int x[][] = {{2,1},
                     {3,4},
                     {-3,12},
                     {8,0}};
          
        for(int i=0; i< 4; i++){
            for(int j=0; j<2; j++)
                System.out.printf("%6d",x[i][j]);
            System.out.println();
        }
        
        int y[][] = new int[2][3];
        for(int i=0; i< y.length; i++){
            for(int j=0; j<y[i].length; j++){
                System.out.print("Value = ");
                y[i][j] = in.nextInt();
            }
        }        
        String output = Arrays.deepToString(y);
        System.out.println(output);
        
        System.out.print("Rows = ");
        int rows = in.nextInt();
        System.out.print("Columns = ");
        int cols = in.nextInt();
        int z[][] = new int[rows][cols];
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print("Value = ");
                z[i][j] = in.nextInt();
            }
        }        
        String output2 = Arrays.deepToString(z);
        System.out.println(output2);
    }
}
