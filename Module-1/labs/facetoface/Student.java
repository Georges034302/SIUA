
public class Student{
    private int ID;
    private String name;
    private int mark;
    private String grade;

    public Student(int ID, String name, int mark){
        this.ID = ID;
        this.name = name;
        this.mark = mark;
        this.grade = grade(mark);
    }
    
    private String grade(int mark){
        return  (mark>=85)?"HD":
                (mark>=75)?"D" :
                (mark>=65)?"C" :
                (mark>=50)?"P" : "Z";
    }
    
    @Override
    public String toString(){
        return String.format("%6d :: %-8s - Result(%2d,%2s)", ID,name,mark,grade);
    } 
}
