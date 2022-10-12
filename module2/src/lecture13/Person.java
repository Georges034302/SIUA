package lecture13;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }
    
    interface PersonFactory {
        Person create(String name, int age);
    }
    
    interface PersonNameFactory{
        Person create(String name);
    }
    
    interface PersonAgeFactory{
        Person create(int age);
    }
    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
    
    public static void main(String[] args) {  
        List<Person> people = new ArrayList<>();
        
        PersonFactory p1 = Person::new ;  //constructor referencing
        Person george = p1.create("George", 44);
        people.add(george);
        
        PersonNameFactory p2 = Person::new ;
        Person tim = p2.create("Tim");
        people.add(tim);
        
        PersonAgeFactory p3 = Person::new ;
        Person alen = p3.create(30);
        people.add(alen);
        
        people.forEach(p -> System.out.println(p)); //lambda
        people.forEach(System.out::println); //method referencing
    }
}
