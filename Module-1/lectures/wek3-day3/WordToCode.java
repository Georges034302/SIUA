import java.util.Scanner;
public class WordToCode{
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Temperature = ");
        double temp = in.nextDouble();
        
        double sum = 0;
        double avg = 0;
        int i = 1;
        
        while(i <=12){
            sum += temp;
            i++;
            System.out.print("Temperature = ");
            temp = in.nextDouble();
        }
        avg = sum/12;
        System.out.println("Average = "+avg);
        
    }
}
