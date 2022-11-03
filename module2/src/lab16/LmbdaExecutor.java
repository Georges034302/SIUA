package lab16;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class LmbdaExecutor {

    static List<Integer> numbers() {
        return new Random().ints(0, 21).distinct().limit(10).sorted().boxed().collect(Collectors.toList());
    }

    static void show(List<Integer> list){
        list.forEach(n -> System.out.print(n+" "));
        System.out.println();
    }
    
    static List<Runnable> tasks(int size) {
        return Stream.generate(() -> new Thread(() -> show(numbers())))
                .limit(size)
                .collect(Collectors.toList());
    }
    
    static ScheduledExecutorService service(){
        return Executors.newSingleThreadScheduledExecutor();
    }
    
    static ExecutorService service(int size){
        return Executors.newFixedThreadPool(size);
    }
    
    static void execute(List<Runnable> tasks, ScheduledExecutorService es){
        long delay = 1000;
        int i = 1;
        for(Runnable task:tasks){
            es.schedule(task, i*delay, TimeUnit.MILLISECONDS);
            i+=2;
        }
        es.shutdown();
    }
    
    static void execute(List<Runnable> tasks, ExecutorService es){
        for(Runnable task:tasks){
            es.execute(task);
        }
        es.shutdown();
    }
    
    public static void main(String[] args) {
        List<Runnable> tasks = tasks(3);
        ExecutorService es = service(3);
        execute(tasks, es);
        
        
        ScheduledExecutorService ses = service();
        execute(tasks, ses);
    }
          
}
