
/**
 * Create and show a random array of variable size (variable seed)
 * calculate and show:
 * min
 * max
 * sum
 * avg
 * odd-count
 */
import java.util.Arrays;

public class Maths{
    
    public static void main(String[] args){
        int size = In.readInt("Size = ");
        int seed = In.readInt("Seed = ");
        
        int x[] = randomArray(size,seed);
        
        System.out.println(Arrays.toString(x));
        
        System.out.println("Min = "+min(x)+" \n"+
                            "Max = "+max(x)+" \n"+
                            "Sum = "+sum(x)+" \n"+
                            "Avg = "+average(x)+" \n"+
                            "Odd Count = "+oddCount(x)+"\n");
    }
    
    public static int[] randomArray(int size, int seed){
        int x[] = new int[size];
        for(int i=0; i < x.length; i++)
            x[i] = Randomizer.randomInt(seed);
        return x;
    }
    
    public static int min(int[] x){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < x.length; i++){
            if(min > x[i])
                min = x[i];
        }
        return min;
    }
    
    public static int max(int[] x){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < x.length; i++){
            if(max < x[i])
                max = x[i];
        }
        return max;
    }
    
    public static int sum(int[] x){
        int sum = 0;
        for(int i = 0 ; i < x.length; i++){
            sum += x[i];
        }
        return sum;
    }
    
    public static double average(int[] x){
        return (double)sum(x)/x.length;
    }
    
    public static int oddCount(int[] x){
        int count = 0;
        for(int i = 0 ; i < x.length; i++){
            if(x[i]%2 != 0)
                count++;
        }
        return count;
    }
}
