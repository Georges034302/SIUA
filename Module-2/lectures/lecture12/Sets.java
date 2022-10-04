import java.util.*;

public class Sets{
    private Set<Integer> unique = new HashSet();
    private List<Integer> numbers = new ArrayList();
    
    public Sets(){}
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    private void populateList(){
        int size = readInt("Size = ");
        int seed = readInt("Seed = ");
        Random r = new Random();
        
        for(int i=0 ; i < size; i++)
            numbers.add(r.nextInt(seed));
    }
    
    private void populateSet(){
        unique.addAll(numbers);
    }
    
    private void show(Collection<Integer> collection){
        System.out.println(collection);
    }
    
    public static void main(String[] args){
        Sets sets = new Sets();
        sets.populateList();
        sets.show(sets.numbers);
        sets.populateSet();
        sets.show(sets.unique);
    }
}




