import lab08.In;
import java.util.*;

public class GroupSelector{
    private List<String> students = new ArrayList();

    public GroupSelector(){}

    private List<String> students(){
        List<String> students = new ArrayList();
        students.add("Abdullah");
        students.add("Abdul");
        students.add("Aiman"); 
        students.add("Antonella"); 
        students.add("Fraidon");
        students.add("Mahdi");
        students.add("Micheal");
        //students.add("Mikayla");
        students.add("Maryam");  
        //students.add("Muhunthan"); 
        students.add("Priyanka");
        students.add("Ramya");
        students.add("Rashed");
        students.add("Shilpa");
        students.add("Shylaja");
        students.add("Sumitra");
        students.add("Yousif");
        students.add("Zaki");
        return students;
    }

    private void populate(){
        this.students = students();
    }

    //lookup function
    private String student(String name){
        for(String s:students)
            if(s.equals(name))
                return name;
        return null;
    }

    private String readName(){
        System.out.print("Name: ");
        return In.nextLine();
    }

    //add unique
    private void add(){
        String name = readName();
        String s = student(name);
        if(s != null)
            System.out.println(name+" exists - try again");
        else
            this.students.add(name);
    }

    private void delete(){
        List<String> deletes = matches();
        if(!deletes.isEmpty())
            students.removeAll(deletes);
        else
            System.out.println("Nothing to delete");
    }

    //updated lookup function
    private List<String> matches(){
        String name = readName();        
        List<String> temp = new ArrayList();
        for(String s:students)
            if(s.equals(name))
                temp.add(s);
        return temp;
    }

    //display the list
    private void view(){
        //System.out.println(students);
        for(String s:students)
            System.out.println(s);
    }

    //returns a random value between 0 and size-1
    private int randomIndex(List<String> list){
        int size = list.size();
        return (new Random()).nextInt(size);
    }

    private Map<String,String> groupMap(List<String> list){
        Map<String,String> map = new HashMap();
        List<String> temp = new ArrayList(list);
        List<String> removals = new ArrayList();
        while(!temp.isEmpty()){
            int x = randomIndex(temp);
            int y = randomIndex(temp);
            while (x == y) //check if indexes are the same
                y = randomIndex(temp); //generate a new y until it is different to x

            map.put(temp.get(x),temp.get(y)); //pair two names    
            removals.add(temp.get(x));
            removals.add(temp.get(y));
            temp.removeAll(removals);
            removals.clear();
        }
        return map;
    }
    
    private void showMap(Map<String,String> map){
        int i = 1;
        for(Map.Entry<String,String> entry:map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("Room_%02d --> %-10s :: %-10s %n",i,key,value);
            i++;
        }
    }
    
    private void show(){
        showMap(groupMap(this.students));
    }
    
    private char readChoice(){
        System.out.print("Choice(p/a/d/v/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p': populate();break;
                case 'a':add();break;
                case 'd':delete();break;
                case 'v':view();break;
                case 's':show();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("p - populate");
        System.out.println("a - add a name");
        System.out.println("d - delete a name");
        System.out.println("v - view names");
        System.out.println("s - show groups");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        (new GroupSelector()).menu();
    }
}




