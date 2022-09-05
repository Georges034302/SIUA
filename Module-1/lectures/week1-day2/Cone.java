import java.util.Scanner;

public class Cone{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        
        //read pattern
        System.out.print("Radius = ");
        double r = in.nextDouble();
        
        //read pattern
        System.out.print("Height = ");
        double h = in.nextDouble();
        
        double v = Math.PI*Math.pow(r, 2)*(h/3);
        
        //output pattern
        System.out.println("Cone volume = "+v);
    }
}
