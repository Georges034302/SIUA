package lab14;

/**
 *
 * @author George
 */
public class Student {
    private String name;
    private int mark;
    private String grade;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
        this.grade = grade();
    }
    
    private String grade(){
        return  mark >= 85 ? "HD":
                mark >= 75 ? "D" :
                mark >= 65 ? "C" :
                mark >= 50 ? "P" : "Z";
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public String getGrade() {
        return grade;
    }   

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    public boolean match(String name){
        return this.name.equalsIgnoreCase(name);
    }

    @Override
    public String toString() {
        return String.format( "%-10s-> %02d -> %2s ",name,mark,grade);
    }  
    
}
