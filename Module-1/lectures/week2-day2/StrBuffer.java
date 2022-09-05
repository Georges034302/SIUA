
public class StrBuffer{
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        
        sb.append("Java");
        sb.append('-');
        sb.append(11);
        
        sb.insert(4," JDK");
        
        System.out.println(sb.toString());
    }
}
