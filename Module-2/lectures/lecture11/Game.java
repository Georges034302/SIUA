import java.util.*;

public class Game{
    private List<Player> players;

    public Game(){
        play();
    }

    private void play(){
        this.players = players();
    }

    private List<Player> players(){
        int number = readInt("Number of players = ");

        List<Player> temp = new ArrayList();

        for(int i = 0; i < number; i++)
            temp.add(new Player("Player-"+(i+1)));

        return temp;
    }

    private int readInt(String prompt){
        System.out.print(prompt);
        return (int)In.nextDouble();
    }

    //the lookup function using the any pattern
    private Player player(String name){
        for(Player p: players)
            if(p.matches(name))
                return p;
        return null;        
    }

    //the updated look up function that returns all matches
    private List<Player> findAll(int first, int second){
        List<Player> temp = new ArrayList();
        for(Player p:players)
            if(p.matchScore(first, second))
                temp.add(p);
        return temp;
    }

    private void find(){
        String name = readName();
        Player p = player(name);
        if(p != null)
            System.out.println(p);
        else
            System.out.println("player does not exist");
    }

    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }

    //this method prints any paramter list
    private void show(List<Player> list){
        for(Player p: list)
            System.out.println(p);
    }

    private void view(){
        show(players);
    }

    private void search(){
        int first = readInt("First = ");
        int second = readInt("Second = ");        
        List<Player> temp = findAll(first,second);

        if(!temp.isEmpty()){
            show(temp);
        }else{
            System.out.println("no match");
        }
    }

    private char readChoice(){
        System.out.print("Choice(p/f/s/v/x): ");
        return In.nextChar();
    }

    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p': play(); break;
                case 'f': find(); break;
                case 's': search(); break;
                case 'v': view(); break;
                default: help(); break;
            }
        }        
    }

    private void help(){
        System.out.println("p - play");
        System.out.println("f - find");
        System.out.println("s - search");
        System.out.println("v - view");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new Game()).menu();
    }
}





