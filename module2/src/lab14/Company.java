package lab14;

/**
 *
 * @author George
 */
public class Company implements DBConnector {

    public static void main(String[] args) {
        (new Company()).menu();
    }

    private Database db;

    public Company() {
        this.db = database();
    }

    @Override
    public Database database() {
        return new Database();
    }

    private char readChoice() {
        System.out.print("Choice(c/f/u/d/s/g/p/x): ");
        return In.nextChar();
    }
    
    private void add(){
        db.add();
    }
    
    private int readID(){
        System.out.print("ID: ");
        return In.nextInt();
    }
    
    private void find(){
        Employee e = db.employee(readID());
        if(e != null)
            e.show();
        else
            System.out.println("Employee does not exist");
    }

    private char read(String prompt){
        System.out.print(prompt);
        return In.nextChar();
    }
    
    private String readRole(){
        System.out.print("Role: ");
        return In.nextLine();
    }
    
    private double readSalary(){
        System.out.print("Salary: ");
        return In.nextDouble();
    }
    
    private void update(){
        int ID = readID();
        char choice = read("Update (R)ole or (S)alary ?");
        if(choice == 'R')
            db.update(ID, readRole());
        else
            db.update(ID, readSalary());
    }
    
    private void delete(){
         int ID = readID();
         db.delete(ID);
    }
    
    private void show(){        
        db.show();
    }
    
    private void group(){
        db.roleMap().forEach((k , v) -> System.out.printf("%-10s --> %-15s %n",k , v));
    }
    
    private void parition(){
        double salary = readSalary();
        db.paritionedMap(salary).forEach((k , v) -> System.out.printf("%-10s --> %-15s %n",k?"Higher":"Lower" , v));
    }
    
    private void menu() {
        char c;

        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'c': add(); break;
                case 'f': find(); break;
                case 'u': update();break;
                case 'd': delete(); break;
                case 's': show(); break;
                case 'g': group(); break;
                case 'p': parition(); break;
                default:  help(); break;
            }
        }
    }

    private void help() {
        System.out.println("c - add new employee");
        System.out.println("f - find employee/employees");
        System.out.println("u - update employees");
        System.out.println("d - delete employees");
        System.out.println("s - show employees");
        System.out.println("g - show group of employees");
        System.out.println("p - partition employees");
        System.out.println("x - exit");
    }

}
