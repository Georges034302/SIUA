/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture15;

/**
 *
 * @author George
 */
public class NotEnoughSeatsException extends Exception{

    public NotEnoughSeatsException(String error) {
        super(error);
    }
    
}
