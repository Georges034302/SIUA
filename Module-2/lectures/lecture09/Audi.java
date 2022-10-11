
public class Audi extends Car implements Vehicle, ToolKit{
    private int position;
    
    public Audi(){
        super("Audi");
    }
    
    @Override
    public void move(int distance){
        this.position += distance*2;
    }    
    
    @Override
    public int position(){
        return this.position;
    }
    
    @Override
    public void stop(){
        this.position = 0;
    }
    
    @Override
    public void accelerate(){
        this.position += 100;
    }
    
    @Override 
    public void repair(){
        System.out.println("Repairing my Audi");
    }
}
