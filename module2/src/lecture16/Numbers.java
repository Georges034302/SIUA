package lecture16;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Numbers {
    static List<Integer> numbers(){
        return (new Random()).ints(0, 40).limit(20).boxed().collect(Collectors.toList());
    }
    
    static void show(List<Integer> list){
        //list.forEach(n -> System.out.println(n+" "));
        list.parallelStream().forEach(n -> System.out.print(n+" "));
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = numbers();
        show(numbers);
    }
}
