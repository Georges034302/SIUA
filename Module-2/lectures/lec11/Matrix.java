import java.util.*;
public class Matrix{
    public static void main(String[] args){
        int x[][] = new int[2][2];
        System.out.println("2-array");
        for(int i=0; i< x.length;i++)
            for(int j = 0; j <x[i].length; j++)
                x[i][j] = i+1;

        for(int i=0; i< x.length;i++){
            for(int j = 0; j <x[i].length; j++)
                System.out.print(x[i][j]+" ");
            System.out.println();
        }

        System.out.println("2-list");
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(5, 3, 2),
                Arrays.asList(4, 2),
                Arrays.asList(5, 3, 2,9),
                Arrays.asList(2, 7, 1),
                Arrays.asList(3, 3, 2, 9, 4)
            );
       
        for(int i=0; i< numbers.size();i++){
            for(int j = 0; j <numbers.get(i).size(); j++)
                System.out.print(numbers.get(i).get(j)+" ");
            System.out.println();
        } 
        
        System.out.println(Arrays.deepToString(numbers.toArray()));
        System.out.println(numbers);
    }
}
