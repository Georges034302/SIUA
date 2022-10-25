package lecture15;

/**
 *
 * @author George
 */
public class Test {
    public static final String RED_BOLD = "\033[1;31m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String WHITE_BOLD = "\033[1;37m";

    public static void main(String[] args) {

        System.out.print("String: ");
        String s = In.nextLine();
        try {
            int num = Integer.parseInt(s);
            System.out.println(num);
        }catch (NumberFormatException ex) {
            System.out.println(RED_BOLD+"Please enter numerical strings"+WHITE_BOLD);
        }finally{
            System.out.println(YELLOW_BOLD+"It is good to handle exceptions"+WHITE_BOLD);
        }
    }
}
