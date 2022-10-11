package lecture09;

public class Dog extends Animal implements Mammal{

    public Dog(){
        super(0);
    }
    
    @Override
    public void show(){
        System.out.println(this.type+" is at position "+this.position);
    }
    
    @Override
    public void walk(int steps){
        this.position += steps*3;
    }
}
