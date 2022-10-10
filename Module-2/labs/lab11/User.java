
public class User{
    private int ID;
    private String name;
    private String email;
    private String password;
    
    public User(int ID, String name, String email, String password){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean login(String email, String password){
        return this.email.equals(email) && this.password.equals(password);
    }
    
    public boolean unqiueID(int ID){
        return this.ID == ID;
    }
    
    public boolean uniqueEmail(String email){
        return this.email.equals(email);
    }
    
    public void change(String password){
        this.password = password;
    }
    
    @Override
    public String toString(){
        return "User-"+this.ID+": "+this.name;
    }
}









