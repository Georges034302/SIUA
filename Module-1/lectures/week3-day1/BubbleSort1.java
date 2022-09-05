import java.util.Arrays;

public class BubbleSort1{
    public static void main(String[]args){
        int x[] = {44,2,33,1,3,2,2,66,12,12,45,1,3,37,7};
        
        int temp = 0;
        
        for(int i=0; i < x.length; i++){
            for(int j = i+1; j < x.length; j++){
                if(x[j] < x[i]){
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(x));
    }
}
