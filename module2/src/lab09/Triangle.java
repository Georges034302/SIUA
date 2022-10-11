package lab09;


public class Triangle extends Polygon{
    private double height;
    private double base;
    
    public Triangle(double height, double base){
        //Must use the super-class constructor inside the sub-class constructor to create the object
        super("Triangle"); 
        this.height = height;
        this.base = base;
    }
    
    @Override
    public double area(){
        return (height*base)/2;
    }
    
    @Override
    public String toString(){
        return String.format("%-8s area = %-6.2f",this.type,area());
    }
}
