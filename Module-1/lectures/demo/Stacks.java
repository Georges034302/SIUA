
import java.util.*;

public class Stacks{

    public static Stack<Integer> stack(){
        Stack<Integer> stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        return stack;
    }

    public static void show(Stack<Integer> stack){
        System.out.println(stack);
    }

    public static void showLoop(Stack<Integer> stack){
        Iterator iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        Stack<Integer> stack = stack();
        showLoop(stack);
        Stacks.show(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.get(0));
        Stacks.show(stack);    

    }
}
