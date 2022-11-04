package lab16;

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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static lab16.LmbdaExecutor.numbers;
import static lab16.LmbdaExecutor.show;

/**
 *
 * @author George
 */
public class Game {
    
    private List<Player> players;
    private String dirString = "D:\\GitHub\\SIUA\\module2\\files\\";
    private Path dirPath;
    private int index;
    
    public Game() {
        players = new ArrayList<>();
    }
    
    private void play() {
        players = Stream.iterate(1, x -> x + 1)
                .limit(50)
                .map(x -> new Player(x))
                .collect(Collectors.toList());
    }
    
    private void setup() throws IOException {
        dirPath = Paths.get(dirString);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }
    }
    
    private Path filePath(int n) {
        return Paths.get(dirString + "\\" + "game_" + n + ".data");
    }
    
    private void save(int n) {
        FileOutputStream fOut = null;
        ObjectOutputStream objOut = null;
        try {
            Path path = filePath(n);
            File file = path.toFile();
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            fOut = new FileOutputStream(file);
            objOut = new ObjectOutputStream(fOut);
            
            objOut.writeObject(players);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                objOut.close();
                fOut.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void show(int n) {
        FileInputStream fIn = null;
        ObjectInputStream objIn = null;
        try {
            Path path = filePath(n);
            File file = path.toFile();
            
            fIn = new FileInputStream(file);
            objIn = new ObjectInputStream(fIn);
            
            List<Player> list = (List<Player>) objIn.readObject();
            
            list.forEach(System.out::println);
            
        } catch (FileNotFoundException ex) {
            System.out.println("File game_" + n + ".data does not exist");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                objIn.close();
                fIn.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private List<Runnable> writeTasks(int size) {
        List<Runnable> tasks = new ArrayList<>();
        //        index = 0;
        //        for (int i = 0; i < size; i++) {   
        //            index = 0;
        //            tasks.add(new Thread(() -> {               
        //                play();
        //                save(index+1);
        //                index++;
        //            }));
        //            
        //        }
        tasks.addAll(Stream.iterate(1, x -> x + 1).limit(3)
                .map(x -> new Thread(() -> {            
            play();
            save(x);
        }))
                .collect(Collectors.toList())
        );
        return tasks;
    }
    
    static ScheduledExecutorService service() {
        return Executors.newSingleThreadScheduledExecutor();
    }
    
    private List<Runnable> readTasks(int size) {
        List<Runnable> tasks = new ArrayList<>();
//        index = 0;
//        for (int i = 0; i < size; i++) {
//            index = 0;
//            tasks.add(new Thread(() -> {
//                show(index + 1);
//                index++;
//            }));
//
//        }
        tasks.addAll(Stream.iterate(1, x -> x + 1).limit(3)
                .map(x -> new Thread(() -> {
            show(x);
        }))
                .collect(Collectors.toList())
        );
        return tasks;
    }
    
    private void execute(List<Runnable> tasks, ScheduledExecutorService es) {
        long delay = 1000;
        int i = 1;
        for (Runnable task : tasks) {
            es.schedule(task, i * delay, TimeUnit.MILLISECONDS);
            i++;
        }
        
    }
    
    public static void main(String[] args) {
        Game g = new Game();
        ScheduledExecutorService ses = service();
        
        List<Runnable> writeTasks = g.writeTasks(3);
        g.execute(writeTasks, ses);
        
        List<Runnable> readTasks = g.readTasks(3);
        g.execute(readTasks, ses);
        
        ses.shutdown();
    }
}
