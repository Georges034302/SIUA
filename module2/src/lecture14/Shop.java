package lecture14;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Shop {
    private List<Product> products;
    
    public Shop(){
        this.products = products();
    }
    
    private List<Product> products(){
        List<Product> temp = new LinkedList<>();
        
        temp.add(new Product("Chair", 42.5));
        temp.add(new Product("Table", 42.5));
        temp.add(new Product("Green Book", 22.5));
        temp.add(new Product("Blue Book", 22.5));
        temp.add(new Product("Umbrella", 42.5));
        temp.add(new Product("Blue Pen", 4.5));
        temp.add(new Product("Red Pen", 4.5));
        temp.add(new Product("Black Tape", 5.5));
        temp.add(new Product("Blue Tape", 5.5));
        temp.add(new Product("Red Tape", 4.5));
        
        return temp;
    }
    
    private void show(){
        products.forEach(Product::show);
    }
    
    private Map<Double, List<Product>> map(){
        return products.stream()
                       .collect(Collectors.groupingBy(Product::getPrice));
    }
    
    private void showMap(){
        map().forEach((k , v) -> System.out.printf("$%05.2f --> %-12s %n",k,v));
    }
    
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.show();
        shop.showMap();
    }
}
