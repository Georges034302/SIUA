

public class Customer{
    //fields
    private String name;
    private double balance;
    
    public Customer(){   }
    
    public Customer(String name, double balance){  
        this();
        this.name = name;
        this.balance = balance;
    }
    
    public Customer(String name){  
        this.name = name;
        this.balance = readBalance();
    }
    
    public Customer(double balance){  
        this.name = readName();
        this.balance = balance;
    }
    
    public void deposit(double money){
        this.balance += money;
    }
    
    public boolean match(Customer another){
        return this.name.equals(another.name);
    }
    
    //Accessor
    public String getName(){
        return this.name;
    }
    
    //Accessor
    public double getBalance(){
        return this.balance;
    }
    
    //Mutator
    public void setName(String name){
        this.name = name;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void update(String name, double balance){
        setName(name);          // this.name = name; 
        setBalance(balance);    // this.balance = balance; 
    }
    
    public double readBalance(){
        System.out.print("Balance = ");
        return In.nextDouble();
    }
    
    public String readName(){
        System.out.print("Name = ");
        return In.nextLine();
    }   
    
    @Override
    public String toString(){
        return this.name+" has $"+this.balance;
    }
       
}


