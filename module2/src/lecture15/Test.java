/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture15;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author George
 */
public class Test {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("Java8","JDK8","J8","J11");
        //Pattern regex = Pattern.compile("[A-Z][0-9]");
        String s = "Java OOP Streaming";
        System.out.println(
                s.chars()                
                .mapToObj(c -> (char)c)
                .filter(c -> "aiuoe".contains(""+c))
                .collect(Collectors.toList()));
    }
}
