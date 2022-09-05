import java.util.Arrays;

public class BubbleSort2{
    public static void main(String[]args){
        int x[] = {44,2,33,1,3,2,2,66,12,12,45,1,3,37,7};
        
        int temp = 0;
        int rightmostswap = x.length -1;
        
        while(rightmostswap > 0){
            int right = rightmostswap;
            rightmostswap = 0;
            for(int i = 0; i < right; i++){
                if(x[i] > x[i+1]){
                    temp = x[i+1];
                    x[i+1] = x[i];
                    x[i] = temp;
                    rightmostswap = i;
                }
            }
        }
        System.out.println(Arrays.toString(x));
    }
}