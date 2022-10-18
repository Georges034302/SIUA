package lecture14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author George
 */
public class Numbers {
    private List<Integer> evens(int steps, int limit){
        /*
            List<Integer> temp = new ArrayList();
            for(int i=steps; i<limit; i++)
                if(i % 2 == 0)
                    temp.add(i);
            return temp;
        
        */
        return IntStream.iterate(0, i -> i+1)
                                    .skip(steps)
                                    .limit(limit)
                                    .filter(x -> x % 2 ==0)
                                    .boxed()
                                    .collect(Collectors.toList());
    }
    
    private void show(List<Integer> list){
        list.forEach(n -> System.out.print(n+" "));
        System.out.println();
    }
    
    private int sum(List<Integer> list){
        /*
            int sum = 0;
             for(Integer n: list)
                sum+= n;
            return sum;
        */
        return list.stream().reduce(0, (x ,y) -> x+y);
    }
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    public static void main(String[] args) {
        Numbers n = new Numbers();
        List<Integer> evens = n.evens(n.readInt("Steps: "),n.readInt("Limit: "));
        n.show(evens);
        System.out.println("Sum = "+n.sum(evens));
        
    }
}
