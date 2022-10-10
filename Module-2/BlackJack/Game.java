import java.util.*;

public class Game{
    private Dealer dealer;
    private List<Player> players;

    public Game(){
        this.dealer = new Dealer();
        this.players = new ArrayList();
    }

    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }

    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }

    private void register(){
        int howmany = readInt("Players joining: ");
        for(int i = 0; i < howmany; i++)
            players.add(new Player(readName()));
    }

    private void start(){
        register();
        System.out.println("Dealing first hand ...");
        for(Player player:players){
            dealer.dealTwo(player);
        }            
        dealer.takeTwo();
        show();
    }

    public void play(){   
        System.out.println("Dealing ...");
        if(dealer.playing())
            dealer.play();
        for(Player player:players){  
            if(player.playing()){
                player.play(dealer);                
            }
        }
    }

    private char readChoice(String prompt){
        System.out.print(prompt);
        return In.nextChar();
    }

    private void show(){
        dealer.showHand();
        for(Player player:players)
            player.showHand();
    }
    
    private void view(){
        System.out.println(dealer);
        for(Player player:players)
            System.out.println(player);
    }

    private void menu(){
        char c;
        while((c = readChoice("Choice(s/p/v/x): ")) != 'x'){
            switch(c){
                case 's': start(); break;
                case 'p': play();break;
                case 'v': view();break;
                default:help();break;
            }
        }
    }

    private void help(){
        System.out.println("s - start game");
        System.out.println("p - play");
        System.out.println("v - view hands");
        System.out.println("x - exit");
    }

    public static void main(String[] args){
        (new Game()).menu();
    }
}

