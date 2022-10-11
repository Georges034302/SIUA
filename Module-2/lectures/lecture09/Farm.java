
public class Farm{
    private Animal[] animals;
    
    public Farm(){
        this.animals = new Animal[4];
        populate();
    }
    
    private void populate(){
        animals[0] = new Dog();
        animals[1] = new Dog();
        animals[2] = new Cat();
        animals[3] = new Cat();
    }
    
    private void walk(){
        System.out.println("Walking the animals ...");
        for(Animal animal:animals)
            animal.walk(2);
    }
    
    private void show(){
        for(Animal animal:animals)
            animal.show();
    }
    
    private char readChoice(){
        System.out.print("Choice(w/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'w': walk();break;
                case 's': show();break;
                default: help(); break;
            }
        }
        System.out.println("Goodbye!");
    }
    
    private void help(){
        System.out.println("w - walk");
        System.out.println("s - show");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new Farm()).menu();
    }
}













