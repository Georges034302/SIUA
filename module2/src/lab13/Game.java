package lab13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author George
 */
public class Game {

    private List<Player> players = new ArrayList<>();
    
    private void play() {
        int index = players.size();
        for (int i = index; i < index+5; i++) {
            players.add(Factory.player(i+1));
        }
    }

    private void rank() {
        Collections.sort(players, new PlayerComparator());
    }

    private void show() {
        players.forEach(player -> player.show());
    }

    private char readChoice() {
        System.out.print("Choice(p/r/s/x): ");
        return In.nextChar();
    }

    private void menu() {
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'p':
                    play();
                    break;
                case 'r':
                    rank();
                    break;
                case 's':
                    show();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("p - play");
        System.out.println("r - rank");
        System.out.println("s - show");
        System.out.println("x - exit");
    }

    public static void main(String[] args) {
        (new Game()).menu();
    }
}


