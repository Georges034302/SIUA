import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Lab6{
    static Scanner in = new Scanner(System.in);

    public static void exercise1(){
        int x[] = {0,1,2,-3,3,4};
        int y[] = {-1,1,2,-2,3,5};
        int count = 0;
        for(int i=0; i < x.length; i++){
            for(int j = 0; j < y.length; j++)
                if(Math.abs(x[i]) == Math.abs(y[j]))
                    count++;
        }

        int matches[] = new int[count];
        int k = 0;
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < y.length; j++)
                if(Math.abs(x[i]) == Math.abs(y[j]))
                    matches[k++] = Math.abs(x[i]);
        }

        System.out.println("count = "+count);
        System.out.println(Arrays.toString(matches));
    }

    public static void exercise2(){
        System.out.print("Day (1 to 31) = ");
        int day = in.nextInt();

        System.out.print("Month (1 to 12) = ");
        int month = in.nextInt();

        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        int numberOfDays = 0;
        for(int i=0; i < month-1; i++)
            numberOfDays += months[i];

        System.out.println(numberOfDays+day);
    }

    public static void exercise3(){
        System.out.print("Size = ");
        int size = in.nextInt();
        double x[] = new double[size];

        Random r = new Random();
        for(int i=0; i <x.length; i++)
            x[i] = r.nextDouble();

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        double avg = 0;
        System.out.println(Arrays.toString(x));
        for(int i=0; i <x.length; i++){
            if(min > x[i]) min = x[i];
            if(max < x[i]) max = x[i];            
            sum +=x[i];
        }
        avg = sum/x.length;

        System.out.format("Min = %.3f%n",min);
        System.out.format("Max = %.3f%n",max);
        System.out.format("Sum = %.3f%n",sum);
        System.out.format("Avg = %.3f%n",avg);
    }

    public static void exercise4(){
        System.out.print("Size = ");
        int size = in.nextInt();
        int x[] = new int[size];

        Random r = new Random();
        for(int i =0; i < x.length; i++)
            x[i] = r.nextInt(21);

        System.out.println(Arrays.toString(x));

        int leftSum = 0;
        int rightSum = 0;
        int left = 0;
        int right = x.length-1;

        while(left <= right){
            leftSum += x[left++];
            rightSum += x[right--];
        }
        System.out.println("Left Sum = "+leftSum);
        System.out.println("Right Sum = "+rightSum);
    }

    public static void exercise5(){
        System.out.print("Size = ");
        int size = in.nextInt();
        int x[] = new int[size];

        x[0] = 1;
        for(int i = 1; i < x.length; i++)
            x[i] = i + 1/x[i-1];

        System.out.println(Arrays.toString(x));
    }

    public static void exercise6(){
        System.out.print("Size = ");
        int size = in.nextInt();
        int x[] = new int[size];

        Random r = new Random();
        for(int i =0; i < x.length; i++)
            x[i] = r.nextInt(100);
        System.out.println(Arrays.toString(x));

        for (int i = 0; i < x.length - 1; i++) {  
            int index = i;  
            for (int j = i + 1; j < x.length; j++){  
                if (x[j] < x[index]){  
                    index = j;//searching for lowest index  - or marking the position of the smallest number in order
                }  
            }  
            int temp = x[index];   
            x[index] = x[i];  
            x[i] = temp; 
        }
        System.out.println(Arrays.toString(x));
    }

    public static void exercise7(){
        int x[][] = new int[3][3];

        Random r = new Random();
        for(int i=0 ; i<x.length; i++){
            for(int j=0; j < x[i].length; j++)
                x[i][j] = r.nextInt(5);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<x.length; i++){
            for(int j=0; j < x[i].length; j++)
                if(max < x[i][j]) max = x[i][j];
        }

        System.out.println(Arrays.deepToString(x));
        System.out.println("max = "+max);
    }

    public static void exercise8(){
        char x[][] = new char[5][];
        x[0] = new char[]{' '};  //create and initialize
        x[1] = new char[]{' ',' '}; //create and initalize
        x[2] = new char[3]; //create
        x[3] = new char[4];
        x[4] = new char[5];

        for(int i=0 ; i<x.length; i++){
            for(int j=0 ; j < x[i].length; j++){
                if(i == j) 
                    x[i][j] = '-';
                else
                    x[i][j] = '*'; 
            }
        }

        for(int i=0 ; i<x.length; i++){
            for(int j=0 ; j <x[i].length; j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void exercise9(){
        int[][] arr = new int[3][3];
        int  x, y, z, determinant = 0;
        
       Random r = new Random();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(10);
            }		
        }

        x = (arr[1][1] * arr[2][2]) - (arr[2][1] * arr[1][2]);
        y = (arr[1][0] * arr[2][2]) - (arr[2][0] * arr[1][2]);
        z = (arr[1][0] * arr[2][1]) - (arr[2][0] * arr[1][1]);

        determinant = (arr[0][0] * x)- (arr[0][1] * y) + (arr[0][2] * z);
        for(int i=0 ; i<arr.length; i++){
            for(int j=0 ; j <arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The Determinant of 3 * 3 Matrix = " + determinant );
    }

    //Determine the frequency of numbers entered from STDIN     
    public static void exercise10(){
        int counter[] = new int[10]; //store the frequencies in this array
        
        System.out.print("N = ");
        int n = in.nextInt();
        
        while(n != -1){
            
            counter[n/10]++; //key-framework
            
            System.out.print("N = ");
            n = in.nextInt();
        }
        
       for(int i = 0 ; i < counter.length; i++){
            int start = 10*i;
            int end = start+9;
            
            System.out.printf("%2d - %2d --> %2d%n",start,end,counter[i]);
        }
    }
}























