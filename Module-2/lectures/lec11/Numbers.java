
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Numbers{
    private List<Integer> numbers;
    
    public Numbers(){
        this.numbers = new ArrayList();        
    }
    
    public void generate(){
        Random r = new Random();
        List<Integer> temp = new ArrayList();
        for(int i = 0 ; i < 20 ; i++)
            temp.add(r.nextInt(100));
        numbers.clear();
        numbers.addAll(temp);
    }
    
    //lookup function using the any pattern
    public boolean number(int target){
        for(Integer e:numbers)
            if(target == e)
                return true;
        return false;
    }
    
    private boolean isPrime(int number){
        for(int i = 2; i< number; i++)
            if(number%i == 0)
                return false;
        return true;
    }
    
    //find all - updated lookup  pattern
    private List<Integer> primes(){
        List<Integer> matches = new ArrayList();
        for(Integer e:numbers)
            if(isPrime(e))
                matches.add(e);
        return matches;
    }
    
    public void show(){
        System.out.println("Numbers: "+numbers);
        System.out.println("Primes: "+primes());
    }
    
    
}


