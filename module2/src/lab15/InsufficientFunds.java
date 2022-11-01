/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab15;

/**
 *
 * @author George
 */
public class InsufficientFunds extends Exception{
    public InsufficientFunds(String error){
        super(error);
    }
}
