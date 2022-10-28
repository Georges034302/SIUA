
package lecture15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Strings {
    private String stringFile = "strings.txt";
    private String mapFile = "map.data";
    private String dirFile = "D:\\GitHub\\SIUA\\module2\\files";
    private Path stringPath;
    private Path mapPath;
    private Path dirPath;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Strings s = new Strings();
        s.setup();
        
        List<String> temp = s.strings();
        s.write(temp, s.stringPath);
        List<String> list = s.read(s.stringPath);
        list.forEach(w -> System.out.println(w)); 
        System.out.println();
        Map<Integer, List<String>> map = s.map(list);
        System.out.println();
        s.save(map, s.mapPath);
        Map<Integer, List<String>> tempMap = s.readMap(s.mapPath);
        s.showMap(tempMap);
    }
    
    private void setup() throws IOException{
        dirPath = Paths.get(dirFile);
        if(!Files.exists(dirPath))
            Files.createDirectories(dirPath);
        
        stringPath = Paths.get(dirPath.toString()+"\\"+stringFile);
        if(!Files.exists(stringPath))
            Files.createFile(stringPath);
        
        mapPath = Paths.get(dirPath.toString()+"\\"+mapFile);
        if(!Files.exists(mapPath))
            Files.createFile(mapPath);
    }
    
    private void write(List<String> list, Path filePath) throws IOException{
        Files.write(filePath, list, StandardOpenOption.APPEND);
    }
    
    private List<String> read(Path filePath) throws IOException{
        return Files.readAllLines(filePath);
    }    
    
    private String readString() {
        System.out.print("String: ");
        return In.nextLine();
    }     
     
    private List<String> strings(){
        List<String> list = new ArrayList<>();
        String s;
        
        while(!(s = readString()).equals("*")){
            list.add(s);
        }
        return list;
    }
    
    private int vowelCount(String s){
        return (int)s.chars().mapToObj(c -> (char)c).filter(c -> "AEIOUaeiou".contains(""+c)).count();
    }
    
    private Map<Integer, List<String>> map(List<String> list){
        Map<Integer,List<String>> temp = new HashMap<>();
        
        for(String s:list){
            int key = vowelCount(s);
            List<String> value = temp.get(key);
            
            if(temp.containsKey(key)){
                value.add(s);
                temp.put(key, value); //updating the associated value
            }else{
                List<String> newvalue = new ArrayList<>();
                newvalue.add(s);
                temp.put(key, newvalue); //new entry in the map with new key
            }
        }
        return temp;
        //    return list.stream().collect(Collectors.groupingBy(s->vowelCount(s)));
    }
    
    private void showMap(Map<Integer, List<String>> map){
        map.forEach((k , v) -> System.out.println(k+"--> "+v));
    }
    
     //saving objects to a file
    public void save(Map<Integer, List<String>> map, Path filePath) throws FileNotFoundException, IOException{
        //File file = new File(dir + filename);
        File file = filePath.toFile();
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        
        objOut.writeObject(map);
        
        objOut.close();
        fileOut.close();        
    }
    
    //reading objects from a file
    public Map<Integer, List<String>> readMap(Path filePath) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = filePath.toFile();
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        
        Map<Integer, List<String>> map = (Map<Integer, List<String>>) objIn.readObject();
        
        objIn.close();
        fileIn.close();        
        
        return map;
    }
    
}
