import java.util.Scanner;
public class Cylinder{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        
        //read pattern
        System.out.print("Radius = ");
        double r = in.nextDouble();
        
        //read pattern
        System.out.print("Height = ");
        double h = in.nextDouble();
        
        double v = Math.PI*Math.pow(r, 2)*h;
        
        //output pattern
        System.out.println("Cylinder volume = "+v);
    }
}
