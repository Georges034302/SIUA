
    public class RaceTrack {
        private Car[] cars;
        
        public RaceTrack(){
            cars = new Car[2];
            cars[0] = new BMW();
            cars[1] = new Audi();
        }
        
        public static void show(Car c){
            c.show();
        }
        
        public static void main(){
            BMW bmw = new BMW();
            Audi audi = new Audi();
            
            show(bmw);
            show(audi);            
        }
    }

    