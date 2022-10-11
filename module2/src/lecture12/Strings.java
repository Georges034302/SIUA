import java.util.*;

public class Strings{
    public static void main(String[] args){
        Set<String> names = new HashSet();
        
        names.add("Yousif");
        names.add("george");
        names.add("Rashed");
        names.add("Sumi");
        
        System.out.println(names);
        if(names.contains("Rashed"))
            System.out.println("Welcome");
        else
            System.out.println("Goodbye");
            
        Set<String> names2 = new HashSet(Arrays.asList("Yousif","Sumi"));
        
        if(names.containsAll(names2))
            System.out.println("Welcome");
        else
            System.out.println("Goodbye");
            
        if(names.removeAll(names2))
            System.out.println("sub set removed");
        else
            System.out.println("unsuccessful operation");
        // List<String> list = new ArrayList();
        // list.add("George");
        // list.add("Sumi");
        // list.add("Ramya");
        // list.add("Fraidon");
        
        // names.addAll(list);        
        // System.out.println(names);
        
        // List<String> list2 = new ArrayList();
        // list2.add("George");
        // list2.add("Aiman");
        // list2.add("Abdul");
        // list2.add("Rashed");
        
        // names.addAll(list2);        
        // System.out.println(names);
        
        // // for(String name:names)
            // // System.out.println(name);
            
        // Iterator<String> itr = names.iterator();
        // while(itr.hasNext())
            // System.out.print(itr.next()+" ");
        // System.out.println();
    }
}
