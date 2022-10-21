package lab14;

/**
 *
 * @author George
 */
public class Point {
    private int x;
    private int y;    

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int distance(Point point){
        return (int)Math.sqrt(Math.pow(this.x - point.x, 2)+ Math.pow(this.y - point.y, 2));
    }
    
    public boolean coincide(Point point){
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }    
}
