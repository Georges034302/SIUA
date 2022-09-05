import java.util.Scanner;
import java.util.Random;

public class Lab2{
    static Scanner in = new Scanner(System.in);

    public static void exercise1(){
        String rules = "| %-2s | %-8.3f |%-15.3f |%n";
        System.out.format("+----+----------+----------------+%n");
        System.out.format("| i  | SQRT\t| EXP \t\t |%n");
        System.out.format("+----+----------+----------------+%n");
        for(int i = 0; i <10; i++)
            System.out.format(rules,i,Math.sqrt(i),Math.exp(i));

        System.out.format("+----+----------+----------------+%n");
    }

    public static void exercise2(){

        for(int i = 1; i<=20; i+=(int)Math.sqrt(i)+1){
            if(i%2 != 0)
                System.out.print(i+",");
        }
        System.out.println();
    }

    public static void exercise3(){
        System.out.print("N =");
        int n = in.nextInt();

        while(n > 0){

            for(int i = 0; i < n; i++)
                System.out.print("*");
            System.out.println();

            System.out.print("N =");
            n = in.nextInt();
        }
    }

    public static void exercise4(){
        System.out.print("N =");
        int n = in.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(n != -1){

            if(n < min) min = n;
            if(n > max) max = n;

            System.out.print("N = ");
            n = in.nextInt();
        }
        System.out.println("Min = "+min);
        System.out.println("Max = "+max);
    }

    public static void exercise5(){
        System.out.print("N =");
        int n = in.nextInt();

        while(n != -1){

            int total = 0;
            for(int i=1; i <= n ; i++)
                if(i % 2 == 0)
                    total += i;                    
            System.out.println("Total = "+total);

            System.out.print("N =");
            n = in.nextInt();     
        }
    }

    public static void exercise6(){
        System.out.print("N =");
        int n = in.nextInt();
        int total = 0;

        while(n != -1){

            int number = new Random().nextInt(10);
            System.out.println("generated number = "+number);

            if(number % 2 == 0)
                total += number;    

            System.out.print("N =");
            n = in.nextInt();     
        }

        System.out.println("Total = "+total);
    }

    public static void exercise7(){
        System.out.print("Char =");
        char c = in.nextLine().charAt(0);
        int count = 0;
        String vowels = "aioueAIUOE";

        while(c != '.'){

            if(vowels.contains(""+c))
                count++;

            System.out.print("N =");
            c = in.nextLine().charAt(0);
        }
        System.out.println("Total vowels = "+count);
    }

    public static void exercise8(){
        System.out.print("N =");
        int n = in.nextInt();

        while(n >= 0){
            int f = 1;
            if(n == 0)
                System.out.println("Factorial("+n+") = "+f);

            for(int i = 2; i <= n; i++)
                f *= i;
            System.out.println("Factorial("+n+") = "+f);

            System.out.print("N =");
            n = in.nextInt();
        }
    }

    public static void exercise9(){
        int guess = 0;
        int n = new Random().nextInt(10)+1;

        do{
            System.out.print("Guess = ");
            guess = in.nextInt();   

            if(guess != n)
                System.out.println("Sorry - try again");             
        }while(guess != n);

        System.out.println("Success - secret number = "+n);
    }

    public static void exercise10(){       

        System.out.print("N =");
        int n = in.nextInt();
        
        while (n != -1){
            
            int first = 1;
            int second = 1;
            int result = 0;
            for(int i = 2; i <= n; i++){
                result = first + second;
                first = second;
                second = result;
            }
            System.out.println(result);
            System.out.print("N =");
            n = in.nextInt();   
        }
    }
}

