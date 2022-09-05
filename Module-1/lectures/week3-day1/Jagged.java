import java.util.Arrays;
import java.util.Scanner;

public class Jagged{
    static Scanner in = new Scanner(System.in); 
    public static void main(String[] args){
        
        int  x[][] = {  {1,2},
                        {3,4,5},
                        {6,7,8,9}
                    };
        
        for(int  i=0; i < x.length; i++){           
            for(int j=0; j < x[i].length; ++j)                                     
                if(x[i][j] != x[2][2]) 
                    System.out.print(x[i][j]+"  ");
                else
                    System.out.print(" ");
            System.out.println();
        }
        
        //System.out.println(Arrays.deepToString(x));
    }
}
