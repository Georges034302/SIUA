
public class Product{
    private String type;
    private double price;
    private int quantity;
    
    public Product(String type, double price, int quantity){
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Product(){
        this.type = readType();
        this.price = readPrice();
        this.quantity = readQuantity();
    }
    
    private String readType(){
        System.out.print("Type: ");
        return In.nextLine();
    }
    
    private double readPrice(){
        System.out.print("Price: ");
        return In.nextDouble();
    }
    
    public int readQuantity(){
        System.out.print("Quantity: ");
        return In.nextInt();
    }
    
    private boolean isEmpty(){
        return this.quantity == 0; //stock level
    }
    
    public boolean has(int quantity){
        return this.quantity >= quantity; //only make a sale if you have enough stock
    }
    
    //function that returns a value also execute an action
    public double sold(int quantity){
        this.quantity -= quantity; //reduce the stock
        return price*quantity;//cash
    }
    
    //function that returns a value also execute an action
    public double stocked(int quantity){
        this.quantity += quantity; //increase the stock
        return price*quantity;//cash
    }
    
    public double cash(int quantity){
        return price*quantity;
    }
    
    @Override
    public String toString(){
        String formatted = String.format("%.2f",this.price);
        String output = this.type;
        output += (this.quantity > 0) ? 
                " level: "+this.quantity+" at price $"+formatted : 
                " stock level: "+this.quantity;
        return output;
    }
}






