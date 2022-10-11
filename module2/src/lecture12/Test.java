package lecture12;
import java.util.*;

public class Test{
    private List<List<User>> users = new ArrayList();

    public Test(){}

    private List<List<User>> populate(){
        int rows = readInt("Rows = ");
        List<List<User>> outer = new ArrayList(rows);
        
        for(int i=0; i< rows; i++){
            int cols = readInt("Cols = ");
            List<User> inner = new ArrayList(cols);           
            for(int j = 0 ; j< cols; j++)
                inner.add(j,new User(readName()));
            outer.add(i, inner);
        }
        return outer;
    }

    private String readName(){
        System.out.print("Name = ");
        return In.nextLine();
    }

    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
}
