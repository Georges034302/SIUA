import java.util.*;

public class HashTables{
    public static void main(String[] args){
        Hashtable<Integer,String> table = new Hashtable();

        table.put(1, "Lin");
        table.put(2, "Alex");
        table.put(2, "Lucy"); //update
        table.put(9, "Linda");
        System.out.println(table);
                
        if(table.containsKey(2))
            System.out.println(table.get(2));
        else
            System.out.println(2+" is not associated with any value");
    }
}
