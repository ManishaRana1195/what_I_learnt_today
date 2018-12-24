package main.practice.manisharana.collections;

import org.junit.Test;
import java.util.*;

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
        ArrayList<Integer> sample = new ArrayList<>(Arrays.asList(1, 2, 4, 1, 3,2,20, 5, 20)) ;
        ArrayList<Integer> distinctElements = new ArrayList<>(new HashSet<>(sample));

        assertNotEquals(sample.size(), distinctElements.size());

    }

}