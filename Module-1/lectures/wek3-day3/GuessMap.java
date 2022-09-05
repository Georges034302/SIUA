import java.util.Scanner;
public class GuessMap{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Mark = ");
        int mark = in.nextInt();
        int counter[] = new int[5];
        
        while(mark !=-1){
            if(mark >= 85)
                counter[0]++;
            else if(mark >= 75)
                counter[1]++;
            else if(mark >= 65)
                counter[2]++;
            else if(mark >= 50)
                counter[3]++;
            else
                counter[4]++;
                
            System.out.print("Mark = ");
            mark = in.nextInt();
        }
        
        String grades[] = {"HD","D","P","C","Z"};
        for(int i=0; i <grades.length; i++)
            System.out.printf("%3s --> %2d%n",grades[i],counter[i]);
    }
}









