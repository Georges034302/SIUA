package lab14;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Mapper {
    public static List<Integer> numbers(){
          return new Random().ints(0, 10).limit(10).boxed().collect(Collectors.toList());
    }
    
    public static List<Integer> sorted(List<Integer> list){
        return list.stream().sorted().collect(Collectors.toList());
    }
    
    public static List<Integer> unique(List<Integer> list){
        return list.stream().distinct().collect(Collectors.toList());
    }
    
    public static int sum(int n){
        return Stream.iterate(1, x -> x+1).limit(n).reduce(0, (x , y) -> x+y); 
    }
    
    public static long factorial(int n){
        return IntStream.rangeClosed(1, n).reduce(1, (x , y) -> x*y);
    }
    
    public static List<Integer> topFive(List<Integer> list){
        return list.stream().limit(5).collect(Collectors.toList());
    }
    
    public static List<Integer> evens(List<Integer> list){
        return list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }
    
    public static void show(List<Integer> list){
        list.forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
    
    public static void showSum(List<Integer> list){
        list.forEach(x -> System.out.print(sum(x)+" "));
        System.out.println();
    }
    
    public static void showFactorial(List<Integer> list){
        list.forEach(x -> System.out.print(factorial(x)+" "));
        System.out.println();
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = numbers();
        show(numbers);
        List<Integer> sorted = sorted(numbers);
        show(sorted);
        List<Integer> unique = unique(sorted);
        show(unique);
        show(topFive(unique));
        List<Integer> evens = evens(unique);
        show(evens);
        showSum(unique);
        showFactorial(unique);
    }    
}

