import java.util.*;

public class Strings{
    
    public Strings(){}
    
    //step 1: read 2 strings
    private String readString(){
        System.out.print("String: ");
        return In.nextLine();
    }
    
    //step 2: join the strings
    private String merged(String s1, String s2){     
        return s1+s2;
    }
    
    //step 3: read each character
    private List<Character> characters(String s){
        List<Character> temp = new ArrayList();
        for(int i = 0; i < s.length(); i++)
            temp.add(s.charAt(i));
        return temp;
    }
    
    //step 4: add each character to TreeSet
    private TreeSet<Character> uniqueSet(List<Character> list){
        TreeSet<Character> tree = new TreeSet(list);
        return tree;
    }
    
    //step 5: count a vowel in a string
    private int frequency(char v, String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(v == s.charAt(i)){
                count++;
            }
        }
        return count;
    }
    
    //step 6: associate each vowel with its frequency
    private TreeMap<Character,Integer> frequencyMap(String s){
        TreeMap<Character,Integer> tree = new TreeMap();
        String vowels = "aieou";
        for(int i = 0; i < vowels.length(); i++)
            tree.put(vowels.charAt(i), frequency(vowels.charAt(i),s.toLowerCase()));
        return tree;
    }
    
    private void showMap(TreeMap<Character,Integer> tree){
        for(Map.Entry<Character,Integer> entry :tree.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key+"-->"+value);
        }          
    }
    
    public static void main(String[] args){
        Strings strings = new Strings();
        String s1 = strings.readString();
        String s2 = strings.readString();
        
        String merged = strings.merged(s1,s2); //s1 + s2
        System.out.println(merged);
        
        List<Character> chars = strings.characters(merged);
        System.out.println(chars);
        TreeSet<Character> tree = strings.uniqueSet(chars);
        System.out.println(tree);    
        
        TreeMap<Character,Integer> map = strings.frequencyMap(merged);
        strings.showMap(map);
    }    
}









