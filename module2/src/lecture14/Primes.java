package lecture14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author George
 */
public class Primes {
    private List<Integer> numbers(int first, int last){
        return IntStream.rangeClosed(first, last).boxed().collect(Collectors.toList());
    }
    
    private boolean isPrime(int n){
//        for(int i=2; i< n; i++)
//            if(n % i == 0)
//                return false;
//        return true;
        return IntStream.range(2, n).noneMatch(i -> n%i == 0);
    }
    
    private List<Integer> primes(List<Integer> list){
        return list.stream().filter(n -> isPrime(n)).collect(Collectors.toList());
    }
    
    private int sum(List<Integer> list){
        return list.stream().reduce(0, (x , y) -> x+y);
    }
    
    private int count(List<Integer> list){
        return (int)list.stream().filter(x -> isPrime(x)).count();
    }
    
    private void show(List<Integer> list){
        list.forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    public static void main(String[] args) {
        Primes prime = new Primes();
        
        List<Integer> numbers = prime.numbers(prime.readInt("First = "), prime.readInt("Last = "));
        List<Integer> primes = prime.primes(numbers);
        
        prime.show(numbers);
        prime.show(primes);
        
        System.out.println("Sum = "+prime.sum(numbers));
        System.out.println("Prime count = "+prime.count(numbers));
        
    }
}
