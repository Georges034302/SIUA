package lab16;

import java.util.Timer;
import java.util.TimerTask;
import lab15.Utils;

/**
 *
 * @author George
 */
public class Ticker {
    static TimerTask ticker(){
        TimerTask tasker = new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println((i %2 == 0) ? Utils.GREEN_BOLD+"tick"+Utils.WHITE_BOLD : Utils.RED_BOLD+"tock"+Utils.WHITE_BOLD);
                i++;
            }
        };
        return tasker;
    }
    
    public static void main(String[] args) throws InterruptedException {
        TimerTask tasker = ticker();
        Timer timer = new Timer();
        
        timer.schedule(tasker, 0, 1000);
        
        int i = 0;
        while(true){
            Thread.sleep(1000);
            i++;
            if( i == 9 )
                System.exit(0);
        }
    }
}
