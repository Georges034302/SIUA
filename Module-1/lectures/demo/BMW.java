    public class BMW extends Car {
               
        public BMW(){
            super("BMW",0);
        }
    
        public void move(int speed, int time){
            super.position += speed*time + 10;
        }
        
        public void show(){
            System.out.println(super.type+" is accelarating ...");
            move(50,10);
            super.show();
        }
    }
    
    