import java.util.*;
import java.util.Random;

public class Maps{
    public static HashMap<Integer, String> hashMap(){
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "Jim");
        map.put(2, "Amy");
        map.put(3, "Lyn");
        map.put(4, "Joe");
        return map;
    }

    public static TreeMap<Integer, String> treeMap(){
        TreeMap<Integer, String> map = new TreeMap();
        map.put(10, "Jim");
        map.put(2, "Amy");
        map.put(33, "Lyn");
        map.put(14, "Joe");
        return map;
    }
    
     public static Hashtable<Integer, String> hashTable(){
        Hashtable<Integer, String> map = new Hashtable();
        map.put(11, "Jim");
        map.put(2, "Amy");
        map.put(7, "Lyn");
        map.put(4, "Joe");
        return map;
    }
    
    public static void show(Map<Integer, String> map){
        System.out.println(map);
    }

    public static void showLoop(Map<Integer, String> map){
        for(Map.Entry<Integer, String> entry:map.entrySet()){    
            int key = entry.getKey();  
            String value = entry.getValue();  
            System.out.println(key+"\t"+value);   
        } 
    }
    
    public static void showEnum(Hashtable<Integer, String> map){
        Enumeration<Integer> keys = map.keys();
        while(keys.hasMoreElements()) {
         int key = keys.nextElement();
         System.out.println(key + ": " + map.get(key));
      }        
      System.out.println();
    }

    public static void main(String[] args){
        //HashMap<Integer, String> map = hashMap(); 
        //TreeMap<Integer, String> map = treeMap();
        Hashtable<Integer, String> map = hashTable();
        
        Maps.show(map);
        //System.out.println(map.hashCode());
        //Maps.showLoop(map);
        // Maps.show(map.tailMap(14));
        // Maps.show(map.headMap(14));
        // Maps.show(map.subMap(10, 33));
        //System.out.println(map.descendingKeySet());
        //NavigableMap<Integer, String> sorted = treeMap().descendingMap();
        //System.out.println(sorted);
        //map.replace(2,"Alana");
        //System.out.println(map.entrySet());
        //System.out.println(map.keySet());
        //System.out.println(map.values());
        Maps.showEnum(map);

    }
}
