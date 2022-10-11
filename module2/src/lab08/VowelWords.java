package lab08;


public class VowelWords{
    public static void main(String[] args){
        VowelWords v = new VowelWords();
        v.show();
    }
    
    //Goal 1: show the words with vowels in a sentence
    private void show(){
        String s = readString();
        
        while(!s.equals("*")){
            System.out.println("Number of words with vowels = "+countWords(s));
            s = readString();
        }
        System.out.println("Done");
    }
    
    private String readString(){
        System.out.print("Sentence: ");
        return In.nextLine();
    }
    
    //Goal 2: count the words with vowels in a sentence
    private int countWords(String sentence){
        int count = 0;
        String words[] = sentence.toLowerCase().trim().split(" +");
        for(String word:words){
            if(vowelWord(word)){
                count++;
            }
        }
        return count;
    }
    
    //Goal 3: check if a word has a vowel
    private boolean vowelWord(String word){
        for(int i=0; i < word.length(); i++){
            if(isVowel(word.charAt(i)))
                return true;
        }
        return false;
    }
    
    //Goal 4: check if a character is a vowel
    private boolean isVowel(char c){
        return "aieou".contains(""+c);
    }
}
