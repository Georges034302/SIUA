package lab14;

import java.util.Comparator;

/**
 *
 * @author George
 */
public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student obj1, Student obj2) {
        return obj2.getMark() - obj1.getMark();
    }       
}
