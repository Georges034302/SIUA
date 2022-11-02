package lecture16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class ExecutorDemo {
     private int sum(List<Integer> list) {
        return list.stream().reduce(0, (x, y) -> x + y);
    }

    private void show(List<Integer> list) throws InterruptedException {
        list.forEach(System.out::println);
    }

    private int max(List<Integer> list) throws InterruptedException {
        return Collections.max(list);
    }
    
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        ExecutorDemo demo = new ExecutorDemo();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 8, 3, 4, 6));
        
        Runnable sumRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Sum = " + demo.sum(numbers));                
            }            
        };

        
        Runnable showRunnable = () -> {
            try {
                demo.show(numbers);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        es.submit(sumRunnable);
        es.submit(showRunnable);             
        
        es.shutdown();
    }
}
