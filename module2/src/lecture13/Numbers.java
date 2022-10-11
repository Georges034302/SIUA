/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author George
 */
public class Numbers {

    private List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(new Random().nextInt(20));
        }
        return numbers;
    }
    
    //take every integer from the list numbers convert to string and add it to temp
    private List<String> strings(List<Integer> numbers){
        List<String> temp = new ArrayList();
        numbers.forEach(n -> temp.add(n+""));
        return temp;
    }

    private void show(List<Integer> numbers) {
        for (Object n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }   
    
    //functional interface that consumes a string and produces and integer
    interface Convertor{
        int convert(String s);
    }
    
    //we have a list of numerical strings and want to convert it to integers
    private List<Integer> stringToInt(List<String> list){
        List<Integer> temp = new ArrayList<>();
        
        Convertor c1 = (s) -> Integer.parseInt(s) + 10; //specified the implemention code of the functional interface
        /*
            public int convert(String s){
                return Integer.parseInt(s)+10;
            }
        */

        Convertor c2 = (s) -> Integer.parseInt(s) * 5;
        
        list.forEach(s -> temp.add(c1.convert(s) + c2.convert(s)));
        return temp;
    }

    public static void main(String[] args) {
        Numbers number = new Numbers();
        List<Integer> numbers = number.numbers();        
        //number.show(numbers); //using traditional for-loop
        //numbers.forEach((obj) -> System.out.println(obj+" ") ); //using forEach() with lambda
        //System.out.println();
        
        List<String> strings = number.strings(numbers);
        strings.forEach(s -> System.out.print(s+" ")); //printing the string numbers
        System.out.println();
        
        List<Integer> convertedlist = number.stringToInt(strings);
        convertedlist.forEach(n -> System.out.print(n+" ")); //printing the strings converted back to numbers
        System.out.println();
        
    }

}
