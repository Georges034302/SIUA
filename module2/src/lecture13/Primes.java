package lecture13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 *
 * @author George
 */
public class Primes {

    private List<Integer> primes = new ArrayList();

    private int readInt(String prompt) {
        System.out.print(prompt);
        return In.nextInt();
    }

    private List<Integer> numbers() {
        int size = readInt("Size = ");
        int seed = readInt("Seed = ");
        
        Random r = new Random();
        
        List<Integer> temp = new ArrayList<>();
        
        for(int i=0; i< size; i++)
            temp.add(r.nextInt(seed));
        
        return temp;
    }
    
    private void show(List<Integer> list){
        list.forEach(e -> System.out.print(e+" "));
        System.out.println();
    }
    
    private boolean isPrime(int n){        
        for(int i = 2; i < n; i++)
            if(n % i == 0)
                return false;
        return true;
    }
    
    //using Consumer
    private void showPrimes(List<Integer> list){
        //populate a list of primes        
        Consumer<List<Integer>> populate = obj ->{
            list.forEach( n ->{
                if(isPrime(n)) obj.add(n);
            });
        };
        
        //show the list of primes
        Consumer<List<Integer>> view = obj ->{
            obj.forEach(n -> System.out.print(n+" "));
            System.out.println();
        };
        
        Consumer<List<Integer>> output = populate.andThen(view);
        output.accept(this.primes);
    }
    
    //using lambda and forEach only
    private void showPrimesv2(List<Integer> list){
        list.forEach(n -> {
           if(isPrime(n)) this.primes.add(n);
        });
        
        this.primes.forEach(n -> System.out.print(n+" "));        
    }
    
    public static void main(String[] args) {
        Primes prime = new Primes();
        
        List<Integer> numbers = prime.numbers();
        prime.show(numbers);
        Collections.sort(numbers);
        prime.show(numbers);
        
        prime.showPrimes(numbers);
    }
    
}
