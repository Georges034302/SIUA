package lecture09;
public class People{
    //fields
    // private Person p1;
    // private Person p2;
    private Person[] persons;

    public People(){
        // this.p1 = new Person();
        // this.p2 = new Person(readName(),readAge());
        int size = readSize();
        this.persons = persons(size);
    }
    
    private Person[] persons(int size){
        Person [] temp = new Person[size];
        
        for(int i = 0; i < temp.length; i++){
            temp[i] = new Person(readName(),readAge());
        } 
        return temp;
    }
    
    private Person person(String name){
        for(Person p: persons)
            if(p.match(name))
                return p;
        return null;
    }
    
    private void showOne(){
        String name = readName();
        Person p = person(name);
        if(p != null)
            System.out.println(p);
        else
            System.out.println(name+" does not exist!!!");
    }
    
    private char readChoice(){
        System.out.print("Choice (s/f/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        
        while( (c = readChoice()) != 'x'){
            switch(c){
                case 's': show();break;
                case 'f': showOne();break;
                default: System.out.println("Unkown choice!");
            }
        }
    }
    
    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private int readAge(){
        System.out.print("Age: ");
        return In.nextInt();
    }
    
    private int readSize(){
        System.out.print("Size: ");
        return In.nextInt();
    }
    
    private void show(){
        // System.out.println(p1);
        // System.out.println(p2);
        for(Person p: persons)
            System.out.println(p);
    }
    
    private void update(Person person, String name, int age){
        person.setName(name);
        person.setAge(age);
    }
    
    public static void main(String[] args){
        People people = new People();
        people.menu();
        // people.show();
        // people.update(people.p1, people.readName(),people.readAge());
        // people.update(people.p2, people.readName(),people.readAge());
        // people.show();
    }
}









