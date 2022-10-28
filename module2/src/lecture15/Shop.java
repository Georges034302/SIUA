package lecture15;

import java.io.EOFException;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class Shop {

    private List<Product> products = new ArrayList<>();
    private String dirString = "D:\\GitHub\\SIUA\\module2\\files";
    private String fileString = "products.data";
    private Path dirPath;
    private Path filePath;

    public static void main(String[] args) throws EOFException{
        Shop shop = new Shop();
        
        try {
            shop.setup();
            shop.menu();
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Shop() {
        
    }

    private void populate() {
        products.add(new Product("Blue pen", 10, 4.5));
        products.add(new Product("Red pen", 5, 4.5));
        products.add(new Product("Black Tape", 10, 5.5));
        products.add(new Product("Blue Tape", 5, 5.5));
        products.add(new Product("Red Tape", 15, 4.5));
        products.add(new Product("Red Book", 5, 22.5));
        products.add(new Product("Green Book", 15, 24.5));
    }

    private void setup() throws IOException {
        dirPath = Paths.get(dirString);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        filePath = Paths.get(dirPath.toString() + "\\" + fileString);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    private void save(Path path, List<Product> list) throws FileNotFoundException, IOException {
        File file = path.toFile();
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(list);

        objectOut.close();
        fileOut.close();
    }

    //action to use in the menu
    private void save() throws IOException {
        save(filePath, products);
    }

    private List<Product> read(Path path) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = path.toFile();
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        List<Product> list = (List<Product>) objectIn.readObject();

        objectIn.close();
        fileIn.close();

        return list;
    }

    private void read() throws IOException, FileNotFoundException, ClassNotFoundException {
        List<Product> list = read(filePath);
        show(list);
    }

    private void show(List<Product> list) {
        list.forEach(p -> System.out.println(p));
    }
    
    private void show() throws IOException, FileNotFoundException, ClassNotFoundException{
        read();
    }
    
    private void clear() throws FileNotFoundException, IOException{
        File file = filePath.toFile();
        FileOutputStream fileOut = new FileOutputStream(file, false);
        fileOut.flush();
        fileOut.close();
    }

    private char readChoice() {
        System.out.print("Choice(p/s/r/c/v/x): ");
        return In.nextChar();
    }

    private void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {

                case 'v':
                    show();
                    break;
                case 's':
                    save();
                    break;
                case 'r':
                    read();
                    break;
                case 'c':
                    clear();
                    break;
                case 'p':
                    populate();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {

        System.out.println("v - Show all Products");
        System.out.println("p - populate the product list");
        System.out.println("s - save products data to file");
        System.out.println("r - read products from file");
        System.out.println("c - clear products file data");
        System.out.println("x - exit");
    }

}
