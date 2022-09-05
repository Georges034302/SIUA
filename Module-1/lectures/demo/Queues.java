
import java.util.*;

public class Queues{

    public static PriorityQueue<Integer> pQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(2);
        queue.add(5);
        queue.offer(1);
        queue.offer(2);
        return queue;
    }

    public static void show(PriorityQueue<Integer> queue){
        System.out.println(queue);
    }

    public static void showLoop(PriorityQueue<Integer> queue){
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void showEnum(PriorityQueue<Integer> queue){

    }

    public static void main(String[] args){
        //HashMap<Integer, String> map = hashMap(); 
        //TreeMap<Integer, String> map = treeMap();
        PriorityQueue<Integer> queue = pQueue();

        //Queues.show(queue);
        Queues.showLoop(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        Queues.show(queue);
        System.out.println(queue.remove(2));
        Queues.show(queue);
        //System.out.println(map.hashCode());
        //Maps.showLoop(map);
        // Maps.show(map.tailMap(14));
        // Maps.show(map.headMap(14));
        // Maps.show(map.subMap(10, 33));
        //System.out.println(map.descendingKeySet());
        //NavigableMap<Integer, String> sorted = treeMap().descendingMap();
        //System.out.println(sorted);
        //map.replace(2,"Alana");
        //System.out.println(map.entrySet());
        //System.out.println(map.keySet());
        //System.out.println(map.values());

    }
}
