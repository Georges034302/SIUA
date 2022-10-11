package lecture08;


/**
 * Read in a sentence until *
 * show the total number of words starting with uppercase in each sentence
 */
public class Words{
    //Goal 1: show the number of words starting with uppercase in each sentence
    public static void main(String[] args){
        String s = In.readString("Sentence: ");
        
        Words w = new Words();
        
        while(!s.equals("*")){
            System.out.println("Upper case word count = "+w.countUpper(s.trim()));
            s = In.readString("Sentence: ");
        }
    }

    //Goal 2: count the number of words starting with uppercase in a sentence
    private int countUpper(String sentence){
        int count = 0;
        String[] words = sentence.split(" +");
        
        for(String word:words){
            if(wordStartsWithUpper(word))
                count++;
        }
        return count;
    }

    //Goal 3: check if a word starts with uppercase
    private boolean wordStartsWithUpper(String word){
        return isUpper(word.charAt(0));
    }
    
    //Goal 4: check if a charater is uppercase
    private boolean isUpper(char c){
        return Character.isUpperCase(c);
    }
}
