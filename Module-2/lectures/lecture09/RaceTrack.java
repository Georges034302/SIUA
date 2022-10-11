
public class RaceTrack{
    private Car [] cars;
    
    public RaceTrack(){
        this.cars = new Car[4];
        cars[0] = new BMW();
        cars[1] = new Audi();
        cars[2] = new BMW();
        cars[3] = new Audi();
    }
    
    private void show(){
        for(Car car:cars)
            car.show();
    }
    
    public static void main(){
        (new RaceTrack()).show();
    }
}
