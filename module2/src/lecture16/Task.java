package lecture16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Task implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() throws Exception {
        return new Random().ints(0, 11).limit(10).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tasks.add(new Task());
        }

        List<Future<List<Integer>>> futures = es.invokeAll(tasks);

//        futures.parallelStream().forEach(f -> {
//            try {
//                f.get().parallelStream().forEach(System.out::println);                  
//            } catch (InterruptedException | ExecutionException ex) {
//                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        
        for(Future<List<Integer>> future: futures){
            List<Integer> list = future.get();
            list.forEach(n -> System.out.println(n+" "));
            System.out.println("-----------------------");
        }
        
        es.shutdown();
    }
}
