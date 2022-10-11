package lecture12;
import java.util.*;

public class Maps{
    private Map<Integer,Integer> frequencies = new HashMap();
    private List<Integer> numbers = new ArrayList();
    
    //this is how you associate a collection with a key
    //map a collection into a Map<k,v> where v = collection
    private Map<Integer,List<Integer>> map = new HashMap();
    
    public Maps(){}
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    //generate random values with seed and size from user input
    private void populateList(){
        int size = readInt("Size = ");
        int seed = 10;// readInt("Seed = ");
        Random r = new Random();
        
        for(int i=0 ; i < size; i++)
            numbers.add(r.nextInt(seed));
    }
    
    //populate a map with List<Integer> values
    private void populateMap(){
        map.put(6, numbers);
    }
    
    
    //count the occurence of target in a list
    private int frequency(List<Integer> list, int target){
        int count = 0;
        for(Integer e:list)
            if(e == target)
                count++;
        return count;
    }
    
    //put each digit to its occurence(frequency) in the map
    private void mapFrequencies(){
        for(int i = 0; i < 10; i++){
            frequencies.put(i, frequency(numbers,i));
        }
    }
    
    private void showMap(){
        for(Map.Entry<Integer,Integer> entry:frequencies.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key+" --> "+value);
        }
        // Set<Integer> keys = frequencies.keySet();
        // for(Integer key:keys)
            // System.out.println(key+" --> "+frequencies.get(key));
    }
    
    public static void main(String [] args){
        Maps maps = new Maps();
        maps.populateList();
        System.out.println(maps.numbers);
        maps.mapFrequencies();
        maps.showMap();
        System.out.println(maps.frequencies);
    }
}
