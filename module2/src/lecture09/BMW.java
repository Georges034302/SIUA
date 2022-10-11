package lecture09;
public class BMW extends Car{
    private int position;

    public BMW(){
        super("BMW");
    }
    
    public void move(int distance){
        this.position += distance;
    }
}
