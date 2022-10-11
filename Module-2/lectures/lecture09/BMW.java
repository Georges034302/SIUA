
public class BMW extends Car{
    private int position;

    public BMW(){
        super("BMW");
    }
    
    @Override
    public void move(int distance){
        this.position += distance;
    }
}
