package lecture09;
public class Person{
    //Fields
    private String name;
    private int age;
    
    //Default Constructor
    public Person(){}
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public boolean match(String name){
        return this.name.equals(name);
    }
    
    //Accessor
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    //Mutators
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    @Override
    public String toString(){
        return this.name+" age is "+this.age;
    }
}









