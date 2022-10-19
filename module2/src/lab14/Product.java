package lab14;

import java.util.Random;

/**
 *
 * @author George
 */
public class Product {
    private int ID;
    private String type;
    private int stock;
    private int price;
    
    public Product(int ID){
        this.ID = ID;
        this.type = String.format("Product-%03d", ID);
        this.stock = (new Random()).nextInt(16)+5;
        this.price = (new Random()).nextInt(21)+10;
    }
    
    public boolean match(int ID){
        return this.ID == ID;
    }
    
    public double getPrice(){
        return this.price;
    }

    public int getID() {
        return ID;
    }   
    
    public void sell(int quantity){
        this.stock -= quantity;
    }
    
    public boolean canSell(int quantity){
        return this.stock >= quantity;
    }
    
    public boolean isSold(){
        return this.stock == 0;
    }

    @Override
    public String toString() {
        return this.type;
    }
    
    public void show(){
        System.out.printf(this+" stock: %02d and price $%.2f %n",stock,(double)price);
    }
}
