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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class ThreadDemo {
    private int sum(List<Integer> list) {
        return list.stream().reduce(0, (x, y) -> x + y);
    }

    private void show(List<Integer> list) throws InterruptedException {
        list.forEach(System.out::println);
    }

    private int max(List<Integer> list) throws InterruptedException {
        return Collections.max(list);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 8, 3, 4, 6));
        ThreadDemo demo = new ThreadDemo();

        Thread sumThread = new Thread("Sum Thread") {
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
        sumThread.start();  
        //sumThread.interrupt(); //terminating the thread during sleep

        Thread maxThread = new Thread(() -> {
            try {                  
                System.out.println("Max = " + demo.max(numbers));
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        );
        maxThread.start();

        Thread showThread = new Thread(() -> {
            try {
                demo.show(numbers);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        showThread.start();
    }
}
