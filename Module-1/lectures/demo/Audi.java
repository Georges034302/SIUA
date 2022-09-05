
    public class Audi extends Car {
               
        public Audi(){
            super("Audi",0);
        }
    
        public void move(int speed, int time){
            super.position += speed*time;
        }
        
        public void show(){
            move(40,10);
            super.show();
        }
    }
    
    
    
// @Override 
    // public double position(){        
        // return this.position;
    // }
    
    // @Override 
    // public void move(double distance){        
        // this.position += distance;
    // }
    
    // @Override 
    // public void show(){
        // System.out.println(this.position);
      
    // }
    
    // @Override
    // public void lights(){
        // System.out.println("LED Beams attached");
    // }