package lecture13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author George
 */
public class Evens {

    private int readInt(String prompt) {
        System.out.print(prompt);
        return In.nextInt();
    }

    private List<Integer> numbers() {
        List<Integer> temp = new ArrayList<>();
        int seed = readInt("Seed = ");
        int size = readInt("Size = ");
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            temp.add(r.nextInt(seed));
        }
        return temp;
    }

    private void show(List<Integer> list) {
        list.forEach(obj -> System.out.print(obj + " "));
        System.out.println();
    }

    interface Even {
        boolean isEven(Integer n);
    }

    private List<Integer> evens(List<Integer> list) {
        List<Integer> temp = new ArrayList<>();

        Even even = (n) -> n % 2 == 0;

        list.forEach((x) -> {
            if (even.isEven(x)) {
                temp.add(x);
            }
        });
        
        return temp;
    }
    
    private void search(List<Integer> list){
        int target = readInt("Target = ");
        int pos = Collections.binarySearch(list, target);
        if(pos >= 0)
            System.out.println(target+" is located at position "+pos);
        else
            System.out.println(target+" does not exist!");
    }
    
    public static void main(String[] args) {
        Evens e = new Evens();
        
        List<Integer> numbers = e.numbers();
        Collections.sort(numbers);
        e.show(numbers);
        
        List<Integer> evens = e.evens(numbers);
        Collections.sort(evens);
        e.show(evens);
        
        e.search(numbers);
    }
}

