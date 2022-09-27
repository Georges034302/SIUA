public class Operator{
    private Numbers numbers;
    
    public Operator(){
        this.numbers = new Numbers();
    }
    
    private void generate(){
        numbers.generate();
    }
    
    private void find(){
        int target = readInt();
        if(numbers.number(target))
            System.out.println("Target is found");
        else
            System.out.println("Target does not exist");
    }
    
    private int readInt(){
        System.out.print("Target = ");
        return In.nextInt();
    }
    
    private void show(){
        numbers.show();
    }
    
    private char readChoice(){
        System.out.print("Choice(g/f/s/x): ");
        return In.nextChar();
    }
    
    private void menu(){
        char c;
        
        while((c = readChoice()) != 'x'){
            switch(c){
                case 'g': generate(); break;
                case 'f': find(); break;
                case 's': show(); break;
                default: help();break;
            }
        }
    }
    
    private void help(){
         System.out.println("g - generate");
         System.out.println("f - find");
         System.out.println("s - show");
         System.out.println("x - exit");
    }
    
    public static void main(String[] args){  
        (new Operator()).menu();
    }   
    
}




