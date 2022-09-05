import java.util.Scanner;

public class InputDemo{
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        //read pattern
        System.out.print("radius = ");
        int radius = input.nextInt();
        
        double area = Math.PI*Math.pow(Math.abs(radius),2);
        area += 100;  //area = area + 100;
        String result = "Area = "+area;
        
        System.out.println(result);
    }
}
