package lab15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author George
 */
public class Chars {
    private String dirString = "D:\\GitHub\\SIUA\\module2\\files\\";
    private String charsString = "chars.txt";
    private File dirFile;
    private File charsFile;
    
    public static void main(String[] args) {
         Chars c = new Chars();
        try {
           
            c.setup();
            
            c.stringWriter();
            c.showVowelCount();
        } catch (IOException ex) {
            System.out.println("Oups something went wrong!");
        }
        
    }
    
    private void setup() throws IOException{
        dirFile = new File(dirString); 
        if(!dirFile.exists())
            dirFile.mkdirs();
        
        charsFile = new File(dirString+charsString);
        if(!charsFile.exists())
            charsFile.createNewFile();
    }
    
    private void write(String s, File file) throws IOException{
        Writer writer = new FileWriter(file, true);
        
        s.chars().mapToObj(c -> (char)c).forEach(c -> {
            try {
                writer.write(c);
            } catch (IOException ex) {
                System.out.println("Cannot write to file");
            }
        });
        writer.write("\n");
        writer.close();
    }
    
    private String readString(File file) throws FileNotFoundException, IOException{
        Reader reader = new FileReader(file);
        
        StringBuilder sb = new StringBuilder();
        
        int c;
        
        while( (c = reader.read()) != -1)
            sb.append((char)c);
        
        reader.close();
        return sb.toString();
    }
    
    private int vowelCount(String s){
        return (int)s.chars()
                     .mapToObj(c -> (char)c)
                     .filter(c -> "AIEOUaieou".contains(""+c))
                     .count();
    }
    
    private String readString(){
        System.out.print("String: ");
        return In.nextLine();
    }
    
    private void stringWriter() throws IOException{
        String s;
        
        while(!(s = readString()).equals("*"))
            write(s, charsFile);
    }
    
    private void showVowelCount() throws IOException{
        String s = readString(charsFile);
        System.out.println("Vowel Count = "+vowelCount(s));
    }
}
