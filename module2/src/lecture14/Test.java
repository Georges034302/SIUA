package lecture14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 *
 * @author George
 */
public class Test {
    public static void main(String[] args) {
        
        
//        String s = "Java Streaming is Fun";
//        
//        List<Character> characters = s.chars()
//                                      .mapToObj(c -> (char)c)
//                                      .collect(Collectors.toList());
//        
//        characters.forEach(c -> System.out.println(c+" "));
       
        
//        IntStream stream = IntStream.rangeClosed(1, 10);    
//        
//        List<Integer> numbers = stream.boxed().collect(Collectors.toList());        
//        numbers.stream()
//                .filter(x -> x >=5 )
//                .sorted()
//                .limit(4)
//                .forEach(System.out::println);
        
        
//          List<String> words = Arrays.asList("Welcome","to", "Java", "streams");
//          
//          Pattern regex = Pattern.compile("^[A-Z]");
//          
//          List<String> upper = words.stream()
//                                    .filter(regex.asPredicate())
//                                    .collect(Collectors.toList());
//          
//          upper.forEach(System.out::println);
          
          
//        Stream<Integer> stream1 = Stream.iterate(1, x -> x+1).limit(20);
//        
//        stream1.filter(x -> x%2 ==0)
//                .forEach(x -> System.out.print(x+" "));
//        
//        Stream<Integer> stream2 = Stream.iterate(1, x -> x+1).limit(20);
//        
//        int sum = stream2.filter(x -> x%2 ==0).reduce(0, (x,y) -> x+y);       
//        
//        System.out.println("Even sum = "+sum);
//        
//        List<Integer> stream3 = Stream.iterate(1, x -> x+2)
//                                        .limit(30)
//                                        .collect(Collectors.toList());
        
//        stream3.parallelStream()
//                .filter(x -> x%2 ==0)
//                .limit(5)
//                .forEach(x -> System.out.println(x+ " "));
        
//        List<Integer> stream = new Random().ints(5, 100)
//                                            .limit(10)
//                                            .boxed()
//                                            .collect(Collectors.toList());
        
//        
//        List<Double> doubles = stream.limit(10)
//                                     .filter(x -> x > 0.4)
//                                     .skip(2)
//                                     .filter(x -> x < 0.9)
//                                     .collect(Collectors.toList());
        
        
        
    }
}
