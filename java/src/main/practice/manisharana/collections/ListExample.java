package main.practice.manisharana.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListExample {

    public static void main(String[] args) {
        ArrayList<Integer> list = IntStream.range(50, 70).boxed().collect(Collectors.toCollection(ArrayList::new));

        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext())
            System.out.print(iterator.next() + "\t");

        System.out.println("\n");

        list.remove(2);             /*Remove by index*/
        list.remove(Integer.valueOf(55)); /*Remove by value from Integer list*/

        /*Initialize iterator with size*/
        ListIterator<Integer> listIterator = list.listIterator(list.size());

        while (listIterator.hasPrevious())
            System.out.print(listIterator.previous() + "\t");


    }
}
