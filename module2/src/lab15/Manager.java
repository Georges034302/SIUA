package lab15;

import java.io.IOException;
/**
 *
 * @author George
 */
public class Manager {
    private Operations op;
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        try {
            manager.menu();
        } catch (IOException ex) {
            System.out.println(Utils.RED_BOLD+"Cannot Open File for I/O"+Utils.WHITE_BOLD);
        }
    }
    
    public Manager(){
        op = new Operations();
    }
    
    private char readChoice() {
        System.out.print("Choice(F/f/D/d/c/m/s/r/x): ");
        return In.nextChar();
    }

    private String readFile(){
        System.out.print("File Name: ");
        return In.nextLine()+".txt";
    }
    
    private String readDirectory(){
        System.out.print("Directory Name: ");
        return In.nextLine();
    }
    
    private void createDirectory() throws IOException{
        op.setup();
    }
    
    private void createFile() throws IOException{
        op.createFile(Utils.SOURCE_STRING, readFile());
    }
    
    private void deleteDirectory() throws IOException{
        op.deleteDirectory(readDirectory());
    }
    
    private void deleteFile() throws IOException{
        op.deleteFile(Utils.SOURCE_STRING, readFile());
    }
    
    private void copyFile() throws IOException{
        op.copy(Utils.SOURCE_STRING, Utils.DESTINATION_STRING, readFile(), readFile());
    }
    
    private void moveRename() throws IOException{
        op.move(Utils.SOURCE_STRING, Utils.DESTINATION_STRING, readFile(), readFile());
    }
    
    private void save() throws IOException{
        op.save(Utils.SOURCE_STRING, readFile());
    }
    
    private void readShow() throws IOException{
        op.show(Utils.SOURCE_STRING, readFile());
    }

    private void menu() throws IOException {
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'F': createDirectory(); break;
                case 'f': createFile(); break;
                case 'D': deleteDirectory(); break;
                case 'd': deleteFile();break;
                case 'c': copyFile();break;
                case 'm': moveRename();break;
                case 's': save();break;
                case 'r': readShow();break;
                default:  help(); break;
            }
        }
    }

    private void help() {
        System.out.println("F - Create Directory");
        System.out.println("f - Create File");
        System.out.println("D - Delete Directory");
        System.out.println("d - Delete File");
        System.out.println("c - Copy File");
        System.out.println("m - Move/Rename File");
        System.out.println("s - Save Text to File");
        System.out.println("r - Read and Show File Contents");
        System.out.println("x - exit");
    }
}
