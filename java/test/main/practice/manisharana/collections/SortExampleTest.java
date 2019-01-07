package main.practice.manisharana.collections;

import com.sun.deploy.util.ArrayUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.*;
public class SortExampleTest {

    private Integer[] sample;
    private Integer[] sorted;

    @BeforeMethod
    public void setup(){
        sample = new Integer[]{87, 45, 90, 23, 67, 76, 36, 85};
        sorted = new Integer[]{23, 36, 45, 67, 76, 85, 87, 90};

    }
    @Test
    public void should_sort_array() {
        Arrays.sort(sample);

        assertTrue(Arrays.equals(sample, sorted));
    }

    @Test
    public void should_sort_list() {
        List<Integer> toBeSorted = Arrays.asList(sample);
        Collections.sort(toBeSorted);

        assertEquals(Arrays.toString(toBeSorted.toArray()), Arrays.toString(sorted));
    }

    @Test
    public void should_sort_set() {
        /*getting a set*/
        HashSet<Integer> toBeSorted = new HashSet<>(Arrays.asList(sample));

        ArrayList<Integer> converted = new ArrayList<>(toBeSorted);
        Collections.sort(converted);  /*needs to be converted to list*/
        toBeSorted = new LinkedHashSet<>(converted);   /*to maintain insertion order*/


        assertEquals(Arrays.toString(toBeSorted.toArray()), Arrays.toString(sorted));
    }

    @Test
    public void should_sort_map(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(87,"bird");
        map.put(45,"sky");
        map.put(90,"paper");
        map.put(23,"fan");
        map.put(67,"aluminium");
        map.put(36,"oat");
        map.put(76,"block");
        map.put(85,"motor");

        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        for( Map.Entry<Integer,String> entry : entryList){
            linkedMap.put(entry.getKey(),entry.getValue());
        }

        assertTrue(Arrays.equals(linkedMap.keySet().toArray(),sorted));
        /*Another way should have been to convert hashmap to treemap*/
    }


}
