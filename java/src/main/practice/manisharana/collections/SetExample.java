package main.practice.manisharana.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("aero");
        treeSet.add("zip");
        treeSet.add("vanilla");
        treeSet.add("blanca");

        Iterator<String> iterator = treeSet.iterator();
        System.out.println("Ordered:");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*descending itr*/
        Iterator<String> descendingIterator = treeSet.descendingIterator();
        System.out.println("\nReverse:");
        while (descendingIterator.hasNext()){
            System.out.println(descendingIterator.next());
        }
            

    }
}
