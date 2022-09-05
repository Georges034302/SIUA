import java.util.*;

public class Numbers{

    public static void main(String[] args){
        int[] x = {4,1,3,2,2};
        int [][] numbers = new int[5][2];

        for(int i= 0 ; i< x.length; ++i)
            numbers[i] = new int[2];

        for(int row= 0 ; row< numbers.length; ++row){
            int i = 0;
            for(int col= 0 ; col< numbers[row].length; ++col)
                numbers[row][col] = x[i++];
        }
        System.out.println(Arrays.deepToString(numbers));

    }
}
