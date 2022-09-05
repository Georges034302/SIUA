import java.util.Random;

public class Jagged2{
    public static void main(String[] args){
        int x[][] = new int[3][];
        x[0] = new int[1];
        x[1] = new int[2];
        x[2] = new int[3];
        Random r = new Random();
        for(int i=0; i < x.length; i++){
            for(int j=0; j< x[i].length; j++){
                x[i][j] = r.nextInt(2);
            }
        }
        
        for(int i=0; i < x.length; i++){
            for(int j=0; j< x[i].length; j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }
}
