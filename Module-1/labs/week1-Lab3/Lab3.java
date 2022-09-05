/**
 * Lab 3 - Selection Statements
 * 
 * Write your code inside each method exerciseN
 * where N stands for the exercise number
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class Lab3{
    static Scanner in = new Scanner(System.in);
    
    public static void exercise1(){
        int x = (2 + 3) * 46 - 53 + 47 * (2 + 3) - 100;
        
        if( x > 0 )
            System.out.println("positive");
        else
            System.out.println("not positive");
    }
   
    public static void exercise2(){
        System.out.print("Age: ");
        int age = in.nextInt();
        
        if(age > 12 && age < 20)
            System.out.println("you are teenager");
        else
            System.out.println("you are not a teenager");
    }
    
    public static void exercise3(){
        System.out.print("Mark: ");
        int mark = in.nextInt();
        String grade = "";
        
        if(mark >= 85)
            grade = "HD";
        else if(mark >= 75)
            grade = "D";
        else if(mark >= 65)
            grade = "C";
        else if(mark >= 50)
            grade = "P";
        else
            grade = "Z";
        System.out.println("your grade is "+grade);        
    }
    
    public static void exercise4(){
        System.out.print("a = ");
        int a = in.nextInt();
        System.out.print("b = ");
        int b = in.nextInt();
        System.out.print("c = ");
        int c = in.nextInt();
        
        if(a < b && a < c)
            System.out.println(a);
        else if(b < a && b < c)
            System.out.println(b);
        else if(c < a && c < b)
            System.out.println(c);
        else if(a==b && a==c)
            System.out.println(a);
    }
    
    public static void exercise5(){
        System.out.print("S1 = ");
        String s1 = in.nextLine();
        System.out.print("S2 = ");
        String s2 = in.nextLine();
        System.out.print("S3 = ");
        String s3 = in.nextLine();
        
        int min = s1.length();
        
        if(min > s2.length()){           
            min = s2.length();            
        }
        if(min > s3.length()){
            min = s3.length();
        }
        
        System.out.print(min);
    }
    
    public static void exercise6(){
        System.out.print("Balance = ");
        double amount = in.nextDouble();
        
        DecimalFormat df = new DecimalFormat("#,##0.000");
        String output = df.format(amount);
        System.out.println(output);
    }
    
    public static void exercise7(){
        Random r = new Random();
        int x = r.nextInt(899999)+100000;        
        System.out.format("%9d%n", x);
        
        double y = r.nextDouble();
        System.out.printf("%6.3f",y);
    }
    
    public static void exercise8(){
        Random r = new Random();
        int n = r.nextInt(7)+1; // 1 <= n <= 7
        String day = "";
        
        switch(n){
            case 1: day = "Monday";break;
            case 2: day = "Tuesday";break;
            case 3: day = "Wednesday";break;
            case 4: day = "Thursday";break;
            case 5: day = "Friday";break;
            case 6: day = "Saturday";break;
            case 7: day = "Sunday";break;
            default: day = "unknown";break;
        }
        System.out.println(day);
    }

    public static void exercise9(){
        System.out.print("Month: ");
        String m = in.nextLine();
        
        int days = 0;
        
        switch(m.toLowerCase().strip()){
            case "january": days = 31;break;
            case "february": days = 28;break;
            case "march": days = 31;break;
            case "april": days = 30;break;
            case "may": days = 31;break;
            case "june": days = 30;break;
            case "july": days = 31;break;
            case "august": days = 31;break;
            case "september": days = 30;break;
            case "october": days = 31;break;
            case "november": days = 30;break;
            case "december": days = 31;break;
            default: System.out.println("Unknonwn Command");break;
        }
        if(days >0) 
            System.out.println(m+" has "+days+" days");
    }

    public static void exercise10(){
        System.out.print("Char: ");
        char c = in.nextLine().charAt(0);
        
        String vowels = "aeiuoAIEOU";
        
        // if(vowels.contains(""+c))
            // System.out.println(c+" is a vowel");
        // else
            // System.out.println(c+" is a consonant");
        
        String output = (vowels.contains(""+c)) ? c+" is a vowel" : c+" is a consonant";
        System.out.println(output);
    }
}








