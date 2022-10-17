package lecture14;

public class Person {
    String name;
    String country;

    public Person(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    
    public boolean match(String name){
        return this.name.equalsIgnoreCase(name);
    }

    @Override
    public String toString() {
        return "{" + "name=" + name + '}';
    }    
}
