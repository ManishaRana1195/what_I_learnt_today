package main.practice.manisharana.collections;

import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.SortedSet;
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
        set.add("angle");
        return set;
    }

    @Test
    public void should_not_raise_exception_when_set_is_modified(){
        TreeSet<String> set = getSetData();
        Iterator<String> iterator = set.iterator();

        int size = set.size();
        while(iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("mango")){
                iterator.remove();
            }
            System.out.println(next);
        }

        assertEquals(set.size(), size-1);
    }

    @Test
    public void should_return_subset_elements(){
        TreeSet<String> set = getSetData();
        TreeSet<String> expected = new TreeSet<>();
        expected.add("python");
        expected.add("mango");

        SortedSet<String> actual = set.subSet("mango", "wobbuffet");

        assertEquals(actual,expected);
    }

    @Test
    public void when_using_headset_should_return_head_elements(){
        TreeSet<String> set = getSetData();
        TreeSet<String> expected = new TreeSet<>();
        expected.add("angle");
        expected.add("crill");
        expected.add("mango");
        SortedSet<String> actual = set.headSet("python");

        assertEquals(actual,expected);
    }

    @Test
    public void when_using_tailset_should_return_tail_elements(){
        TreeSet<String> setData = getSetData();
        TreeSet<String> expected = new TreeSet<>();
        expected.add("wobbuffet");
        expected.add("python");

        SortedSet<String> actual = setData.tailSet("python");
        assertEquals(actual,expected);
    }

    @Test(expected = NullPointerException.class)
    public void when_adding_null_should_raise_null_pointer(){
        TreeSet<String> setData = getSetData();
        setData.add(null);
    }
}