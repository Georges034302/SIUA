
public class Session{
    private Database db;
    
    public Session(){
        this.db = new Database();
    }
    
    private int readID(){
        System.out.print("ID: ");
        return In.nextInt();
    }
    
    private String readString(String prompt){
        System.out.print(prompt);
        return In.nextLine();
    }
    
    private void register(){
        int ID = readID();
        String name = readString("Name: ");
        String email = readString("Email: ");
        String password = readString("Password: ");
        
        db.register(ID, name, email, password);
    }
    
    private void login(){
        String email = readString("Email: ");
        String password = readString("Password: ");
        db.login(email, password);
    }
    
    private void view(){
        db.show();        
    }
    
     private char readChoice(){
        System.out.print("Choice(R/L/V/X): ");
        return In.nextChar();
    }

    private void menu(){
        char c;

        while((c = readChoice()) != 'X'){
            switch(c){
                case 'R':register();break;
                case 'L':login();break;
                case 'V':view();break;
                default: help();break;
            }
        }
    }

    private void help(){
        System.out.println("R - Register");
        System.out.println("L - Login");
        System.out.println("V - View");
        System.out.println("X - Exit");
    }

    public static void main(String[] args){
        (new Session()).menu();
    }
}
