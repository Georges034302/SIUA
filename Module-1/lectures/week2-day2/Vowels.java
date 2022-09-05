import java.util.Scanner;

public class Vowels{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Character: ");
        String sentence = in.nextLine().toLowerCase();        

        while(!sentence.equals("*")){
            int count = 0;
            for(int i=0; i< sentence.length(); i++)
                if("aieou".contains(""+sentence.charAt(i)))
                    count++;
            System.out.println(sentence+" vowel count = "+count); 
            
            System.out.print("Character: ");
            sentence = in.nextLine().toLowerCase();
        }       
    }
}
