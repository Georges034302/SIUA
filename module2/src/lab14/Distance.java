package lab14;

/**
 *
 * @author George
 */
public class Distance {
    private Point p1;
    private Point p2;
    private int distance;

    public Distance(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = p1.distance(p2);
    }    

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Distance{" +  p1 + ", " + p2 + " = " + distance + "}";
    }    
}
