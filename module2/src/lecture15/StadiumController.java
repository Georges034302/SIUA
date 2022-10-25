package lecture15;

/**
 *
 * @author George
 */
public class StadiumController {
    private Stadium stadium;

    public StadiumController() {
        this.stadium = new Stadium(100);
    }
    
    private int readNumber(){
        System.out.print("Number of Seats to Book: ");
        return In.nextInt();
    }
    
    public void book() throws NotEnoughSeatsException {
        int number = readNumber();        
        stadium.book(number);
    }
    
}
