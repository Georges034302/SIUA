package lab14;

import java.util.Random;

/**
 *
 * @author George
 */
public class Employee {
    private int ID;
    private double salary;
    private String  role;
    
    public Employee(){
        this.ID = (new Random()).nextInt(999)+1;
        this.salary = (new Random()).doubles(36, 201).limit(1).sum();
        this.role = role();
    }
    
    private String role(){
//        String[] roles = {"HR", "Developer", "Admin", "Tester", "Manager"};
//        Random r = new Random();
//        int index = r.nextInt(roles.length);
//        return roles[index];
        switch(new Random().nextInt(5)){
            case 0: return "HR";
            case 1: return "Developer";
            case 2: return "Admin";
            case 3: return "Tester";
            default: return "Manager";
        }
    }
    
    public boolean match(int ID){
        return this.ID == ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void show(){
        System.out.printf("| %-12s | salary= $%6.2f K | role= %10s| %n",this,salary,role);
    }

    @Override
    public String toString() {
        return String.format("Employee-ID: %03d", ID);
    }
    
}
