import java.util.*;

public class TwoDList{
    private List<List<Integer>> numbers;
    
    public TwoDList(){
        this.numbers = new ArrayList();
    }
    
    private void populate(){
        int rows = readInt("Rows = ");
        Random r = new Random();

        for(int i=0; i < rows; i++){
             int cols = readInt("Cols = ");
            List<Integer> row = new ArrayList(cols);  
            numbers.add(row);
            for(int j=0; j< cols; j++){
                numbers.get(i).add(r.nextInt(10));                
            }
        }
    }   
    
    private void showList(){
        for(int i=0; i < numbers.size(); i++){          
            for(int j=0; j< numbers.get(i).size(); j++){
                System.out.print(numbers.get(i).get(j)+" "); //x[i][j]             
            }
            System.out.println();
        }
    }
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    private char readChoice(){
        System.out.print("Choice(p/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice())!= 'x'){
            switch(c){
                case 'p': populate(); break;
                case 's': showList(); break;
                default: help(); break;
            }
        }
    }
    
    private void help(){
        System.out.println("p - populate");
        System.out.println("s - show");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args){
        TwoDList twodlist = new TwoDList();
        twodlist.menu();
    }
}



