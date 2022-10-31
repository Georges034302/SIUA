package lab15;

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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Game {

    List<Player> players = new ArrayList<>();
    private String dirString = "D:\\GitHub\\SIUA\\module2\\files\\";
    private String fileString = "game.data";
    private Path dirPath;
    private Path filePath;

    public static void main(String[] args) {
        Game game = new Game();

        try {
            game.setup();
            game.menu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Game() {
    }

    private void setup() throws IOException {
        dirPath = Paths.get(dirString);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        filePath = Paths.get(dirString + "\\" + fileString);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    private void play() throws IOException, FileNotFoundException, ClassNotFoundException {
        players.clear();
        players.addAll(readPlayers(filePath));
        int index = players.size();
        players.addAll(Stream.iterate(index+1, x -> x + 1).limit(10)
                .map(x -> new Player(x))
                .collect(Collectors.toList()));

//        for (int i = 0; i < 10; i++) {
//            players.add(new Player(i));
//        }
    }

    private void save(List<Player> list, Path path) throws FileNotFoundException, IOException {
        File file = path.toFile();
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

        objOut.writeObject(list);

        objOut.close();
        fileOut.close();
    }

    private void save() throws IOException {
        save(players, filePath);
    }

    private List<Player> readPlayers(Path path) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = path.toFile();
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        List<Player> temp = (List<Player>) objectIn.readObject();

        objectIn.close();
        fileIn.close();

        return temp;
    }

    private void show() throws IOException, FileNotFoundException, ClassNotFoundException {
        List<Player> temp = readPlayers(filePath);
        temp.forEach(System.out::println);
    }

    private void clear() throws FileNotFoundException, IOException {
        File f = filePath.toFile();
        FileOutputStream fOut = new FileOutputStream(f);
        ObjectOutputStream objOut = new ObjectOutputStream(fOut);
        objOut.writeObject(new ArrayList<Player>());
        players.clear();
        //fOut.flush();
        objOut.close();
        fOut.close();
    }

    private char readChoice() {
        System.out.print("Choice(p/s/v/c/x): ");
        return In.nextChar();
    }

    private void menu() throws IOException, ClassNotFoundException {
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'p':
                    play();
                    break;
                case 's':
                    save();
                    break;
                case 'v':
                    show();
                    break;
                case 'c':
                    clear();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("p - play");
        System.out.println("s - save");
        System.out.println("v - show");
        System.out.println("c - clear");
        System.out.println("x - exit");
    }

}
