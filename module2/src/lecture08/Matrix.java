package lecture08;



/*** generate and show a matrix of size n x n
 *  values of the matrix are random of seed 9
 *
 **/
public class Matrix{

    public static int[][] twoDArray(int size){
        int x[][] = new int[size][size];
        
        for(int i=0; i < x.length; i++)
            for(int j = 0; j < x[i].length; j++)
                x[i][j] = Randomizer.randomInt(9);
        return x;
    }
    
    public static void update(int[][] x){
        for(int i=0; i < x.length; i++)
            for(int j = 0; j < x[i].length; j++)
                x[i][j] = Randomizer.randomInt(9);
    }

    public static void showArray(int x[][]){
        for(int i=0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++)
                System.out.print(x[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[ ]args){
        int n = 0;
        while((n = In.readInt("Size = ")) != -1){
            int [][] x = twoDArray(n);
            System.out.println("Initial array ");
            showArray(x);   
            update(x);
            System.out.println("Updated array ");
            showArray(x);
        }
        //showArray(twoDArray(readSize()));
    }
}

