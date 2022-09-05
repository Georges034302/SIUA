
/**
 * Generate a 2-D array 2x2 randomly with seed 5
 * Determine the distance between each two points A(i,j) and B(i,j)
 * Condition i != j 
 */
import java.util.Random;
public class Distance{
    public static void main(String []args){
        int x[][] = new int[2][2];
        
        Random r = new Random();
        for(int i=0 ; i < x.length; i++)
            for(int j = 0; j <x[i].length; j++)
                x[i][j] = r.nextInt(5);
        
        double distance = Math.sqrt(Math.pow(0-1,2)+Math.pow(1-0,2));
        
        //double d = Math.sqrt(Math(Math.pow(x[i][j],2) + Math.pow(x[k][m],2));
    }
}
