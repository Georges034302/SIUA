package lab13;

/**
 *
 * @author George
 */
public class MathOps {
    private Numbers numbers;
    
    public MathOps(){
        
    }
    
    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    
    private void generate(){
        int seed = readInt("Seed = ");
        int size = readInt("Size = ");
        this.numbers = new Numbers(seed,size);
    }
    
    private void show(){
        this.numbers.show();
    }
    
    private void find(){
        int target = readInt("Target = ");
        int pos = numbers.binarySearch(target);
        
        if(pos >=0 )
            System.out.println(target+" is found at position "+pos);
        else
            System.out.println(target+" does not exist in the list");
    }
    
    private void showMin(){
        System.out.println("Min = "+numbers.min());
    }
    
    private void showMax(){
        System.out.println("Max = "+numbers.max());
    }
    
    private char readChoice(){
        System.out.print("Choice(g/m/M/f/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'g':generate();break; 
                case 'm':showMin();break;
                case 'M':showMax();break;
                case 'f':find();break;
                case 's':show();break;
                default:help();break;
            }
        }
    }
    
    private void help(){
        System.out.println("g - generate");
        System.out.println("m - show min");
        System.out.println("M - show max");
        System.out.println("f - find");
        System.out.println("s - show list");
        System.out.println("x - exit");
    }
    
    public static void main(String[] args) {
        (new MathOps()).menu();
    }
}
