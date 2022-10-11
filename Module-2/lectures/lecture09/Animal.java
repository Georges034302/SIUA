
public abstract class Animal implements Mammal{
    protected String type;
    protected int position;
    
    public Animal(int position){
        this.type = readType();
        this.position = position;
    }
    
    public Animal(String type, int position){
        this.type = type;
        this.position = position;
    }
    
    private String readType(){
        System.out.print("Type = ");
        return In.nextLine();
    }
    
    @Override
    public void walk(int steps){
        this.position += steps;
    }
    
    public abstract void show();
}
