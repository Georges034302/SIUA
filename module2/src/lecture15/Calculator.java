package lecture15;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Calculator {

    private String resultString = "result.txt";
    private String errorString = "error.txt";
    private String dirString = "D:\\GitHub\\SIUA\\module2\\files";
    private Path resultPath;
    private Path errorPath;
    private Path dirPath;

    public static void main(String[] args) throws IOException {
        Calculator c = new Calculator();
        c.setup(); //setup the firectory and files
        c.calculate();
        c.show(c.resultPath);
        c.show(c.errorPath);
    }

    
    private List<Arithmetic> numbers() {
        return Stream.generate(() -> new Arithmetic()).limit(10).collect(Collectors.toList());
    }

    private void setup() throws IOException {
        dirPath = Paths.get(dirString);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        resultPath = Paths.get(dirPath.toString() + "\\" + resultString);
        if (!Files.exists(resultPath)) {
            Files.createFile(resultPath);
        }

        errorPath = Paths.get(dirPath.toString() + "\\" + errorString);
        if (!Files.exists(errorPath)) {
            Files.createFile(errorPath);
        }
    }

    private void save(List<String> list, Path path) throws IOException {
        Files.write(path, list, StandardOpenOption.APPEND); //save a list to a file
    }

    private List<String> read(Path path) throws IOException {
        return Files.readAllLines(path); // read a list from a file
    }

    private void calculate() throws IOException {
        List<String> results = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        List<Arithmetic> numbers = numbers();

        for (Arithmetic a : numbers) {
            try{
                results.add(a.toString()); //caculate and save the toString result to a list
            }catch(ArithmeticException ex){
                errors.add(ex.getMessage()); //save the error object to a list
            }
        }
        
        save(results, resultPath); //save the result list to file
        save(errors, errorPath); //save the error list to file
    }
    
    private void show(Path path) throws IOException{
        List<String> output = Files.readAllLines(path); //read any file
        output.forEach(s -> System.out.println(s)); //show the results
    }
    
}
