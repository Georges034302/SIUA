
package lecture13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reference {
    private List<String> countries(){
        return new ArrayList(Arrays.asList("USA", "Australia", "Taiwan", "Japan", "France"));
    }
    
    interface CountryCode{
        String sub(String country);
    }
    
    /*
        @Override
        public String sub(String s){
            return s.substring(0,2);
        }    
    
    */
    
    private void showCode(String country){
        CountryCode code = (s) -> s.substring(0, 2)+"--"+s;
        System.out.println(code.sub(country));
    }
    
    interface Upper{
        String capitalize(String s);
    }
    
    private void toUpper(String country){
        Upper upper = s -> s.toUpperCase();
        System.out.println(upper.capitalize(country));
    }
    
    public static void show(String s){
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        Reference ref = new Reference();
        
        List<String> countries = ref.countries();
        
        countries.forEach(ref::showCode); //object referencing
        
        countries.forEach(ref::toUpper); //object referencing
        
        countries.forEach(Reference::show); //static referencing
                
    }
}

