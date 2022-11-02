package lecture16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class CallableDemo implements Callable<String>{

    @Override
    public String call() throws Exception {
        String s = "Hello World";
        return new StringBuilder(s).reverse().toString();
    }
    
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallableDemo());
        
        Thread futureThread = new Thread(futureTask);
        futureThread.start();
       
        try {            
            System.out.println("Waiting for call results = "+futureTask.get());            
        } catch (InterruptedException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(CallableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
