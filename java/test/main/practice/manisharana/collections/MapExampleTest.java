package main.practice.manisharana.collections;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class MapExampleTest {

    @Test
    public void when_keyset_is_changed_hashmap_should_change() {
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "bnana");
        map.put(201, "civilization");

        Set<Integer> keys = map.keySet();

        int size = map.size();
        keys.remove(101);

        assertEquals(map.size(), size - 1);
    }

    @Test
    public void when_collision_occurs_should_return_correct_value() {
        HashMap<Student, String> studentMap = new HashMap<>();
        Student studentA = new Student(100, "Bala");
        Student studentB = new Student(110, "Akash");
        Student studentC = new Student(210, "Mr.B");
        Student studentD = new Student(210, "Nithin");
        studentMap.put(studentA, "first");
        studentMap.put(studentB, "second");
        studentMap.put(studentC, "third");
        studentMap.put(studentD, "fourth");  /*equals method called */

        String first = studentMap.get(studentA);
        String third = studentMap.get(studentC);
        String fourth = studentMap.get(studentD); /*equals method called */

        assertEquals(first, "first");
        assertEquals(third, "third");
        assertEquals(fourth, "fourth");
    }

    @Test
    public void values_should_be_inserted_in_order_in_linked_hashmap() {
        /*accessOrder as true, will order values in LRU manner*/
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("first", 10);
        map.put("second", 20);
        map.put("third", 40);
        map.put("fourth", 60);
        map.put("fifth", 70);

        String keySetStringA = getKeys(map);
        assertEquals(keySetStringA, "[first, second, third, fourth, fifth]");
        map.get("third");

        String keySetStringB = getKeys(map);
        assertEquals(keySetStringB, "[first, second, fourth, fifth, third]");
        map.get("first");

        String keySetStringC = getKeys(map);
        assertEquals(keySetStringC, "[second, fourth, fifth, third, first]");
    }

    private String getKeys(LinkedHashMap<String, Integer> map) {
        return Arrays.toString(map.keySet().toArray());
    }

    @Test
    public void values_should_be_sorted_in_treemap(){
        TreeMap<Integer, String> map = new TreeMap<>();
        TreeMap<Integer, String> reverseMap = new TreeMap<>(Comparator.reverseOrder());
        map.put(70,"first");
        map.put(50,"second");
        map.put(40,"third");
        map.put(60,"fourth");
        map.put(10,"fifth");
        reverseMap.putAll(map);

        String keySetStringA = map.keySet().toString();
        String keySetStringB = reverseMap.keySet().toString();

        assertEquals(keySetStringA, "[10, 40, 50, 60, 70]");
        assertEquals(keySetStringB, "[70, 60, 50, 40, 10]");
    }



}