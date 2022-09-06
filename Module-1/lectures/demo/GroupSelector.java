import java.util.*;
import java.util.Random;

public class GroupSelector{
    public static List<String> studentsList(){
        List<String> students = new ArrayList();
        students.add("Abdullah");
        students.add("Abdul");
        students.add("Aiman");
        students.add("Antonella");
        students.add("Fraidon");
        students.add("Mahdi");
        students.add("Izaak");
        students.add("Jahidullah");
        students.add("Logan");
        students.add("Micheal");
        students.add("Mikayla");
        students.add("Maryam");
        students.add("Muhunthan");
        students.add("Priyanka");
        students.add("Ramya");
        students.add("Rashed");
        students.add("Saman");
        students.add("Shilpa");
        students.add("Shylaja");
        students.add("Sumitra");
        students.add("Yousif");
        students.add("Zaki");
        return students;
    }

    public  static int randomIndex(List<String> students){       
        return new Random().nextInt(students.size());
    }

    public static void delete(List<String> students, int index){
        students.remove(index);
    }

    public static Map<String, String> groupMap(List<String> students){
        Map<String, String> map = new HashMap();
        List<String> deletes = new ArrayList();
        
        while(!students.isEmpty()){
            int x = randomIndex(students);
            int y = randomIndex(students);
            while(x == y) y = randomIndex(students);
            map.put(students.get(x),students.get(y));
            deletes.add(students.get(x));
            deletes.add(students.get(y));
            students.removeAll(deletes);
        }
        return map;
    }

    public static void showGroups(Map<String, String> map){
        for(Map.Entry<String, String> entry:map.entrySet()){    
            String key = entry.getKey();  
            String value = entry.getValue();  
            System.out.printf("%-10s :: %-10s%n",key,value);   
        } 
    }
    
    public static void main(String[] args){
        showGroups(groupMap(studentsList()));
    }
}



