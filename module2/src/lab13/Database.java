package lab13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author George
 */
public class Database {
    private List<User> users = new ArrayList();
    
    private void populate(){
        for (int i = 0; i < 10; i++) {
            this.users.add(new User());
        }
    }
    
//    conventional lookup function 
//    private User user(int ID){
//        for(User user:this.users)
//            if(user.match(ID))
//                return user;
//        return null;
//    }
       
    private User user(int ID){
        Function<List<User> , User> finder = list -> {
            for(User user:list)
                if(user.match(ID))
                    return user;
            return null;
        };
        return finder.apply(this.users);
    }
    
    private int readInt(String prompt) {
        System.out.print(prompt);
        return In.nextInt();
    }
    
    private void find(){
        int ID = readInt("ID: ");
        
        User user = user(ID);
        
        if(user != null)
            System.out.println(user);
        else
            System.out.println("User does not exist");
    }
    
    private void view(){
        this.users.forEach(System.out::println);
    }
    
    private void clear(){
        this.users.clear();
    }
    
    private void sort(){
        Collections.sort(users, new UserComparator());
    }
    
    private char readChoice(){
        System.out.print("Choice(p/c/f/s/v/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p':populate();break; 
                case 'c':clear();break;
                case 'f':find();break;
                case 's':sort();break;
                case 'v':view();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("p - populate");
        System.out.println("c - clear");
        System.out.println("f - find");
        System.out.println("s - sort");
        System.out.println("v - view");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args) {
        (new Database()).menu();
    }
}
