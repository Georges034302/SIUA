package lecture08;



/**
 *read n from STDIN until -1
 *Calculate the factorial of n
 *Show the factorial
 */
public class Numbers{
    //1 - read n from keyboard
    //2 - calculate the factorial
    // public static int factorial(int n){
        // int f = 1;
        // for(int i = 2; i <= n; i++)
            // f *= i;
        // return f;
    // }

    public static int factorial(int n){        
        return (n > 1) ? n * factorial(n-1) : 1;
        //5 * 4 * 3 * 2 * 1
    }
    
    public static void main(String[] args){
        int n = 0;
        while((n = In.readInt("N = ")) != -1){
            System.out.println("Factorial ("+n+") = "+factorial(n));               
        }
    }
}
