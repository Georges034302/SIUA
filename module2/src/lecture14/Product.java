package lecture14;

/**
 *
 * @author George
 */
public class Product {
    private String type;
    private double price;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }

    public String getType() {
        return type;
    }
    
    public void show(){
        System.out.printf(this+ " price $%05.2f %n",price); 
    }
    
    @Override
    public String toString(){
        return String.format("%-10s", type);
    }
    
    
}
