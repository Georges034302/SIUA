import java.util.Scanner;

public class Lab5{
    static Scanner in = new Scanner(System.in);

    public static void exercise1(){
        System.out.print("Character: ");
        char c = in.nextLine().toLowerCase().charAt(0);
        int count = 0;

        while(c != '.'){
            String vowels = "aieou";

            if(!vowels.contains(""+c))
                count++;

            System.out.print("Character: ");
            c = in.nextLine().toLowerCase().charAt(0);
        }
        System.out.println("Total consonants = "+count);
    }

    public static void exercise2(){
        System.out.print("Character: ");
        char c = in.nextLine().charAt(0);

        while(c != '.'){
            if(!Character.isUpperCase(c))
                c = Character.toUpperCase(c);    
            System.out.println(c);
            System.out.print("Character: ");
            c = in.nextLine().charAt(0);
        }
    }

    public static void exercise3(){
        System.out.print("Character: ");
        char c = in.nextLine().charAt(0);
        int total = 0;
        while(c != '.'){
            if(Character.isDigit(c))
                total += Integer.parseInt(""+c);

            System.out.print("Character: ");
            c = in.nextLine().charAt(0);
        }
        System.out.println("Total = "+total);
    }

    public static void exercise4(){
        System.out.print("String: ");
        String s = in.nextLine();

        while(!s.equals("*")){
            System.out.print("Target: ");
            char target = in.nextLine().charAt(0);

            System.out.print("Sub: ");
            char sub = in.nextLine().charAt(0);

            System.out.println(s.replaceAll(""+target, ""+sub));

            System.out.print("String: ");
            s = in.nextLine();
        }
    }

    public static void exercise5(){
        System.out.print("String: ");
        String s = in.nextLine();

        System.out.println("The string has "+s.length()+" characters");
        System.out.println("The first character is "+s.charAt(0));
        System.out.println("The last character is "+s.charAt(s.length()-1));
        System.out.println("The middle part is "+s.substring(1,s.length()-1));
    }

    public static void exercise6(){
        System.out.print("String: ");
        String s = in.nextLine();        

        while(!s.equals("*")){
            int i = 0;
            int count = 0;
            while(i < s.length()){
                if(s.charAt(i) == ' ')
                    count++;
                i++;
            }
            System.out.println("Number of words = "+(count+1));

            System.out.print("String: ");
            s = in.nextLine();
        }

    }

    public static void exercise7(){
        System.out.print("Enter a word (or type \"*\" to finish): ");
        String s = in.nextLine(); 
        
        int total = 0;
        int count = 0;
        while(!s.equals("*")){

            total += s.length();
            count++;
            System.out.print("Enter a word (or type \"*\" to finish): ");
            s = in.nextLine();
        }
        System.out.printf("Average length = %.2f",(double)total/count);
    }

    public static void exercise8(){
        System.out.print("String: ");
        String s = in.nextLine();         
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String small = "";
        String big = "";
        
        while(!s.equals("*")){
            
            if( min > s.length() ){
                min = s.length();
                small = s;
            }
            if( max < s.length() ){
                max = s.length();
                big = s;
            }
            
            System.out.print("String: ");
            s = in.nextLine();
        }
        
        System.out.println(small);
        System.out.println(big);
    }

    public static void exercise9(){
        System.out.print("Word: ");
        String s = in.nextLine(); 

        while(!s.equals("*")){
            StringBuffer sb = new StringBuffer(s);
            
            if(s.equals(sb.reverse().toString()))
                System.out.println(s+" is a palindrome");
                
            System.out.print("word: ");
            s = in.nextLine();
        }
    }

    public static void exercise10(){
        System.out.println("Welcome to Calculator 1.0");
        System.out.print("Enter Expression: ");
        String s = in.nextLine(); 

        while(!s.equals("finish")){
           
            int a = Integer.parseInt(""+s.charAt(0));
            int b = Integer.parseInt(""+s.charAt(2));
            char op = s.charAt(1);
            switch(op){
                case '+': System.out.println(a+""+op+""+b+" = "+(a+b)); break;
                case '-': System.out.println(a+""+op+""+b+" = "+(a-b)); break;
                case '*': System.out.println(a+""+op+""+b+" = "+(a*b)); break;
                case '/': System.out.println(a+""+op+""+b+" = "+((b != 0) ? ((double)a/b): "NaN")); break;
            }
            System.out.print("Enter Expression: ");
            s = in.nextLine();
        }
        System.out.println("Goodbye");
    }
}









