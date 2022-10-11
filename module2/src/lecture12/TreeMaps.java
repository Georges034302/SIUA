package lecture12;
import java.util.*;

public class TreeMaps{
    private TreeMap<Integer,String> tree = new TreeMap(); //empty tree
    
    public TreeMaps(){}
    
    private void populateTree(){
        int size = readInt("Size = ");
        int seed = readInt("Seed = ");        
        
        for(int i=0; i<size; i++){
            int key = uniqueKey(tree,seed);            
            tree.put(key, readName());
        }
    }
    
    private int uniqueKey(TreeMap<Integer,String> tree, int seed){
        Random r = new Random();
        int key = r.nextInt(seed); //generate a key
        while(tree.containsKey(key)) //check if the key is used
             key = r.nextInt(seed); //if the key is used read again
        return key; //return a unqiue key
    }
    
    private void show(){
        for(Map.Entry<Integer,String> entry:tree.entrySet()){
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+" ---> "+value);
        }
    }
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    private String readName(){
        System.out.print("Name = ");
        return In.nextLine();
    }
    
    public static void main(String[] args){
        TreeMaps map = new TreeMaps();
        map.populateTree();        
        map.show();
        NavigableMap<Integer,String> nav = map.tree.descendingMap();
        System.out.println(nav);
        System.out.println(nav.lastEntry());
    }
}
