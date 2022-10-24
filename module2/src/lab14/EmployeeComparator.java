package lab14;

import java.util.Comparator;

/**
 *
 * @author George
 */
public class EmployeeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int)o2.getSalary() - (int)o1.getSalary();
    }    
}
