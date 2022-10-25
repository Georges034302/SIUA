package lecture15;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author George
 */
public class Student implements Serializable{
    private int mark;
    private String grade;
    private int ID;

    public Student() {
        this.mark = (new Random()).nextInt(101);
        this.grade = grade();
        this.ID = (new Random()).nextInt(999)+1;
    }
    
    private String grade(){
        return  mark >= 85 ? "HD":
                mark >= 75 ? "D" :
                mark >= 65 ? "C" :
                mark >= 50 ? "P" : "Z";
    }

    @Override
    public String toString() {
        return "Student{" + "mark=" + mark + ", grade=" + grade + ", ID=" + ID + '}';
    }   
    
}
