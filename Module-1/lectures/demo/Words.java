import java.util.LinkedList;
import java.util.Arrays;

public class Words{
    private LinkedList<String> words;
    
    public static void main(String[] args){        
        Words words = new Words();
        words.populate();
        words.show();
        String word = words.read("Find");
        System.out.print(word+" is ");
        System.out.println((words.word(word) != null) ? "Found":"Does not Exist");        
    }
    
    public Words(){  words = new LinkedList<>();  }
    
    private String read(String prompt){
        System.out.print(prompt+": ");
        return In.nextLine();
    }
    
    private void populate(){
        for(int i=0 ; i < 3; i++)
            words.add(read("Word"));
    }
    
    private String word(String other){
        for(String word: words)
            if(word.equals(other))
                return word;
        return null;
    }
    
    private void show(){
        System.out.println(Arrays.deepToString(words.toArray()));
    }    
}
