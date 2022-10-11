package lecture12;
import java.util.*;

public class Numbers{
    private List<Integer> numbers = new ArrayList();
    private TreeSet<Integer> tree = new TreeSet();
    
    public Numbers(){}
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    //adding the list numbers to a TreeSet will get only 
    //the unique numbers and sort them in ascending order
    private void sortUnique(){
        tree.addAll(numbers);
    }
    
    private void populateList(){
        int size = readInt("Size = ");
        int seed = readInt("Seed = ");
        
        Random r = new Random();
        
        for(int i = 0 ; i < size; i++)
            numbers.add(r.nextInt(seed));
    }
    
    private int binarySearch(TreeSet<Integer> tree, int target){
        // int pos = -1;
        // int first = 0;
        // int last = tree.size();
        
        List<Integer> temp = new ArrayList(tree);
        
        // while(first <= last){
            // pos = (first+last)/2;
            // if(target == temp.get(pos))
                // return pos;
            // else if(target < temp.get(pos))
                // last = pos - 1;
            // else
                // first = pos + 1;
        // }        
        return Collections.binarySearch(temp, target);
    }
    
    private void search(){
        int target = readInt("Target = ");
        
        while(target != -1){
            int pos = binarySearch(tree,target);
            if( pos >= 0)
                System.out.println(target+" is at position: "+pos);
            else
                System.out.println(target+" target does not exist!");
            target = readInt("Target = ");
        }
    }
    
    private void showList(){
        System.out.println(numbers);
    }
    
    private void showUnique(){
        System.out.println(tree);
    }
    
    private char readChoice(){
        System.out.print("Choice(p/s/u/v/f/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p': populateList(); break;
                case 's': showList(); break;
                case 'u': sortUnique(); break;
                case 'v': showUnique();break;
                case 'f': search();break;
                default: help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("p - populate list");
        System.out.println("s - show list");
        System.out.println("u - Collect and sort");
        System.out.println("v - view unique sorted data");
        System.out.println("f - find");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new Numbers()).menu();
    }
}








