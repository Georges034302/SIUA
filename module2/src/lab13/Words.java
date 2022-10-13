package lab13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 *
 * @author George
 */
public class Words {
    private List<String> words = new ArrayList<>();
    
    private char character(){
        Random r = new Random();
        char A = 'A';
        char Z = 'Z';
        
        return (char)(A + r.nextInt(Z - A + 1));        
    }

    private String word(int length){
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < length; i++) {
            sb.append(character());
        }
        return sb.toString();
    }
    
    private void populate(){
        Random r = new Random();        
        int size = (r.nextInt(10) -r.nextInt(2)) + 2;        
        for (int i = 0; i < size; i++) {
            int length = (r.nextInt(5) -r.nextInt(3)) + 3;
            this.words.add(word(length));
        }
    }
    
    private void hide(){
        List<String> hidden = new ArrayList<>();
        
        Function<String,String> replaced = s -> s.substring(0, 1);
        replaced = replaced.andThen(s -> s+"#");
        
        for(String s:words)
            hidden.add(replaced.apply(s));
        
        hidden.forEach(System.out::println);
    }
    
    private void show(){
        this.words.forEach(System.out::println);
    }
    
    private char readChoice(){
        System.out.print("Choice(g/h/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'g':populate();break;   
                case 'h':hide(); break;
                case 's':show();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("g - generate list");
        System.out.println("h - hide words");
        System.out.println("s - show list");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args) {        
        (new Words()).menu();
    }
}
