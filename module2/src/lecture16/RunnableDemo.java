/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author George
 */
public class RunnableDemo {
     private int sum(List<Integer> list) {
        return list.stream().reduce(0, (x, y) -> x + y);
    }

    private void show(List<Integer> list) {
        list.forEach(System.out::println);
    }

    private int max(List<Integer> list) {
        return Collections.max(list);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 8, 3, 4, 6));
        RunnableDemo demo = new RunnableDemo();

        Runnable sumRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Sum = " + demo.sum(numbers));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Thread was interupted prematurely");
                }
                System.out.println ("Thank you");
            }            
        };
        Thread sumThread = new Thread(sumRunnable);
        sumThread.start();        
        
       
        Runnable maxRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Max = " + demo.max(numbers)); 
            }
        };
        Thread maxThread = new Thread(maxRunnable, "Max Thread");
        maxThread.start();
        System.out.println(maxThread.getName()+" --> "+maxThread.getState());
        
        Runnable showRunnable = () -> demo.show(numbers);
        Thread showThread = new Thread(showRunnable);
        showThread.start();

    }
}
