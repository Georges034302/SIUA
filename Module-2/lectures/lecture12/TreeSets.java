import java.util.*;

public class TreeSets{
    public static void main(String[] args){
        TreeSet<Integer> tree = new TreeSet();
        
        Random r = new Random();        
        for(int i=0; i<20; i++)
            tree.add(r.nextInt(10));        
        System.out.println(tree);
        
        TreeSet<Integer> tree2 = new TreeSet();       
        for(int i=0; i<20; i++)
            tree2.add(r.nextInt(10));
         System.out.println(tree2); 
       
        if(tree.containsAll(tree2))
            System.out.println("tree 2  exists inside tree");
        else
            System.out.println("tree 2 does not exist in tree");
        // //System.out.println(tree.descendingSet());
        
        // System.out.println(tree.first());
        // System.out.println(tree.last());
        // System.out.println(tree.lower(5));
        // System.out.println(tree.pollFirst());
        // System.out.println(tree);
        
        // if(tree.remove(0))
            // System.out.println("Item removed successfully");
        // else
            // System.out.println("Item does not exist");
    }
}
