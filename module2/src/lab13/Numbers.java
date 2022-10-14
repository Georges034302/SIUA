package lab13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author George
 */
public class Numbers {
    private List<Integer> numbers;
    
    public Numbers(int seed, int size){
        this.numbers = numbers(seed, size);
    }
    
    public List<Integer> numbers(int seed, int size){
        List<Integer> temp = new ArrayList();
        Random r = new Random();
        
        Set<Integer> unique = new HashSet();
        
        for (int i = 0; i < size; i++) {
            unique.add(r.nextInt(seed));
        }
        
        temp.addAll(unique);
        
        return temp;            
    }
    
    public void show(){
        numbers.forEach(obj -> System.out.print(obj+" "));
        System.out.println();
    }
    
    public int binarySearch(int target){        
        Collections.sort(numbers);
        return Collections.binarySearch(numbers, target);        
    }
    
    public int min(){
        return Collections.min(numbers);
    }
    
    public int max(){
        return Collections.max(numbers);
    }
}
