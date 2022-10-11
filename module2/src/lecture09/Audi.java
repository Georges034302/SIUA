package lecture09;
public class Audi extends Car implements Vehicle, ToolKit{
    private int position;
    
    public Audi(){
        super("Audi");
    }
    
    public void move(int distance){
        this.position += distance*2;
    }    
    
    public int position(){
        return this.position;
    }
    
    public void stop(){
        this.position = 0;
    }
    
    public void accelerate(){
        this.position += 100;
    }
    
    public void repair(){
        System.out.println("Repairing my Audi");
    }
}
