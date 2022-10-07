import java.util.*;

public class ScoreBoard{
    private Map<Integer,Game> board;

    public ScoreBoard(){
        this.board = new HashMap();
    }

    private int randomKey(){
        Random r = new Random();
        return r.nextInt(1000);
    }

    private int uniqueKey(){
        int key = randomKey();
        while(board.containsKey(key))
            key = randomKey();
        return key;
    }

    private void play(){
        int key = uniqueKey();            
        this.board.put(key, new Game());
    }
    
    private void show(){
        for(Map.Entry<Integer,Game> entry:board.entrySet()){
            int key = entry.getKey();
            Game value = entry.getValue();
            System.out.printf("%03d --> %s %n",key,value);
        }
    }
    
     private char readChoice(){
        System.out.print("Choice(p/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p':play();break;               
                case 's':show();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("p - play");
        System.out.println("s - show");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new ScoreBoard()).menu();
    }
}








