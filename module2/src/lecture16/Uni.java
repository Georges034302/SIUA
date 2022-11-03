package lecture16;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Uni {
    private List<Student> students = new ArrayList<>();
    private String fileString = "students.txt";
    private String diString = "D:\\GitHub\\SIUA\\module2\\files";
    private Path filePath;
    private Path dirPath;
        
    public static void main(String[] args)  {
        Uni uni = new Uni();
        uni.setup();
        uni.register();
        uni.save(uni.filePath);
        uni.show(uni.filePath);
    }
    
    public Uni(){}
    
    private void setup() {
        try {
            dirPath = Paths.get(diString);
            if(!Files.exists(dirPath))
                Files.createDirectories(dirPath);
            
            filePath = Paths.get(diString+"\\"+fileString);
            if(!Files.exists(filePath))
                Files.createFile(filePath);
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void register(){
        students.addAll(Stream.generate(() -> new Student()).limit(50).collect(Collectors.toList()));
    }
    
    private void save(String s, Path path) {
        Writer writer = null;
        try {
            writer = new FileWriter(path.toFile(),true);
            writer.write(s);
            writer.write("\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void save(Path path){
        students.parallelStream().forEach(s -> {
            save(s.toString(),path);
        });
    }
    
    private void show(Path path) {
        try {
            List<String> list = Files.readAllLines(path);
            list.parallelStream().forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(Uni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
