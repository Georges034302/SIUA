package lecture15;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author George
 */
public class NIODemo {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("D:\\GitHub\\SIUA\\module2\\files\\test.txt");
        
        List<String> words = new ArrayList(Arrays.asList("NIO", "JAVA","JDK8"));
        
        Files.write(filePath, words,StandardOpenOption.APPEND);
        
        List<String> temp = Files.readAllLines(filePath);
        
        temp.forEach(System.out::println);
        
    }
    
}
