

public class Formatting{
    public static void main(String[] args){
        String iFormat = "| %-8s | %-8s |%n";
        System.out.format("+----------+----------+%n");
        System.out.format("| i        | even i   |%n");
        System.out.format("+----------+----------+%n");
        for(int i = 0; i <10; i++){
            System.out.format(iFormat,i,Math.pow(i, 2));
        }
        System.out.format("+----------+----------+%n");
    }
}
