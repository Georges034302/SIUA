
public class Bank{
    //Fields
    private Customer rashed;
    private Customer aiman;
    private Customer yousif;
    private Customer customer;
    private Customer[] customers;
     
    public Bank(){
        rashed = new Customer("Rashed",2000);        
        aiman = new Customer("Aiman",1000);
        yousif = new Customer("Yousif",5000);
        customer = new Customer();
    }
    
    private void deposit(){
        rashed.deposit(2000);
        aiman.deposit(500);
        yousif.deposit(1000);
    }
    
    private boolean match(Customer another){
        return rashed.match(another);
    }
   
    private void show(){
        System.out.println(rashed.getName());
        System.out.println(aiman.getName());
        System.out.println(yousif);
        System.out.println(customer);
    }
    
    private void updateNames(){
        rashed.setName("Elvis");
        aiman.setName("Carla");
        yousif.setName("James");
    }
    
    private void update(){
        rashed.update(rashed.readName(), rashed.readBalance());
        aiman.update(aiman.readName(), aiman.readBalance());
        yousif.update(yousif.readName(), yousif.readBalance());
    }
    
    private char readChoice(){
        System.out.print("Choice(d/s/u/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'd': deposit();break;
                case 's': show(); break;
                case 'u': update(); break;
                default: System.out.println("Unknown Choice");
            }            
        }
    }
    
    public static void main(String[] args){
        new Bank().menu();
    }
}
