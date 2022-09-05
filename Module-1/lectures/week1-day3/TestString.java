
public class TestString{
    public static void main(String[] args){
        String s1 = "one";
        String s2 = new String("one");
        
        if(s1 == s2)
            System.out.println("Correct");
        else
            System.out.println("False");
    }
}
