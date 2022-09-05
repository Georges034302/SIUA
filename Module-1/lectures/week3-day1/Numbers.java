import java.util.Random;
import java.util.Arrays;

public class Numbers{
    public static void main(String[] args){
        int numbers[] = new int[5];
        int sum = 0;
        Random r = new Random();
        for(int i=0; i < numbers.length; ++i){
            numbers[i] = r.nextInt(20);            
        }

        System.out.println(Arrays.toString(numbers));  
      
        for(int i=0; i < numbers.length; ++i){
            sum += numbers[i];            
        }
        
        System.out.println(sum);
    }
}
