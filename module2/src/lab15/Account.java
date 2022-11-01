package lab15;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author George
 */
public class Account implements Serializable{
    private int ID;
    private double balance;
    
    public Account(){
        this.balance = (new Random()).doubles(0, 1000).limit(1).sum();
        this.ID = (new Random()).nextInt(999)+1;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
    
    public boolean match(int ID){
        return this.ID == ID;
    }
    
    public void deposit(double amount){
        this.balance += amount;
    }
    
    public void withdaw(double amount) throws InsufficientFunds{
        if(amount > balance)
            throw new InsufficientFunds("Insufficient funds");
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account-ID: %03d balance: $%.2f ", ID,balance);
    }   
}
