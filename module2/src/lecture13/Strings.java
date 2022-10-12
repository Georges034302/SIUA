/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author George
 */
public class Strings {
    static List<String> strings(){
        return new ArrayList<>(Arrays.asList("Lambda","referencing","is","fun"));
    }  
    
    static void show(String s){
        System.out.println(s);       
    }
    
    void view(String s){
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        Strings strings = new Strings();
        
        List<String> list = strings();  
        
        list.forEach(s -> System.out.println(s)); //using lambda
        System.out.println();
        list.forEach(System.out::println); //using method referencing
        System.out.println();
        
        list.forEach(Strings::show); //static referencing
        list.forEach(strings::view); //object referencing 

    }
}
