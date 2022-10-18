package lecture14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Vowels {
    private String readString(){
        System.out.print("String: ");
        return In.nextLine();
    }
    
    private void map(){
        String s;        
        while(!(s = readString()).equals("*")){
            show(frequencies(s.toLowerCase()));
        }    
    }    
    
    //mapping the vowel frequencies from a string
    private Map<Character,Long> frequencies(String s){
        return s.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> "aieuo".contains(""+c))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
    
    private void show(Map<Character,Long> map){
        map.forEach((k , v) -> System.out.println(k+" --> "+v));
    }
    
    public static void main(String[] args) {
        (new Vowels()).map();
    }
}
