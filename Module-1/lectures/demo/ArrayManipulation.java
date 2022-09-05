import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Random;

public class ArrayManipulation {

    public static int nextInt() {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        scanner.nextLine(); // read the "\n" as well
        return value;
    }

    public static void setValue(List<List<Integer>> list, int row, int column) {
        Random r = new Random();        
        list.get(row).set(column, r.nextInt(10));
    }

    public static void updateMatrix(List<List<Integer>> list) {

        for(int row= 0 ; row< list.size(); ++row){
            for(int col= 0 ; col< list.get(row).size(); ++col)
                setValue(list,row,col);
        }
    }


    public static void showList(List<List<Integer>> list) {
        for(int row= 0 ; row< list.size(); ++row){
            for(int col= 0 ; col< list.get(row).size(); ++col)
                System.out.print(list.get(row).get(col)+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> arr2 =Arrays.asList(
                            Arrays.asList(5, 3, 2),
                           Arrays.asList(4, 2),
                           Arrays.asList(2, 7, 1));

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        updateMatrix(arr);
        showList(arr2);
    }
}