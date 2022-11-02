package lecture16;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Runner implements Runnable{
    private List<Integer> numbers(){
        return (new Random()).ints(0, 40).limit(20).boxed().collect(Collectors.toList());
    }
    
    private int sum(List<Integer> list){
        return list.stream().reduce(0, (x , y) -> x+y);
    }
    
    private int min(List<Integer> list){
        return Collections.min(list);
    }
    
    private int max(List<Integer> list){
        return Collections.max(list);
    }
    
    private double average(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }
    
    private int countDistinct(List<Integer> list){
        return (int)list.stream().distinct().count();
    }

    @Override
    public void run() {
        List<Integer> list = numbers();
        System.out.println("Sum = "+sum(list));
        System.out.println("Min = "+min(list));
        System.out.println("Max = "+max(list));
        System.out.println("Average = "+average(list));
        System.out.println("Distinct Count = "+countDistinct(list));
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(new Runner());
        t.start();
    }
}
