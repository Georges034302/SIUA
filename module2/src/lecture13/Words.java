/*
 * Read in a String until * and apply the following changes
 * Change the first letter to uppercase
 * Then change all the rest to lowercase
 * HINT: use the Function<T,R> interface
 */
package lecture13;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author George
 */
public class Words {
    
    private String readString(){
        System.out.print("String: ");
        return In.nextLine();
    }
    
    private void change(){
        String s;
        
        while(!(s = readString()).equals("*")){
            change(s);
            display(s);
        }
    }
    
    private void change(String string){
        //for a string change the first letter to upper
        Function<String,String> convert = (s) -> s.replace(s.charAt(0), Character.toUpperCase(s.charAt(0)));
        //adding a new rule to the apply (first lambda)
        convert = convert.andThen(s -> s.charAt(0)+s.substring(1).toLowerCase());
        System.out.println(convert.apply(string));        
    }
    
    //print a string as upper using the Consumer<T> interface
    private void display(String string){
        Consumer<String> first = (s) -> {
            System.out.println(s.toUpperCase());
        };
        
        Consumer<String> second = (s) -> {  
            StringBuffer sb = new StringBuffer();
            sb.append(s.charAt(0));
            for(int i=1; i < s.length(); i++)
                sb.append('#');
            System.out.println(sb.toString());
        };
        
        Consumer<String> result = first.andThen(second);
        result.accept(string);
    }
    
    
    
    public static void main(String[] args) {
        (new Words()).change();
    }    
}
