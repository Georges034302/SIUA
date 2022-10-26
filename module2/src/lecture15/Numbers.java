package lecture15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author George
 */
public class Numbers {

    private String numbersfile = "numbers.data";
    private String evensfile = "evens.data";
    private String oddsfile = "odds.data";

    private List<Integer> numbers() {
        return (new Random()).ints(0, 101)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
    }

    private void save(List<Integer> list, String filename) throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

        objOut.writeObject(list);

        objOut.close();
        fileOut.close();
    }

    private List<Integer> readValues(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        List<Integer> temp = (List<Integer>) objIn.readObject();

        objIn.close();
        fileIn.close();

        return temp;
    }

    private List<Integer> unique(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    private List<Integer> evens(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    private List<Integer> odds(List<Integer> list) {
        return list.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    private void show(List<Integer> list) {
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        Numbers n = new Numbers();
        List<Integer> numbers = n.numbers();
        try {
            n.save(numbers, n.numbersfile);
        } catch (IOException ex) {
            System.out.println("Cannot write to file");
        }
        
        try {
            List<Integer> unique = n.unique(n.readValues(n.numbersfile));
            List<Integer> evens = n.evens(unique);
            List<Integer> odds = n.odds(unique);
            n.save(evens, n.evensfile);
            n.save(odds, n.oddsfile);
            n.show(n.readValues(n.evensfile));
            n.show(n.readValues(n.oddsfile));
        } catch (IOException ex) {
             System.out.println("Cannot read from file");
        } catch (ClassNotFoundException ex) {
             System.out.println("Cannot map file object to list");
        }
    }
}
