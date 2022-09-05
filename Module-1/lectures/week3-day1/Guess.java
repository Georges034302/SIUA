
public class Guess{
    public static void main(String[] args){
        int[] x = {1,2,3,4,4,6};
        int[] y = {2,2,3,3,4,5};
        int count = 0;
        
        for(int i=0;i<x.length; i++){
            for(int j=0 ; j < y.length; ++j){
                if(x[i] == y[j])
                    count++;
            }            
        }
        System.out.println(count);
    }
}
