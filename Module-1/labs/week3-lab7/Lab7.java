 /**
 * Lab 7 - Patterns, Process, RegEx
 * 
 * Write your code inside each method exerciseN
 * where N stands for the exercise number
 */
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lab7{
    static Scanner in = new Scanner(System.in);

    public static void exercise1(){
        int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

        Calendar calendar = Calendar.getInstance();  
        int year = calendar.get(Calendar.YEAR);

        if(year % 4 == 0) months[1] = 29;

        int sum = 0;
        for(int i=0; i < months.length; i++)
            sum += months[i];

        System.out.printf("Average days = %.3f%n",(double)sum/months.length);
    }

    public static void exercise2(){
        Random r = new Random();
        double x[] = new double[50];

        for(int i=0 ; i <x.length; i++)
            x[i] = r.nextDouble();

        double sum = 0;
        for(int i=0; i<x.length; i++)
            sum += x[i];

        System.out.printf("Average = %.3f%n",(double)sum/x.length);    
    }

    public static void exercise3(){
        System.out.print("Character: ");
        char c = in.nextLine().toLowerCase().charAt(0);
        String vowels = "aieou";

        int count = 0;
        while(c != '.'){

            if(vowels.contains(""+c))
                count++;

            System.out.print("Character: ");
            c = in.nextLine().toLowerCase().charAt(0);
        }
        System.out.println("Vowels count = "+count);
    }

    public static void exercise4(){
        System.out.print("Size: ");
        int size = in.nextInt();

        int x[][] = new int[size-1][size+1]; //size > 1
        Random r = new Random();

        for(int i=0 ; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++)
                x[i][j] = r.nextInt(10);
        }

        double d1 = Math.sqrt(Math.pow(x[0][0],2)+Math.pow(x[size-2][0],2));
        double d2 = Math.sqrt(Math.pow(x[0][0],2)+Math.pow(x[0][size],2));
        double d3 = Math.sqrt(Math.pow(x[0][0],2)+Math.pow(x[size-2][size],2));
        double d4 = Math.sqrt(Math.pow(x[size-2][0],2)+Math.pow(x[0][size],2));
        double d5 = Math.sqrt(Math.pow(x[size-2][0],2)+Math.pow(x[size-2][size],2));
        double d6 = Math.sqrt(Math.pow(x[0][size],2)+Math.pow(x[size-2][size],2));

        System.out.println(Arrays.deepToString(x));
        System.out.println("D1 = "+d1+"\n"
            +"D2 = "+d2+"\n"
            +"D3 = "+d3+"\n"
            +"D4 = "+d4+"\n"
            +"D5 = "+d5+"\n"
            +"D6 = "+d6+"\n");
    }

    public static void exercise5(){
        System.out.print("Size: ");
        int size = in.nextInt();
        int x[] = new int[size];

        Random r = new Random();
        for(int i=0; i < x.length; i++)
            x[i] = r.nextInt(100);
        System.out.println(Arrays.toString(x));

        int count = 0;
        int temp = 0;        
        for(int i=0; i < x.length; i++){
            for(int j = i+1; j < x.length; j++){
                if(x[j] < x[i]){
                    temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(x));
        System.out.println("Number of steps = "+count);
    }

    public static void exercise6(){
        System.out.print("Rain: ");
        int rain = in.nextInt();

        int count = 0;
        int max = 0;
        while(rain != -1){

            if(rain >0){ 
                count++;
                if(count > max ) 
                    max = count;
            }else
                count = 0;
            System.out.print("Rain: ");
            rain = in.nextInt();
        }

        System.out.println("Longest rain stretch = "+max);
    }

    public static void exercise7(){
        // number --->  abc
        // Extract the digits a and b and c from the number
        // int a = number / 100
        // int rest = number % 100
        // int b = rest / 10
        // int c = rest % 10

        String [] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String [] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        System.out.print("Number: ");
        int number = in.nextInt();        

        while(number != -1){
            int hundred = number/100;
            int rest = number % 100;
            int ten = rest/10;
            int unit = rest%10;
            String word = "";
            
            if(hundred > 0)
                word += ones[hundred]+" hundred ";
            if(hundred > 0 && rest > 0)
                word += "and ";
            if(ten >= 2)
                word += tens[ten]+" "+ones[unit];
            else if (number ==0)
                word = "zero";
            else
                word += ones[rest];
                
            System.out.println("Word = "+word);    
            System.out.print("Number: ");
            number = in.nextInt(); 
        }
    }

    public static void exercise8(){
        String s = "Welcome to Java Programming. Java is used for Desktop, Web, IoT, Microservices software applications";
        
        String regex = "[A-Z]";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        
        int count = 0;
        while(m.find()) count++;
        System.out.println("Number of matches = "+count);
    }

    public static void exercise9(){
        String s = "This tutorial is helpful to understand RegEx."+
        " The tutor explained theRegEx concepts. Tutor ‘George’ "+
        "discussed the RegEx special characters and wild cards in this tutorial";
        
        String regex = "\\btutor\\b";
        
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        
        String replacement = "lecturer";
        
        String r = m.replaceAll(replacement);
        
        System.out.println("Original string: "+s+"\n");
        System.out.println("New string: "+r+"\n");
    }

    public static void exercise10(){

    }
}







