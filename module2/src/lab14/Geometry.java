package lab14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Geometry {

    private List<Point> points = new ArrayList<>();
    private List<Distance> distances = new ArrayList<>();

    public Geometry() {
    }

    private int randomInt() {
        return new Random().nextInt(10);
    }

    private void generate() {
        Stream<Point> stream = Stream.generate(() -> new Point(randomInt(), randomInt())).limit(5);
        points.addAll(stream.collect(Collectors.toList()));
    }

    private void populate() {
        for(Point p1:points){
            for(Point p2:points)
                if(!p1.coincide(p2))
                    distances.add(new Distance(p1, p2));
        }
//        points.forEach(p1 -> {
//            points.stream().filter(p2 -> (!p1.coincide(p2))).forEachOrdered(p2 -> {
//                distances.add(new Distance(p1, p2));
//            });
//        });
    }
    
    private Map<Integer,List<Distance>> distanceMap(){
        return distances.stream().collect(Collectors.groupingBy(Distance::getDistance));
    }
    
    private void showPoints(){
        points.forEach(System.out::println);
    }
    
    private void showMap(){
        distanceMap().forEach((k , v) -> System.out.printf("%3d --> %15s %n",k,v));
    }
    
    public static void main(String[] args) {
        Geometry g = new Geometry();
        g.generate();
        g.populate();
        g.showPoints();
        g.showMap();                
    }
}
