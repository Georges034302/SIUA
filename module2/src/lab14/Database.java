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
public class Database {
    private List<Employee> employees;
    
    public Database(){
        this.employees = new ArrayList<>(); 
        populate();
    }
    
    public void populate(){
//        for (int i = 0; i < 10; i++) {
//            employees.add(new Employee());
//        } 
        employees.addAll(Stream.generate(() -> new Employee()).limit(10).collect(Collectors.toList()));
    }
    
    public void add(){
        this.employees.add(new Employee());
    }
    
    //lookup function - any patten
    public Employee employee(int ID){
//        for(Employee e:employees)
//            if(e.match(ID))
//                return e;
//        return null;
        return employees.stream().filter(e -> e.match(ID)).findAny().orElse(null);
    }
    
    public void update(int ID, double salary){
        Employee e = employee(ID);
        if(e != null)
            e.setSalary(salary);
        else
            System.out.println("Employee does not exist");
    }
    
    public void update(int ID, String role){
        Employee e = employee(ID);
        if(e != null)
            e.setRole(role);
        else
            System.out.println("Employee does not exist");
    }
    
    public void delete(int ID){
        List<Employee> temp = employees.stream().filter(e -> e.match(ID)).collect(Collectors.toList());
        if(temp.size() > 0)
            employees.removeAll(temp);
        else
            System.out.println("Employee does not exist");
    }
    
    public void show(){
        Collections.sort(employees, new EmployeeComparator());
        employees.forEach(Employee::show);
    }
    
    public Map<String, List<Employee>> roleMap(){
        return employees.stream().collect(Collectors.groupingBy(Employee::getRole));
    }
    
    public Map<Boolean, List<Employee>> paritionedMap(double salary){
        return employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() >= salary));
    }
}
