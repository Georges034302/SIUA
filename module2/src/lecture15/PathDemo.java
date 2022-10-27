package lecture15;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author George
 */
public class PathDemo {
    public static final String RED_BOLD = "\033[1;31m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String WHITE_BOLD = "\033[1;37m";
    
    public static void main(String[] args) throws IOException  {
        Path sourcedir = Paths.get("D:\\GitHub\\SIUA\\module2\\demo\\");
        Path destinationdir = Paths.get("D:\\GitHub\\SIUA\\module2\\files\\");
               
        if(!Files.exists(sourcedir)){
            Files.createDirectories(sourcedir);
        }
        if(!Files.exists(destinationdir)){
            Files.createDirectories(destinationdir);
        }
                
        Path sourceFile = Paths.get(sourcedir.toString()+"\\demo.txt");
        try{
            Files.createFile(sourceFile);
        }catch(FileAlreadyExistsException ex){
            System.out.println(RED_BOLD+"File already exists"+WHITE_BOLD);
        }
        
        Path destinationFile = Paths.get(destinationdir.toString()+"\\demo2.txt");
        Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        
        Path moveback = Paths.get(sourcedir.toString()+"\\moveback.txt");
        Files.move(destinationFile, moveback, StandardCopyOption.REPLACE_EXISTING);
       
//        if(!Files.exists(newPath)){
//            Files.createFile(newPath);
//            System.out.println("Absolute path: "+newPath.toAbsolutePath().toString());
//        }else{
//            
//        }
        
        
        //Files.createFile(path); //actually creating the file
    }
    
}
