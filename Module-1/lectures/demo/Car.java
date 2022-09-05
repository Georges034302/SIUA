    
    public abstract class Car{
        protected String type;
        protected int position;
        
        public Car(String type, int position){
            this.type = type;
            this.position = position;
        }
        
        public abstract void move(int speed, int time);
        
        protected void show(){
            System.out.println(type+" is at position "+position);
        }
    }


