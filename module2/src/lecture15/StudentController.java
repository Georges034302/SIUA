package lecture15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class StudentController {
    private List<Student> students = new ArrayList<>();
    private String filename = "students.data";
    
    public StudentController(){}
    
    public void updateList(List<Student> list){
        this.students.addAll(list);
    }
    
    public void register(){
        students.addAll(Stream.generate(() -> new Student()).limit(10).collect(Collectors.toList()));
    }
    
    //saving objects to a file
    public void save() throws FileNotFoundException, IOException{
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        
        objOut.writeObject(students);
        
        objOut.close();
        fileOut.close();        
    }
    
    //reading objects from a file
    public List<Student> readStudents() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        
        List<Student> temp = (List<Student>) objIn.readObject();
        
        objIn.close();
        fileIn.close();        
        
        return temp;
    }
    
    //clear file data - without deleting the file
    public void clear() throws FileNotFoundException, IOException{
        FileOutputStream fileOut = new FileOutputStream(filename,false);
        fileOut.flush();
        fileOut.close(); 
    }

    public void show(){
        students.forEach(System.out::println);
    }   
    
    
}
