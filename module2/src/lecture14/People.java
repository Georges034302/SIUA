package lecture14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class People {
    List<Person> people = new ArrayList<>();
    
    private void populate(){
        people.add(new Person("Tom","Australia"));
        people.add(new Person("Lucy","Japan"));
        people.add(new Person("Linda","Egypt"));
        people.add(new Person("Laurence","Australia"));
        people.add(new Person("Tim","Canada"));
        people.add(new Person("Alex","Canada"));
        people.add(new Person("Amen","Egypt"));
        people.add(new Person("Guy","Australia"));
        people.add(new Person("Tracy","Canada"));
        people.add(new Person("Alandra","Canada"));
    }
    
    private Map<String, List<Person>> organized(){
        return people.stream().collect(Collectors.groupingBy(Person::getCountry));
    }
    
    private void showMap(){
        Map<String, List<Person>> map = organized();
//        for (Map.Entry<String, List<Person>> entry : map.entrySet()) {
//            String key = entry.getKey();
//            List<Person> value = entry.getValue();
//            System.out.println(key+"-->"+value);
//        }

        map.forEach((k , v) -> System.out.println(k+"-->"+v));
    }
    
    //any pattern
    private boolean anyMatch(String name){
        return people.stream().anyMatch(p -> (p.match(name)));        
    }
    
    //every pattern
    private boolean allMatches(String name){
        return people.stream().allMatch(p -> p.match(name));
    }
    
    //none pattern
    private boolean noMatch(String name){
        return people.stream().noneMatch(p -> p.match(name));
    }
    
    
//    private Person person(String name){
//        for(Person p:people)
//            if(p.match(name))
//                return p;
//        return null;
//    }
    
    //look up function
    private Person person(String name){
        return people.stream().filter(p -> p.match(name)).findAny().orElse(null);
    }
    
    
    //updated look up
//    private List<Person> persons(String name){
//        List<Person> temp = new ArrayList<>();
//        for(Person p:people)
//            if(p.match(name))
//                temp.add(p);
//        return temp;
//    }
    
    private List<Person> persons(String name){
        return people.stream().filter(p -> p.match(name)).collect(Collectors.toList());
    }
    
    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private void find(){
        String name = readName();
        Person p = person(name);
        
        if(p != null)
            System.out.println(p);
        else
            System.out.println(name+" does not exist");
    }
    
    private void show(){
        people.forEach(System.out::println);
    }
    
    public static void main(String[] args) {
        People people = new People();
        people.populate();
        people.show();
        people.showMap();
        //people.find();
    }

}
