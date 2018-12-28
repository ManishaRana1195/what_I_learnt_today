package main.practice.manisharana.collections;

import org.junit.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.*;

public class ListExampleTest {

    @Test(expected = UnsupportedOperationException.class)
    public void modifying_unmodifiable_list_should_throw_exception(){
        ArrayList<String> sample = new ArrayList<String>(Arrays.asList("airdrone","biomedical","chromatic")) ;
        List<String> unmodifiableList = Collections.unmodifiableList(sample);
        unmodifiableList.add("dribble");
    }

    @Test
    public void creating_unmodifiable_list_is_not_truly_modifiable(){
        ArrayList<String> sample = new ArrayList<>(Arrays.asList("airdrone", "biomedical", "chromatic")) ;

        /*sample and unmodifiableList are referencing same object*/
        List<String> unmodifiableList = Collections.unmodifiableList(sample);

        sample.add("dribble");
        assertEquals(unmodifiableList.get(3), "dribble");
    }


    @Test
    public void creating_truly_unmodifiable_list(){
        ArrayList<String> sample = new ArrayList<>(Arrays.asList("airdrone", "biomedical", "chromatic")) ;

        /*sample and unmodifiableList are not referencing same object*/
        List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList<>(sample));

        sample.set(2,"dribble");
        assertNotEquals(unmodifiableList.get(2), "dribble");
    }

    @Test
    public void test_creating_list_with_distinct_elements(){
        ArrayList<Integer> sample = getSampleList();

        Instant start = Instant.now();
        ArrayList<Integer> distinctElements = new ArrayList<>(new HashSet<>(sample));
        Instant end = Instant.now();

        System.out.println("The time taken in sec "+ Duration.between(start,end));
        assertNotEquals(sample.size(), distinctElements.size());

    }

    private ArrayList<Integer> getSampleList() {
        ArrayList<Integer> sample = IntStream.range(10, 100000).boxed().collect(Collectors.toCollection(ArrayList::new));
        sample.addAll(sample);
        return sample;
    }

    @Test
    public void creating_list_with_distinct_elements(){
        ArrayList<Integer> sample = getSampleList();

        Instant start = Instant.now();
        List<Integer> distinct = sample.stream().distinct().collect(Collectors.toList());
        Instant end = Instant.now();

        System.out.println("The time taken in sec "+ Duration.between(start,end));

        assertNotEquals(sample.size(), distinct.size());
    }

    @Test
    public void check_if_two_lists_are_equal(){
        List<String> listA = Arrays.asList("5", "6", "7", "8");
        List<String> listB = Arrays.asList("5", "6", "7", "8");
        List<String> listC = Arrays.asList("5", "6", "8", "7");

        assertEquals(listA,listB);
        assertNotEquals(listA,listC);


    }
}