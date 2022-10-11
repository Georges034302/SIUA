
public class Shapes{
    public static void main(String[] args){
        (new Shapes()).show();
    }
    
    private Polygon[] shapes;
    
    public Shapes(){
        this.shapes = new Polygon[4]; //initialize array of size 4
        loadShapes();
    }
    
    private void loadShapes(){
        shapes[0] = new Square(5);
        shapes[1] = new Square(10);
        shapes[2] = new Triangle(5,3);
        shapes[3] = new Triangle(5,5);
    }
    
    private void show(){
        for(Polygon p:shapes)
            System.out.println(p);
    }
}
