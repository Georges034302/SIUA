
public abstract class Car{
    protected String type;
    
    public Car(String type){
        //super();//This is loading the Object constructor
        this.type = type;
    }
    
    public abstract void move(int distance);
    
    protected void show(){
        System.out.println(this.type);
    }
}
