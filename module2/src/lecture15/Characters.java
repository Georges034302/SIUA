package lecture15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Characters {

    private String vowelsString = "vowels.txt";
    private String frequenciesString = "frequencies.data";
    private String dirString = "D:\\GitHub\\SIUA\\module2\\files\\";
    
    public void setup() throws IOException {
        File dir = new File(dirString);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        File vowelsFile = new File(dirString + vowelsString);
        if (!vowelsFile.exists()) {
            vowelsFile.createNewFile();
        }
        
        File freqFile = new File(dirString + frequenciesString);
        if (!freqFile.exists()) {
            freqFile.createNewFile();
        }        
    }
    
    private void write(String s, String dir, String filename) throws IOException {
        File file = new File(dir + filename);
        Writer writer = new FileWriter(file, true);
        
        s.chars().mapToObj(c -> (char) c)
                .filter(c -> "aieouAIUOE".contains("" + c))
                .forEach(c -> {
                    try {
                        writer.write(c);
                    } catch (IOException ex) {
                        System.out.println("Cannot write to file");;
                    }
                });        
        writer.write("\n");
        writer.close();
    }
    
    private Map<Character, Long> frequencies(String dir, String filename) throws FileNotFoundException, IOException {
        File file = new File(dir + filename);
        Reader reader = new FileReader(file);
        
        StringBuilder sb = new StringBuilder();
        
        int c;        
        while ((c = reader.read()) != -1) {
            sb.append((char) c);
        }
        
        reader.close();
        
        return sb.chars().mapToObj(x -> (char) x)
                .filter(x -> "aioueAIUOE".contains("" + x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
    }
    
     //saving objects to a file
    public void save(Map<Character, Long> map, String dir, String filename) throws FileNotFoundException, IOException{
        File file = new File(dir + filename);
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        
        objOut.writeObject(map);
        
        objOut.close();
        fileOut.close();        
    }
    
    //reading objects from a file
    public Map<Character, Long> readMap(String dir, String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File(dir + filename);
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        
        Map<Character, Long> map = (Map<Character, Long>) objIn.readObject();
        
        objIn.close();
        fileIn.close();        
        
        return map;
    }
    
    private void showMap(Map<Character, Long> map) {
        map.forEach((k, v) -> System.out.println(k + " --> " + v));        
    }
    
    private String readString() {
        System.out.print("String: ");
        return In.nextLine();
    }
    
    private void map() throws IOException {
        String s;
        
        while (!(s = readString()).equals("*")) {
            write(s, dirString, vowelsString);
        }
    }
    
    public static void main(String[] args) {
        Characters characters = new Characters();
        try {            
            characters.setup();
            characters.map();
            Map<Character, Long> map = characters.frequencies(characters.dirString, characters.vowelsString);
            //characters.showMap(map);
            characters.save(map, characters.dirString, characters.frequenciesString);
            Map<Character, Long> output = characters.readMap(characters.dirString, characters.frequenciesString);
            characters.showMap(output);
        } catch (IOException ex) {
            Logger.getLogger(Characters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Characters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
