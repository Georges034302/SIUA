package lecture15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author George
 */
public class Faculty {
    public static final String RED_BOLD = "\033[1;31m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String WHITE_BOLD = "\033[1;37m";
    StudentController manager;
    
    public static void main(String[] args) throws FileNotFoundException {
        new Faculty().menu();
    }
    
    public Faculty(){
        manager = new StudentController();
    }
    
    private void register(){
        manager.register();
    }
    
    private void view(){
        List<Student> students = new ArrayList<>();
        try {
            System.out.println(YELLOW_BOLD+"Reading students to list");
            students = manager.readStudents();
        } catch (IOException ex) {
            System.out.println(RED_BOLD+"Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println(RED_BOLD+"Serialization issues");
        }       
        if(students.size() > 0)
            students.forEach(System.out::println);
        else
            System.out.println(RED_BOLD+"Updating unsuccessful");
    }
    
    private void save(){
        System.out.println(YELLOW_BOLD+"Saving students to list");
        try {
            manager.save();
        } catch (IOException ex) {
            System.out.println(RED_BOLD+"Cannot read from file");
        }
    }
    
    private void read(){
        List<Student> students = new ArrayList<>();
        try {
            System.out.println(YELLOW_BOLD+"Reading students to list");
            students = manager.readStudents();
        } catch (IOException ex) {
            System.out.println(RED_BOLD+"Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println(RED_BOLD+"Serialization issues");
        }   
        if(students.size() > 0)
            students.forEach(System.out::println);
        else
            System.out.println(RED_BOLD+"Updating unsuccessful");
    }
    
    private void update(){
        List<Student> students = new ArrayList<>();
        try {
            System.out.println(YELLOW_BOLD+"Adding 10 more students");
            students = manager.readStudents();
            manager.updateList(students);
            manager.register();
            manager.save();
        } catch (IOException ex) {
            System.out.println(RED_BOLD+"Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println(RED_BOLD+"Serialization issues");
        }       
    }
    
    private void clear(){
        System.out.println(YELLOW_BOLD+"Clearing students file");
        try {
            manager.clear();
        } catch (IOException ex) {
            Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice(){
        System.out.print("Choice(p/v/s/r/u/c/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p':register();break; 
                case 'v':view();break;
                case 's':save();break;
                case 'r': read(); break;
                case 'u':update();break;
                case 'c':clear();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("p - register 10 students");
        System.out.println("v - view registered students");
        System.out.println("s - save students data to file");
        System.out.println("r - read students from file");
        System.out.println("u - register 10 more students");
        System.out.println("c - clear students file data");
        System.out.println("x - exit");
    }   
    
}
