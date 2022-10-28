package lecture15;

import java.io.Serializable;

/**
 *
 * @author George
 */
public class Product implements Serializable{
    private String type;
    private int stock;
    private double price;

    public Product(String type, int stock, double price) {
        this.type = type;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return type + "-stock: " + stock + " price $" + price ;
    }    
}
