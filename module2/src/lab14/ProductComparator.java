package lab14;

import java.util.Comparator;

/**
 *
 * @author George
 */
public class ProductComparator implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getID() - o2.getID();
    }    
}
