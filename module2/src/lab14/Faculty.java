package lab14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Faculty {
    public static void main(String[] args) {
        new Faculty().menu();
    }
    
    private List<Student> students;
    
    public Faculty(){
        this.students = new ArrayList<>();
    }
    
    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private int readMark(){
        System.out.print("Mark: ");
        return In.nextInt();
    }
    
    private boolean match(String name){
        return students.stream().anyMatch(s ->s.match(name));
    }
    
    private String uniqueName(){
        String name = "";        
        while((match(name = readName()))){
            System.out.println(name+" exists - try again");
        }
        return name;
    }
    
    private void register(){
//        Stream<Student> stream = Stream.generate(() -> new Student(uniqueName(), readMark())).limit(10);
//        students.addAll(stream.collect(Collectors.toList()));
        for (int i = 0; i < 10; i++) {
            students.add(new Student(uniqueName(), readMark()));
        }
    }
    
    private void add(){
        this.students.add(new Student(uniqueName(), readMark()));
    }
    
    private Student student(String name){
        return students.stream().filter(s -> s.match(name)).findAny().orElse(null);
    }
    
    private void find(){
        String name = readName();
        Student s = student(name);
        
        if(s != null)
            System.out.println(s);
        else
            System.out.println(name+" does not exist");
    }
    
    private void show(){
        students.forEach(System.out::println);
    }
    
    private void topFive(){
        Collections.sort(students, new StudentComparator());
        students.stream().limit(5).forEach(System.out::println);
    }
    
    private Map<Boolean,List<Student>> partitioned(){
        return students.stream().collect(Collectors.partitioningBy(s -> s.getMark() >= 50));
    }
    
    private void showPass(){
        Map<Boolean,List<Student>> map = partitioned();
        map.forEach((k , v) -> System.out.printf("%4s --> %-12s %n",k?"PASS":"FAIL",v));
    }
    
    private Map<String, List<Student>> organized(List<Student> list){
        return list.stream().collect(Collectors.groupingBy(Student::getGrade));
    }
    
    private void view(){
        Map<String, List<Student>> map = organized(students);
        map.forEach((k , v) -> System.out.printf("%4s --> %-12s %n",k,v));
    }
    
    private char readChoice(){
        System.out.print("Choice(r/a/f/p/v/s/t/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'r':register();break; 
                case 'a':add();break;
                case 'f':find();break;
                case 'p':showPass();break;
                case 's':show(); break;
                case 'v':view();break;
                case 't':topFive(); break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("r - register");
        System.out.println("a - add student");
        System.out.println("f - find student");
        System.out.println("v - view");
        System.out.println("s - show");
        System.out.println("t - top five");
        System.out.println("p - show pass");
        System.out.println("x - exit");
    }
}
