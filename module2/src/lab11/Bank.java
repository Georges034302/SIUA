package lab11;
import java.util.*;

public class Bank{
    private List<Customer> customers = new ArrayList();

    public Bank(){        
    }

    private void register(){
        for(int i=0; i < 3; i++)
            this.customers.add(new Customer());
    }

    private Customer customer(String name){
        for(Customer c:customers)
            if(c.match(name))
                return c;
        return null;
    }

    private void addUnique(){
        String name = In.readString("Name: ");
        Customer c = customer(name);

        if(c != null)
            System.out.println("Customer exists");
        else{
            Customer customer = new Customer(name);
            this.customers.add(customer);
        }
    }

    private List<Customer> matches(String name){        
        List<Customer> temp = new ArrayList();
        for(Customer c:customers)
            if(c.match(name))
                temp.add(c);
        return temp;
    }

    private void delete(){
        String name = In.readString("Name: ");
        List<Customer> temp = matches(name);

        if(temp.size() > 0)
            this.customers.removeAll(temp);
        else
            System.out.println("Customer does not exist");
    }

    private void show(){
        for(Customer c:customers)
            System.out.println(c);
    }

    private char readChoice(){
        System.out.print("Bank Menu(c/r/a/d/s/x): ");
        return In.nextChar();
    }

    private void customerMenu(){
        String name = In.readString("Name: ");
        Customer c = customer(name);
        if(c != null)
            c.menu();
        else
            System.out.println("Customer "+name+" does not exist");
    }

    private void menu(){
        char c;

        while((c = readChoice()) != 'x'){
            switch(c){
                case 'c':customerMenu();break;
                case 'r': register();break;
                case 'a':addUnique();break;
                case 'd':delete(); break;
                case 's':show();break;
                default: help();break;
            }
        }
    }

    private void help(){
        System.out.println("c - go to customer menu");
        System.out.println("r - Register customers");
        System.out.println("a - add account");
        System.out.println("d - delete");    
        System.out.println("s - show all");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new Bank()).menu();
    }
}





