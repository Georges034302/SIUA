
public class Checker{
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = s2;
        
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
    }
}
