package lab16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author George
 */
public class Counter {
    static Map<String,Integer> map = new HashMap<>();
    
    static boolean isVowel(char c){
        return "aieou".contains(""+c);
    }
    
    static int vowelCount(String s){
        return (int)s.chars().mapToObj(c -> (char)c).filter(c -> isVowel(c)).count();
    }
    
    static String readString(){
        System.out.print("String: ");
        return In.nextLine();
    }
    
    static void mapper(){       
        String s;        
        while(!(s = readString()).equals("*")){
            map.put(s, vowelCount(s));
        }
    }
    
    static void printer(){
        map.forEach((k , v) -> System.out.println(k+" -- > "+v));
    }
    
    static ScheduledExecutorService service(){
        return Executors.newSingleThreadScheduledExecutor();
    }
    
    static List<Runnable> tasks(){
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(new Thread(() -> mapper()));
        tasks.add(new Thread(() -> printer()));
        return tasks;
    }
    
    static void execute(ScheduledExecutorService ses, List<Runnable> tasks){
        int i = 1;
        for(Runnable task:tasks){
            ses.schedule(task, i, TimeUnit.SECONDS);
            i+= 5;
        }
        ses.shutdown();
    }
    
    public static void main(String[] args) {
        List<Runnable> tasks = tasks();
        ScheduledExecutorService ses = service();
        execute(ses, tasks);
    }
    
}
