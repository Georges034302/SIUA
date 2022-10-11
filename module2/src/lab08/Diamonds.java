package lab08;


public class Diamonds{
    //1 - repeat until n = -1
    public static void main(String[] args){
        int n = 0;        
        while ((n = size()) != -1){
            if(n == 0)
                System.out.println("no diamond");
            else
                showDiamond(n);
        }
    }
    
    public static int size(){
        System.out.print("Size = ");
        return In.nextInt();
    }
    
    //2 - show the diamond
    public static void showDiamond(int size){
        showTop(size);
        showMiddle(size);
        showBottom(size);
    }
    
    //3 - show top triangle
    public static void showTop(int size){
        for(int i = 1; i < size ; i++)
            showLine(i,size);
    }
    
    //4 - show middle line
    public static void showMiddle(int size){
        showLine(size,size);
    }
    
    //5 - show bottom triangle
    public static  void showBottom(int size){
        for(int i = size-1 ; i >= 1 ; i--)
            showLine(i,size);
    }
    
    //6 - show a line (with spaces and stars)
    public static void showLine(int howmany, int size){
        int spaces = size - howmany;
        
        repeat(spaces, " ");
        repeat(howmany,"* ");
        System.out.println();  
    }
    
    //7 - show item many times
    public static void repeat(int howmany, String item){
        for(int i = 0 ; i < howmany ; i++)
            System.out.print(item);
    }
}
