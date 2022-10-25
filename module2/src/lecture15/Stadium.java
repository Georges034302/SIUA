package lecture15;

/**
 *
 * @author George
 */
public class Stadium {
    private int capacity;

    public Stadium(int capacity) {
        this.capacity = capacity;
    }
    
    public void book(int number) throws NotEnoughSeatsException {
        if(number > capacity)
            throw new NotEnoughSeatsException("Not enough seats");
        this.capacity -= number;
    }

    @Override
    public String toString() {
        return "Stadium{" + "capacity=" + capacity + '}';
    }   
    
}
