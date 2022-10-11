package lab11;
import java.util.*;

public class Customer{
    private String name;
    private List<Account> accounts = new ArrayList();

    public Customer(){
        this.name = In.readString("Name: ");
    }

    public Customer(String name){
        this.name = name;
    }
    
    // private String readName(){
    // System.out.print("Name: ");
    // return In.nextLine();
    // }

    public boolean match(String name){
        return this.name.equals(name.trim());
    }

    //only add an account if the type does not exist
    private void addUnique(String type){
        Account a = account(type);
        if(a != null)
            System.out.println(type+" already exists");
        else{
            Account account = new Account(type);
            this.accounts.add(account);
        }
    }

    private void add(){
        String type = In.readString("Type: ");
        addUnique(type);
    }
    
    //look up function that uses the any pattern
    private Account account(String type){
        for(Account a:accounts)
            if(a.match(type))
                return a;
        return null;
    }

    // private String readType(){
    // System.out.print("Type: ");
    // return In.nextLine();
    // }

    //updated look up pattern to find all matches
    private List<Account> matches(String type ){
        List<Account> temp = new ArrayList();

        for(Account a:accounts)
            if(a.match(type))
                temp.add(a);
        return temp;
    }

    private void remove(){
        String type = In.readString("Type: ");
        List<Account> temp = matches(type);
        accounts.removeAll(temp);
    }

    private void show(){
        for(Account a:accounts)
            System.out.println(a);
    }

    private char readChoice(){
        System.out.print("Customer Menu(A/D/S/X): ");
        return In.nextChar();
    }

    public void menu(){
        char c;
        while((c = readChoice()) != 'X'){
            switch(c){
                case 'A':add();break;
                case 'D':remove();break;
                case 'S':show();break;
                default: help();break;
            }
        }
    }
    
    private  void help(){
        System.out.println("A - Add Account");
        System.out.println("D - Delete Account");
        System.out.println("S - Show Accounts");
        System.out.println("X - exit");
    }

    @Override
    public String toString(){
        return this.name+" has "+this.accounts;
    }
}






