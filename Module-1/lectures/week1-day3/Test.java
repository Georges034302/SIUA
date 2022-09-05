import java.util.Formatter;
import java.text.DecimalFormat;

public class Test{

    public static void main(String[] args){
       double x  = 12.123456;
       
       //method 1 - Formatter class
       StringBuffer sb = new StringBuffer();       
       Formatter formatter = new Formatter(sb);       
       formatter.format("%.3f",x);       
       System.out.println(formatter);
       
       //method 2 - printf
       System.out.printf("%.4f%n", x);
       
       //method 3 - String.format
       String s = String.format("%.3f", x);
       System.out.println(s);
       double y = Double.parseDouble(s);
       System.out.println("Y = "+y);
       
       //method 4 - System.format
       System.out.format("%.5f%n", x);
       
       //method 5 - Decimalformat class
       DecimalFormat df = new DecimalFormat("###,##0.00");
       String s2 = df.format(x);
       System.out.println(s2);
       
       System.out.println("Thank you");
    }
}

