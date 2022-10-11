package lecture12;
import java.util.*;
public class Queues{
     public static void main(String[] args){
         PriorityQueue<Integer> queue = new PriorityQueue();
         PriorityQueue<String> names = new PriorityQueue();
         
         // queue.add(5);
         // queue.offer(10);
         // queue.add(3);
         // queue.offer(4);
         // queue.offer(2);
         // queue.add(2);
         //System.out.println(queue);
         
         names.add("Tom");
         names.add("Alice");
         names.add("Lin");
         names.add("Mike");  
         names.add("Adam");
         names.add("Casey");
         System.out.println(names); 
         
         Iterator itr  = names.iterator();
         while(itr.hasNext())
            System.out.println(itr.next());
            
         // System.out.println(names.poll()); //removes the item at front of the queue
         // System.out.println(names);
         // System.out.println(names.poll()); //removes the item at front of the queue
         // System.out.println(names);
         // System.out.println(names.poll()); //removes the item at front of the queue
         // System.out.println(names);
         // System.out.println(names.poll()); //removes the item at front of the queue
         // System.out.println(names);
     }
}
