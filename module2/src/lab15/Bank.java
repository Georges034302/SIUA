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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class Bank {

    private List<Account> accounts = new ArrayList<>();
    private String dirName = "D:\\GitHub\\SIUA\\module2\\files\\";
    private String fileName = "bank.data";
    private Path dirPath;
    private Path filePath;

    public static void main(String[] args) throws IOException {

        Bank bank = new Bank();
        bank.menu();

    }

    public Bank() throws IOException {
        setup();
    }

    private void view() {
        accounts.forEach(a -> System.out.println(a));
    }

    public void setup() throws IOException {
        dirPath = Paths.get(dirName);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        filePath = Paths.get(dirName + "\\" + fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    private void generate()  {
        for (int i = 0; i < 10; i++) {
            Account a = new Account();
            a.setID(uniqueID());
            accounts.add(a);
        }
    }

    private boolean match(int ID)  {
        accounts = read(filePath);
        return accounts.stream().anyMatch(a -> a.match(ID));
    }

    private int randomID() {
        return new Random().nextInt(999) + 1;
    }

    private int uniqueID()  {
        int ID = randomID();

        while (match(ID)) {
            ID = randomID();
        }
        return ID;
    }

    //lookup by ID
    private Account account(int ID) {
        accounts = read(filePath);
        return accounts.stream().filter(a -> a.match(ID)).findAny().orElse(null);
    }

    private double readAmount() {
        System.out.print("Amount: ");
        return In.nextDouble();
    }

    private int readID() {
        System.out.print("ID: ");
        return In.nextInt();
    }

    private void deposit()  {
        double amount = readAmount();
        Account account = account(readID());
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account does not exist");
        }
        save();
    }

    private void withdraw() {
        double amount = readAmount();
        Account account = account(readID());

        if (account != null) {
            try {
                account.withdaw(amount);
            } catch (InsufficientFunds ex) {
                 System.out.println(Utils.CYAN_BOLD + ex.getMessage() + Utils.WHITE_BOLD);

            }
        } else {
            System.out.println("Account does not exist");
        }
        save();
    }

    private void save()  {
        FileOutputStream fileOut = null;
        try {
            File file = filePath.toFile();
            fileOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(accounts);
            objOut.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private List<Account> read(Path path)  {
        FileInputStream fileIn = null;
        try {
            File file = path.toFile();
            fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<Account> temp = (List<Account>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            return temp;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    private void show() {
        List<Account> temp = read(filePath);
        temp.forEach(System.out::println);
    }

    private char readChoice() {
        System.out.print("Choice(g/d/r/s/v/x): ");
        return In.nextChar();
    }

    private void menu()  {
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'g':
                    generate();
                    break;
                case 'd':
                    deposit();
                    break;
                case 'r':
                    withdraw();
                    break;
                case 's':
                    save();
                    break;
                case 'v':
                    show();
                    break;
                case 'V':
                    view();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("g - generate 10 accounts");
        System.out.println("d - deposit an amount");
        System.out.println("r - withdraw from an amount");
        System.out.println("s - save the account");
        System.out.println("v - view the content");
        System.out.println("x - exit");
    }

}
