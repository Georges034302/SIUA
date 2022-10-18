package lecture14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Frequency {
   private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
   
   private List<Integer> numbers(){
//       int size = readInt("Size = ");
//       int seed = readInt("Seed = ");
//       
//       List<Integer> temp = new ArrayList<>();
//       Random r = new Random();
//       
//       for (int i = 0; i < size; i++) {
//           temp.add(r.nextInt(seed));
//       }
//       return temp;
        int size = readInt("Size = ");
        int seed = readInt("Seed = ");
        return new Random().ints(0, seed).limit(size).boxed().collect(Collectors.toList());
   }  
   
   private Map<Integer,Long> frequencies(List<Integer> list){       
       return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));       
   }
   
   private void show(Map<Integer,Long> map){
//       for (Map.Entry<Integer, Long> entry : map.entrySet()) {
//           Integer k = entry.getKey();
//           Long v = entry.getValue();
//           System.out.println(k+"-->"+v);
//       }
       map.forEach((k , v) -> System.out.println(k+"-->"+v));
   }
   
    public static void main(String[] args) {
        Frequency f = new Frequency();
        
        List<Integer> numbers = f.numbers();
        numbers.forEach(x -> System.out.print(x+" "));
        System.out.println();
        
        f.show(f.frequencies(numbers));
    }
   
}
