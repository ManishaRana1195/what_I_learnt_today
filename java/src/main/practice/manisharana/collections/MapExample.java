package main.practice.manisharana.collections;


import java.util.HashMap;
import java.util.Set;

public class MapExample {

    public static void main(String[] args) {
        HashMap<Student,String> map = new HashMap<>();
        Student studentA = new Student(100, "Bala");
        Student studentB = new Student(110, "Akash");
        Student studentC = new Student(210, "Mr.B");
        Student studentD = new Student(400, "Nithin");
        Student studentE = new Student(330, "Sundar");

        /*Hashcode method in Key gets
        called on each put and get */
        map.put(studentA,"first");
        map.put(studentB,"second");
        map.put(studentC,"third");
        map.put(studentD,"fourth");
        map.put(studentE,"fifth");

        Set<Student> keys = map.keySet();
        for(Student key : keys){
            System.out.println(map.get(key));
        }
    }
}


