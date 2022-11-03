package lecture16;

import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Student {
    private String name;
    private int age;
    
    public Student(){
        this.name = randomName();
        this.age = randomAge();
    }
    
    private String randomName(){
//        StringBuilder sb = new StringBuilder();
//        
//        for (int i = 0; i < 5; i++) {
//            sb.append((char)(new Random().nextInt(25)+97));
//        }        
//        return sb.toString();
        return new Random().ints(5, 97, 123)
                    .mapToObj(c -> (char)c+"")
                    .map(String:: valueOf)
                    .collect(Collectors.joining());
    }
    
    private int randomAge(){
        //return new Random().ints(18, 101).limit(1).sum();
        return new Random().ints(1, 18, 101).findFirst().getAsInt();
    }

    @Override
    public String toString() {
        return name + " - age: " + age ;
    }   
}
