import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Random;

public class SetsOps{
    public static HashSet<String> hashSet(){
        HashSet<String> set = new HashSet();
        HashSet<String> set2 = new HashSet(Arrays.asList("Jim","Lucy"));
        return set2;
    }

    public static TreeSet<Integer> treeSet(){
        TreeSet<Integer> tree = new TreeSet();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(3);
        return tree;
    }

    public static void show(HashSet<String> set){
        System.out.println(Arrays.toString(set.toArray()));
    }

    public static void show(TreeSet<Integer> set){
        System.out.println(Arrays.toString(set.toArray()));
    }

    public static void showItr(HashSet<String> set){
        Iterator<String> itr=set.iterator();
        while(itr.hasNext()){    
            System.out.print(itr.next()+" ");    
        } 
    }

    public static void showItr(TreeSet<Integer> set){
        Iterator<Integer> itr=set.iterator();
        while(itr.hasNext()){    
            System.out.print(itr.next()+" ");    
        } 
    }

    public static void main(String[] args){
        SetsOps.show(treeSet());
        SetsOps.showItr(treeSet());
        //hashSet().forEach(System.out::println);
        for(Integer x: treeSet())
            System.out.print(x+" ");
    }

}
