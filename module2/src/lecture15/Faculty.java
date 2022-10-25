package lecture15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author George
 */
public class Faculty {
    public static final String RED_BOLD = "\033[1;31m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String WHITE_BOLD = "\033[1;37m";
    
    
    public static void main(String[] args) throws FileNotFoundException {
        StudentController manager = new StudentController();
        manager.register();
        manager.show();
        
        try {
            System.out.println(YELLOW_BOLD+"Saving students to list");
            manager.save();
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        }
        
      
        List<Student> students = new ArrayList<>();
        try {
            System.out.println(YELLOW_BOLD+"Reading students to list");
            students = manager.readStudents();
            
            //to update 
            //manager.updateList(students);
            //manager.register();
            //manager.save();
        } catch (IOException ex) {
            System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Serialization issues");
        }
        
        if(students.size() > 0)
            students.forEach(System.out::println);
        else
            System.out.println("Reading unsuccessful");

    }
}
