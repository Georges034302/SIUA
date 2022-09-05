
public class Formatting{
    public static void main(String[] args){
        double num = Math.sqrt(1025.123);
        
        double  distance = Math.sqrt(911234567);
        
        int d = 100;        
        System.out.printf("%9d%n",d);
        
        String s = String.format("%09.2f%n",distance);
        
        
        System.out.printf("%.2f%n",num);
        
        
        
        System.out.println(s);
    }
}
