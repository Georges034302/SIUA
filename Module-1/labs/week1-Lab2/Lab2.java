import java.util.Scanner;

public class Lab2{
    
    static Scanner in = new Scanner(System.in);
    
    public static void exercise1(){
        int x = 4;
        int y = 2;

        System.out.println(x+y);
        System.out.println(x-y);
        System.out.println(x*y);
        System.out.println(x/y);
        
        int res = x%y+x/y;
        System.out.println(res);
    }
   
    public static void exercise2(){
        int x = 3;
        double y = 3.5;
        int z = (int)(x+y);
        int result = z % x;
        System.out.println(z);
        System.out.println(result);
    }
    
    public static void exercise3(){
        double x = Math.sqrt(12);
        double y = Math.exp(x); 
        System.out.println(x);
        System.out.println(y);
    }
    
    public static void exercise4(){
        double res = (Math.pow(2,7)+7/(Math.sqrt(5)+1))*(Math.pow(3,4)%5 + 2);
        System.out.println(res);
    }
    
    public static void exercise5(){
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.println("Hello "+name);
    }
    
    public static void exercise6(){
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.print("Your bill? ");
        double bill = in.nextDouble();
        System.out.println("Hello "+name+". Please pay "+bill);
    }
    
    public static void exercise7(){
        System.out.print("Base: ");
        double base = in.nextDouble();
        System.out.print("Height: ");
        double h = in.nextDouble();
        
        double area = (base*h)/2;
        System.out.println("Triangle area = "+area);
    }
    
    public static void exercise8(){
        System.out.println("Readius: ");
        double r = in.nextDouble();
               
        double area = Math.PI*Math.pow(r,2);
        System.out.println("Circle area of radius "+r+" is: "+area);
        
        double v = (4.0/3)*Math.PI*Math.pow(r,3);
        System.out.println("Circle volume of radius "+r+" is: "+v);
    }

    public static void exercise9(){
        System.out.print("x1 = ");
        double x1 = in.nextDouble();
        
        System.out.print("y1 = ");
        double y1 = in.nextDouble();
        
        System.out.print("x2 = ");
        double x2 = in.nextDouble();
        
        System.out.print("y2 = ");
        double y2 = in.nextDouble();
        
        double distance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        System.out.println("Distance between A("+x1+","+y1+") and B("+x2+","+y2+") is "+distance);
    }

    public static void exercise10(){
        System.out.print("String: ");
        String s = in.nextLine();
        
        System.out.println("First = "+s.charAt(0));
        System.out.println("Last = "+s.charAt(s.length()-1));
        System.out.println("Lower-case s = "+s.toLowerCase());
        System.out.println("Length of s = "+s.length());
    }
    /*
     * Read a sentence from user-input 
     * replace the white-spaces with #
     * Convert the string to upper-case
     * And then show the result
     * 
     */
    public static void exercise11(){
        System.out.print("Sentence: ");
        String s = in.nextLine();
        
        String output = s.strip().replaceAll(" ", "#").toUpperCase();
                        
        System.out.println(output);
    }  
}

