
public class Binary{
    
    //Goal 1: show the binary of a number between 0-255
    public static void main(String[] args){
        Binary b = new Binary();
        int n = b.readNumber();
        
        while(n != -1){
            if(n < 0 || n > 255)
                System.out.println("n must be between 0 and 255");
            else{
                String binary = b.binary(n);        
                System.out.println("Binary = "+binary);                
            }
            n = b.readNumber();
        }
        System.out.println("Done");
    }
    private int readNumber(){
        System.out.print("Number = ");
        return In.nextInt();
    }   
     
    //Goal 2: convert the number to binary
    private String binary(int number){
        StringBuffer sb = new StringBuffer();
        
        while(number > 0){
            sb.append(number%2);
            number /= 2;
        }
        return zeroes(sb).reverse().toString();
    }
    
    //Goal 3: add missing zeroes to a binary
    private StringBuffer zeroes(StringBuffer sb){
        int i = sb.length();
        while(i < 8){
            sb.append("0");
            i++;
        }
        return sb;
    }
}


