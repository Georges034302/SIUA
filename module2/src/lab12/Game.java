package lab12;
import java.util.ArrayList;
import java.util.List;
public class Game{
    private List<Player> players;

    public Game(){
        this.players = players();
    }

    private List<Player> players(){
        List<Player> temp = new ArrayList();        
        for(int i = 0; i < 5; i++)
            temp.add(new Player(i+1));
        return temp;
    }

    //The max pattern to find the higest score
    private Player winner(){
        Player winner = players.get(0); //initial max score
        for(Player p:this.players)
            if(p.match(winner))//p.score() > winner.score()
                winner = p;
        return winner;
    }

    //Find the frequency of highest scores
    private List<Player> winners(){
        List<Player> winners = new ArrayList();
        Player winner = winner();
        for(Player p:this.players)
            if(p.score() == winner.score()) //p.equal(winner)
                winners.add(p);
        return winners;
    }

    @Override
    public String toString(){
        String output = this.players+"-Winner";
        output += (winners().size() > 1) ? "s :: "+winners() : " :: "+winners();
        return output;
    }
}








