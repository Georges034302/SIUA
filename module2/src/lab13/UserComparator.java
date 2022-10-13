/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13;

import java.util.Comparator;

/**
 *
 * @author George
 */
public class UserComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getID() - o2.getID();
    }    
}
