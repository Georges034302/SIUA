
public class Cat extends Animal implements Mammal{
    
    public Cat(){
        super(0);
    }

    @Override
    public void show(){
        System.out.println(this.type+" is at position "+this.position);
    }

    @Override
    public void walk(int steps){
        super.walk(100);
        this.position += 2*steps;
    }
}
