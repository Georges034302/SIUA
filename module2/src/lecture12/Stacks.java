package lecture12;

import java.util.*;

public class Stacks{
    public static void main(String[] args){
        Stack<Integer> stack = new Stack();
        
        stack.push(8);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(3);
        
        System.out.println(stack);
        // System.out.println(stack.remove(2));
        // System.out.println(stack);
        // System.out.println(stack.get(4));
        Iterator itr = stack.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
            
        for(int i = 0; i < stack.size(); i++)
            System.out.println(stack.get(i));
    }
}
