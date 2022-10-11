import java.util.Random;
public class Player{
    private String name;
    private int score;
    private double rating;
    
    public Player(String name){
        this.name = name;
        this.score = randomInt();
        this.rating = rating();
    }
    
    private int randomInt(){
        Random r = new Random();
        return r.nextInt(101);
    }
    
    private double rating(){
        return this.score/20.0;
    }
    
    public boolean matches(String name){
        return this.name.equals(name);
    }
    
    public boolean matchScore(int first, int second){
        return this.score >= first && this.score <= second;
    }
    
    @Override
    public String toString(){
        return String.format(this.name+" score: "+this.score+" and rating: %.2f", this.rating);
    }
}






