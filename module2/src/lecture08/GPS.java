package lecture08;


import lecture08.In;


public class GPS{
   public static void main(String[] args){
       int x = In.readInt("x = ");
       int y = In.readInt("y = ");
       int t = 0;
       int time = 0;
       while((t = In.readInt("t = ")) != -1){
           time += t;
           System.out.printf("Distance after %2d minutes is: %.3f %n",time, distance(x,y,time));
       }
   }
   
   public static double distance(int x, int y, int t){
       int X = x + t;
       int Y = t * x;
       
       return Math.sqrt(Math.pow(X-x,2) + Math.pow(Y-y,2));
   }
}
