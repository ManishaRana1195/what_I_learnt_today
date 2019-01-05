package main.practice.manisharana.collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.*;

public class MapExampleTest {

    @Test
    public void when_keyset_is_changed_hashmap_should_change(){
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "bnana");
        map.put(201, "civilization");

        Set<Integer> keys = map.keySet();

        int size = map.size();
        keys.remove(101);

        assertEquals(map.size(),size - 1);
    }

    @Test
    public void when_collision_occurs_should_return_correct_value(){
        HashMap<Student, String> studentMap = new HashMap<>();
        Student studentA = new Student(100, "Bala");
        Student studentB = new Student(110, "Akash");
        Student studentC = new Student(210, "Mr.B");
        Student studentD = new Student(210, "Nithin");

        studentMap.put(studentA,"first");
        studentMap.put(studentB,"second");
        studentMap.put(studentC,"third");
        studentMap.put(studentD,"fourth");  /*equals method called */

        String first = studentMap.get(studentA);
        String third = studentMap.get(studentC);
        String fourth = studentMap.get(studentD); /*equals method called */

        assertEquals(first,"first");
        assertEquals(third,"third");
        assertEquals(fourth,"fourth");
    }

}