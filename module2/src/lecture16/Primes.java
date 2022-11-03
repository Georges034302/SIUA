/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture16;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author George
 */
public class Primes implements Callable<List<Integer>>{
    
    private boolean isPrime(int number){
//        for(int i=2; i < number; i++)
//            if(number % i == 0)
//                return false;
//        return true;
        return IntStream.range(2, number).noneMatch(n -> number%n == 0);
    }

    @Override
    public List<Integer> call() throws Exception {
        return (new Random()).ints(1, 1001).limit(10000).filter(n -> isPrime(n)).boxed().collect(Collectors.toList());
    }    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(5);
                
        Future<List<Integer>> future = es.submit(new Primes());
        
        List<Integer> primes = future.get(); //promised result from call() asynchronously
        
        
        System.out.println("Sequential Printing: ");
        long startSeq = System.currentTimeMillis();
        primes.stream().forEach(n -> System.out.print(n+" "));
        long endSeq = System.currentTimeMillis();
        System.out.println("\nSequential Duration = "+(endSeq - startSeq));
        
        System.out.println("\n\n");
        
        System.out.println("Parallel Printing: ");    
        long startPar = System.currentTimeMillis();
        primes.parallelStream().forEach(n -> System.out.print(n+" ")); 
        long endPar = System.currentTimeMillis();
        System.out.println("\nParallel Duration = "+(endPar - startPar));
        
        es.shutdown(); //important to shutdown        
    }
    
}
