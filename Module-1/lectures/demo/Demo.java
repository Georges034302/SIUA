
import java.util.*; 
// Scanner in = new Scanner(System.in);
        // System.out.print("String: ");
        //String s = in.nextLine();
public class Demo{    

    public static void main(String[] args){        
        long startTime = new Date().getTime();
        long sum = 0;
        for(int i = 0; i < 10000000; i++){
            sum += i;
        }  
        
        System.out.println("Total = "+sum);
        long endTime = new Date().getTime();
        long time = endTime - startTime;
        System.out.println("Execution time: " + time +"ms");
    }
}
