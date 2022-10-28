package lecture15;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author George
 */
public class NIODemo {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("D:\\GitHub\\SIUA\\module2\\files\\test.txt");
        
        List<String> words = new ArrayList(Arrays.asList("JAVA","JDK8","NIO"));
        
        Files.write(filePath, words,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        List<String> temp = Files.readAllLines(filePath);
        
//      List<String> temp = Files.lines(filePath)
//                               .map(String::toLowerCase)
//                               .collect(Collectors.toList());
        
        temp.forEach(System.out::println);

    }
    
}
