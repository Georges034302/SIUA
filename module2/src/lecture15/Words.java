package lecture15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class Words {
    private String filename = "words.txt";
    
    private void write(String s, String filename) throws IOException{
        Writer writer = new FileWriter(filename,true);        
        writer.write(s); 
        writer.write("\n");
        writer.close();
    }
    
    private String read(String filename) throws FileNotFoundException, IOException{
        Reader reader = new FileReader(filename);
        StringBuilder sb = new StringBuilder();
        int c;
        while( (c = reader.read()) != -1){
            sb.append((char)c);
        }
        reader.close();
        return sb.toString();
    }
    
    private String readString(){
        System.out.print("Word: ");
        return In.nextLine();
    }
    
    private void save(String filename) throws IOException{
        String  s;
        
        while(!(s = readString()).equals("*")){
            write(s, filename);
        }
    }
    
    private void show(String filename) throws IOException{
        String s = read(filename);
        System.out.println(s);
    }
    
    private void clear(String filename) throws IOException{
         Writer writer = new FileWriter(filename); 
         writer.write("");
    }
    
    public static void main(String[] args) {
        Words words = new Words();
        
        try {            
            words.save(words.filename);
            words.show(words.filename);
        } catch (IOException ex) {
            System.out.println("Cannot read/write to file");
        }
    }
}
