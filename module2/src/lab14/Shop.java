package lab14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Shop {
    public static void main(String[] args) {
        new Shop().menu();
    }
    
    private List<Product> products;
    
    public Shop(){
        this.products = new ArrayList();
    }
    
    // 1 - generate a random integer
    private int randomID(){
        return new Random().nextInt(99)+1;
    }
    
    // 2 - check if the ID is used in the list
    private boolean match(int ID){
        return products.stream().anyMatch(p -> p.match(ID));
    }
    
    // 3- generate new ID if existing
    private int uniqueID(){
        int ID = 0;        
        while(match(ID = randomID()));       
        return ID;        
    }
    
    // 4 - add 20 products
    private void add(){
        products.addAll(Stream.generate(() -> new Product(uniqueID())).limit(20).collect(Collectors.toList()));        
    }
    
    private Map<Double,List<Product>> organized(List<Product> list){
        return list.stream().collect(Collectors.groupingBy(Product::getPrice));
    }
    
    private void group(){
        Map<Double,List<Product>> map = organized(products);
        map.forEach((k , v) -> System.out.println(k+"-->"+v));
    }
    
    
    private void view(){
        Collections.sort(products, new ProductComparator());
        products.forEach(Product::show);
    }
    
    private Product product(int ID){
        return products.stream().filter(p -> p.match(ID)).findAny().orElse(null);
    }
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    private void sell(){
        int ID = readInt("ID: ");
        Product p = product(ID);
        
        if(p != null){
            int quantity = readInt("Quantity: ");
            if(p.canSell(quantity)){
                System.out.println("Selling "+quantity);
                p.sell(quantity);
            }else{
                System.out.println("Not enough stock");
            }
        }else{
            System.out.println("Product-"+ID+" does not exist");
        }
    }
    
    private List<Product> deletes(){
        return products.stream().filter(p -> p.isSold()).collect(Collectors.toList());
    }
    
    private void prune(){
        this.products.removeAll(deletes());
    }    
    
    private char readChoice(){
        System.out.print("Choice(a/g/v/s/p/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'a':add();break; 
                case 'g':group();break;
                case 'v':view();break;
                case 's':sell();break;
                case 'p':prune();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("a - add products");
        System.out.println("g - view groups");
        System.out.println("v - view products");
        System.out.println("s - sell product");
        System.out.println("p - prune");
        System.out.println("x - exit");
    }
}
