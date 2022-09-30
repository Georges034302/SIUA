
public class Account{
    private String type;
    private double balance;
    
    public Account(){
        this.type = In.readString("Type: ");
        this.balance = readBalance();
    }
    
    public Account(String type){
        this.type = type;
        this.balance = readBalance();
    }
    
    // private String readType(){
        // System.out.print("Type: ");
        // return In.nextLine();
    // }
    
    public boolean match(String type){
        return this.type.toLowerCase().equals(type.toLowerCase().trim());
    }
    
    private double readBalance(){
        System.out.print("Balance: ");
        return In.nextDouble();
    }
    
    @Override
    public String toString(){
        return String.format("%-8s has $%.2f", this.type,this.balance);
    }
}










