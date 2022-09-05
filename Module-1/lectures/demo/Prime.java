import java.util.Arrays;
import java.util.Random;

public class Prime{
    
    //Goal 1: Show the prime numbers
    public static void main(String[] args){
        int [] numbers = new int[20];
        for(int i = 0; i < numbers.length ; i++)
            numbers[i] = (new Random().nextInt(100));
        System.out.println(Arrays.toString(primes(numbers)));
    }
    
    //Goal 2: create the primes array
    public static int[] primes(int[] numbers){
        int size = primeCount(numbers);
        int [] primes = new int[size];
        int j = 0;
        for(int i = 0; i <numbers.length; i++)
            if(isPrime(numbers[i]))
                primes[j++] = numbers[i];
        return primes;
    }
    
    //Goal 3: Count the prime numbers
    public static int primeCount(int[] numbers){
        int count = 0;
        for(int i = 0; i <numbers.length; i++)
            if(isPrime(numbers[i]))
                count++;
        return count;
    }
    
    //Goal 4: check if a number is prime
    public static boolean isPrime(int number){
        for(int i = 2; i < number; i++)
            if(number % i == 0)
                return false;
        return true;
    }
}
