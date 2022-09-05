import java.util.Date;
import java.util.Calendar;
import java.time.Instant;
import java.time.Duration;

public class Timer{
    public static void main(String[] args){
        //long start = new Date().getTime();
        //long start = Calendar.getInstance().getTimeInMillis();
        //Instant start = Instant.now();
        long start = System.currentTimeMillis();
        long sum = 0;
        
        for(int i=0; i< 10000000; i++)
            sum+=i;
        System.out.println("Total = "+sum);
        
        //long end = new Date().getTime();
        //long end = Calendar.getInstance().getTimeInMillis();
        //Instant end = Instant.now();
        long end = System.currentTimeMillis();
        
        long eta = end - start;
        //long eta = Duration.between(start,end).toMillis();
        
        System.out.println("Execution time = "+eta+" ms");
    }
}
