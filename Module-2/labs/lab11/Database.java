import java.util.*;
import java.util.regex.*;

public class Database{
    private List<User> users;
    
    public Database(){
        this.users = new LinkedList();
    }
    
    
    //check if the user already registered
    private User user(int ID, String email){
        for(User user:users)
            if(user.unqiueID(ID) && user.uniqueEmail(email))
                return user;
        return null;
    } 
    
    private boolean matchEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    
    private boolean matchPassword(String password){
        return password.matches("[A-Za-z]{6,}(\\d){3,}");
    }
    
    public void register(int ID, String name, String email, String password){
        if(matchEmail(email) && matchPassword(password)){
            User user = user(ID,email);
            if(user != null){
                System.out.println("ID or email are not unique - try again");
            }else{
                this.users.add(new User(ID,name,email,password));
                System.out.println("User "+name+" signed up successfully");
            }
        }else{
            System.out.println("Incorrect Email or password format");
        }
    }
    
    private User userLogin(String email,String password){
        for(User user:users)
            if(user.login(email, password))
                return user;
        return null;
    } 
    
    public void login(String email, String password){
        if(matchEmail(email) && matchPassword(password)){
            User user = userLogin(email,password);
            if(user != null){
                System.out.println("Successful sign in");
            }else{                
                System.out.println("User does not exist");
            }
        }else{
            System.out.println("Incorrect Email or password format");
        }
    }
    
    public void show(){
        for(User user:users)
            System.out.println(user);
    }
}
