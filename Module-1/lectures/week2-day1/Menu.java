import java.util.Scanner;

public class Menu{
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.print("Command (a/b/*): ");
        char choice = keyboard.nextLine().charAt(0);
        
        while(choice != '*'){
            switch(choice){
                case 'a': System.out.println("Welcome to swithc menu");break;
                case 'b': System.out.println("Switch is similar to cascaded if-statement");break;
                default: System.out.println("Unknown command");
            }
            
            System.out.print("Command (a/b/*): ");
            choice = keyboard.nextLine().charAt(0);
        }
    }
}
