import java.util.*;

public class Shop{
    private List<Product> products = new ArrayList(); //create the list at the top to prevent mal-formed object exception
    private CashRegister cashRegister;

    public Shop(){
        //populate();
        this.cashRegister = new CashRegister();
    }

    private void populate(){        
        this.products.add(new Product("Dark Chocolate", 5.99, 20));
        this.products.add(new Product("White Chocolate", 6.50, 10));
        this.products.add(new Product("Classic Pepsi", 3.50, 25));
        this.products.add(new Product("Diet Pepsi", 3.50, 15));
        this.products.add(new Product("Pepsi Max", 4.00, 20));
    }

    private void clear(){
        if(!this.products.isEmpty())
            this.products.clear();
        else
            System.out.println("List already empty");
    }
    
    private Product product(String type){
        for(Product p:products)
            if(p.match(type))
                return p;
        return null;
    }

    private List<Product> products(String type){
        List<Product> temp = new ArrayList();
        for(Product p:products)
            if(p.match(type))
                temp.add(p);
        return temp;
    }

    private String readType(){
        System.out.print("Type: ");
        return In.nextLine();
    }

    private int readQuantity(){
        System.out.print("Quantity: ");
        return In.nextInt();
    }

    private double readPrice(){
        System.out.print("Price: ");
        return In.nextDouble();
    }
    
    private void sell(){
        String type = readType();
        Product p = product(type); //look up function

        if( p != null ){//we found a product
            //if product exists then sell
            int quantity = readQuantity();//quantity entered by user
            if(p.has(quantity)){ //compare it to the object quantity
                double cash = p.sold(quantity);
                cashRegister.gain(cash);
            }else{
                System.out.println("Not enough stock");
            }
        }else{//product is not found
            //if product does not exist add a new product to the list
            System.out.println("Adding new product "+type);
            Product product = new Product(type,readPrice(),readQuantity());
            this.products.add(product);
        }
    }

    private void restock(){
        String type = readType();
        Product p = product(type); //look up function
        
        if( p != null ){//we found a product
            //if product exists then sell
            int quantity = readQuantity();//quantity of restocking entered by user
            double cash = p.cash(quantity); //calculate how much the restocking cost
            
            if(cashRegister.has(cash)){ //check with the cash register if we have enough cash
                cash = p.stocked(quantity); //calculate the cash used to restock and add quantity purchased to the current stock level
                cashRegister.pay(cash); //pay for the stock which reduces the cash level
            }else{
                System.out.println("Insufficient funds");
            }
        }else{//product is not found
            //if product does not exist add a new product to the list
            System.out.println("Adding new product "+type);
            Product product = new Product(type,readPrice(),readQuantity());
            this.products.add(product);
        }        
    }
    
    //returns a list of products with zero quantity
    private List<Product> zeroStock(){
        List<Product> temp = new ArrayList();
        for(Product p:products)
            if(p.isEmpty())
                temp.add(p);
        return temp;
    }

    //prune products
    private void prune(){
        this.products.removeAll(zeroStock());
    }
    
    private void view(){
        for(Product p:products)
            System.out.println(p);
        System.out.println(cashRegister);
    }

    private char readChoice(){
        System.out.print("Choice(b/c/s/r/p/v/x): ");
        return In.nextChar();
    }

    private void menu(){
        char c;

        while((c = readChoice()) != 'x'){
            switch(c){
                case 'b':populate();break;
                case 'c':clear();break;
                case 's':sell();break;
                case 'r':restock(); break;
                case 'p':prune();break;
                case 'v':view();break;
                default: help();break;
            }
        }
    }

    private void help(){
        System.out.println("b - build");
        System.out.println("c - clear");
        System.out.println("s - sell");
        System.out.println("r - restock");
        System.out.println("p - prune"); 
        System.out.println("v - view");
        System.out.println("x - exit");
    }

    public static void main(String[] args){
        (new Shop()).menu();
    }
}

