package lab15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author George
 */
public class Operations {

    public void setup() throws IOException {
        Path sourcePath = Paths.get(Utils.SOURCE_STRING);
        if (!Files.exists(sourcePath)) {
            Files.createDirectories(sourcePath);
        } else {
            System.out.println("Source directory exists");
        }

        Path destinationPath = Paths.get(Utils.DESTINATION_STRING);
        if (!Files.exists(destinationPath)) {
            Files.createDirectories(destinationPath);
        } else {
            System.out.println("Destination directory exists");
        }
    }

    public void createFile(String dirName, String fileName) throws IOException {
        Path dirPath = Paths.get(dirName);
        if (Files.exists(dirPath)) {
            Path filePath = Paths.get(dirName + "\\" + fileName);

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            } else {
                System.out.println(fileName + " already exists");
            }
        }else
            System.out.println(dirName + " does not exist");
    }

    public void copy(String sourceDirName, String destinationDirName, String fileName, String copyFileName) throws IOException {
        Path sourcePath = Paths.get(sourceDirName + "\\" + fileName);
        Path destinationPath = Paths.get(destinationDirName + "\\" + copyFileName);

        if (Files.exists(sourcePath)) {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            if (Files.exists(destinationPath)) {
                System.out.println(copyFileName + " was successfully copied");
            } else {
                System.out.println("Copy operation was unsuccessful");
            }
        } else {
            System.out.println(fileName + " does not exist");
        }

    }

    public void move(String sourceDirName, String destinationDirName, String fileName, String copyFileName) throws IOException {
        Path sourcePath = Paths.get(sourceDirName + "\\" + fileName);
        Path destinationPath = Paths.get(destinationDirName + "\\" + copyFileName);

        if (Files.exists(sourcePath)) {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            if (Files.exists(destinationPath)) {
                System.out.println(copyFileName + " was successfully copied");
            } else {
                System.out.println("Copy operation was unsuccessful");
            }
        } else {
            System.out.println(fileName + " does not exist");
        }
    }

    public List<String> readStrings(String dirName, String fileName) throws IOException {
        Path filePath = Paths.get(dirName + "\\" + fileName);
        List<String> temp = new ArrayList<>();
        if (Files.exists(filePath)) {
            temp = Files.readAllLines(filePath);
        } else {
            System.out.println(fileName + " does not exist");
        }
        return temp;
    }

    public void show(String dirName, String fileName) throws IOException {
        List<String> temp = readStrings(dirName, fileName);
        temp.forEach(System.out::println);
    }

    private String reaString() {
        System.out.print("String: ");
        return In.nextLine();
    }

    public void write(List<String> list, String dirName, String fileName) throws IOException {
        Path filePath = Paths.get(dirName + "\\" + fileName);
        if (Files.exists(filePath)) {
            Files.write(filePath, list, StandardOpenOption.APPEND);
        } else {
            System.out.println(fileName + " does not exist");
        }
    }

    public void save(String dirName, String fileName) throws IOException {
        String s;
        List<String> temp = new ArrayList<>();
        while (!(s = reaString()).equals("*")) {
            temp.add(s);
        }
        write(temp, dirName, fileName);
    }

    public void deleteFile(String dirName, String fileName) throws IOException {
        Path filePath = Paths.get(dirName + "\\" + fileName);
        if (Files.deleteIfExists(filePath)) {
            System.out.println(fileName + " succesfully deleted");
        } else {
            System.out.println(fileName + " does not exist");
        }
    }

    public void deleteDirectory(String dirName) throws IOException {
        Path dirPath = Paths.get(dirName);
        if (Files.deleteIfExists(dirPath)) {
            System.out.println(dirName + " succesfully deleted");
        } else {
            System.out.println(dirName + " does not exist");
        }
    }

}
