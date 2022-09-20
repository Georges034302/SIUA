public class Vowel{

    private String sentence;
    
    public Vowel(){}

    public Vowel(String sentence){
        this.sentence = sentence;
    }

    private String readString(){
        System.out.print("String: ");
        return In.nextLine();
    }

    //Goal 1: show the number of vowels in a string 
    private void show(){
        String s = readString();
        while(!s.equals("*")){
            System.out.println("Vowel count = "+countVowels(s));
            s = readString();
        }
        System.out.println("Done");
    }
    //Goal 2: count the number of vowel in a string 
    private int countVowels(String s){
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            if(isVowel(s.charAt(i)))
                count++;
        }
        return count;
    }

    //Goal 3: check if a character is a vowel 
    private boolean isVowel(char c){
        return "aiueoAIOUE".contains(""+c);
    }

    public static void main(String[] args){
        Vowel vowels = new Vowel();

        vowels.show();
    }
}
