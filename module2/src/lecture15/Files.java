package lecture15;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author George
 */
public class Files {
    public static void main(String[] args) throws IOException {
        String filename = "strings.txt";
        String anotherfile = "words.txt";
        String dirpath = "D:\\GitHub\\SIUA\\module2\\files\\demo\\";
        
        File directory = new File(dirpath);
        directory.mkdirs();
        if(directory.exists()){
            File file = new File(dirpath+filename);
            File file2 = new File(dirpath+anotherfile);
            file.createNewFile();
            file2.createNewFile();
            System.out.println(Arrays.toString(directory.list()));
        }   
        
    }
}
