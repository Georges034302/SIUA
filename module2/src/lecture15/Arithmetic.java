package lecture15;

import java.util.Random;

/**
 *
 * @author George
 */
public class Arithmetic {
    private int x;
    private int y;
    
    public Arithmetic(){
        this.x = (new Random()).nextInt(5);
        this.y = (new Random()).nextInt(5);
    }
    
    public double div() throws ArithmeticException{    
        if(y == 0)
            throw new ArithmeticException(""+x+" / "+y+"");
        return x/y;
    }
    
    public String result(){
        return "x / y = "+div();
    }

    @Override
    public String toString() {
        return String.format(""+x+" / "+y+" = %.2f", div());
    }   
    
}
