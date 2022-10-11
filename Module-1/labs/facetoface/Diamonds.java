/**
display a diamond of stars with size n from user input. repeat until -1
 */
public class Diamonds{

    public static void main(String[] args){
        int n = 0;
        while((n = readSize()) != -1){
            showDiamond(n);            
        }
    }

    public static int readSize(){
        System.out.print("Size = ");
        return In.nextInt();
    }
    //6-show diamond
    public static void showDiamond(int size){
        showTop(size);
        showMiddle(size);
        showBottom(size);
    }
    //5- show top section
    public static void showTop(int size){
        for(int i = 1; i <= size-1; i++)
            showLine(size,i);
    }

    //4- show middle line
    public static void showMiddle(int size){
        showLine(size,size);
    }
    //3- show bottom section
    public static void showBottom(int size){
        for(int i = size-1; i >=1; i--)
            showLine(size,i);
    }
    //2- show a line
    public static void showLine(int size, int howmany){
        int spaces = size - howmany;
        showItem(" ",spaces);
        showItem("* ",howmany);
        System.out.println();

    }

    //1 - show an item
    public static void showItem(String item, int howmany){
        for(int i = 0; i< howmany; i++){
            System.out.print(item);
        }

    }
}
