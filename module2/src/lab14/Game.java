package lab14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Game {

    private List<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    private void play() {
        for (int i = 0; i < 200; i++) {
            this.players.add(new Player(i));
        }
    }

    private Map<Integer, List<Player>> organized() {
        return players.stream().collect(Collectors.groupingBy(Player::getScore));
    }

    private void group() {
        Map<Integer, List<Player>> map = organized();
        map.forEach((k, v) -> System.out.printf("%2d-->%-12s %n", k, v));
    }

    private List<Player> topten() {
        Collections.sort(players, new PlayerComparator());
        return players.stream().limit(10).collect(Collectors.toList());
    }

    private void showTopTen() {
        topten().forEach(System.out::println);
    }

    private void reset() {
        players.clear();
    }

    private char readChoice() {
        System.out.print("Choice(p/g/r/s/x): ");
        return In.nextChar();
    }

    private void menu() {
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'p':
                    play();
                    break;
                case 'g':
                    group();
                    break;
                case 'r':
                    reset();
                    break;
                case 's':
                    showTopTen();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("p - Play");
        System.out.println("g - group");
        System.out.println("r - reset");
        System.out.println("s - top ten");
        System.out.println("x - exit");
    }

    public static void main(String[] args) {
        (new Game()).menu();
    }

}
