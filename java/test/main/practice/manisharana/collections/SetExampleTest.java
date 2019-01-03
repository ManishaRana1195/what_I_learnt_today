package main.practice.manisharana.collections;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.TreeSet;

import static org.testng.Assert.*;

public class SetExampleTest {

    @Test(expected = ConcurrentModificationException.class)
    public void should_raise_exception_when_set_is_modified(){
        TreeSet<String> set = getSetData();

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            set.remove("crill");
        }
    }

    private TreeSet<String> getSetData() {
        TreeSet<String> set = new TreeSet<>();
        set.add("python");
        set.add("mango");
        set.add("wobbuffet");
        set.add("crill");
        return set;
    }

    @Test
    public void should_not_raise_exception_when_set_is_modified(){
        TreeSet<String> set = getSetData();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("mango")){
                iterator.remove();
            }
            System.out.println(next);
        }

        assertEquals(set.size(), 3);
    }

}