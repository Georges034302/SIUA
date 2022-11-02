package lecture16;

/**
 *
 * @author George
 */
public class Car {
    private int pos;
    
    private synchronized void move(int distance){
        System.out.println("Moving by "+distance+" meters");
        pos =+ distance;
        this.notifyAll();
    }
    
    private synchronized void show(){
        System.out.println("Car position --> "+pos);
    }
    
    public static void main(String[] args) {
        Car c = new Car();
        
        Thread move = new Thread(() -> c.move(10));
        Thread show = new Thread(c::show);
        move.start();
        show.start();
    }
        
}
