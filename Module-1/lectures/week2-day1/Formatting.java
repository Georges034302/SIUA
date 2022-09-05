public class Formatting{
    public static void main(String[] args){
        String rules = "| %-2s | %-7s |%n";
        System.out.format("+----+---------+%n");
        System.out.format("| i  | pow(i,2)|%n");
        System.out.format("+----+---------+%n");
        for(int i = 0; i <10; i++)
            System.out.format(rules,i,Math.pow(i,2));

        System.out.format("+----+---------+%n");
    }
}