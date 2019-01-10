package main.practice.manisharana.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        /*ways to create stream*/
        List<String> list = Arrays.asList("pen", "bottle", "desk", "book", "board");
        String[] array = new String[]{"pen", "bottle", "desk", "book", "board"};

        Stream<String> emptyStream = Stream.empty();
        Stream<String> listStream = list.stream();
        Stream<String> arrayStream = Arrays.stream(array);

        streamGenrationMethods();
        primitiveTypeStream();
    }

    private static void primitiveTypeStream() {
        /*Stream of primitive types*/
        IntStream intStream= IntStream.range(5, 10);
        intStream.forEach(integer -> System.out.print(integer+"\t"));
        System.out.println();

        LongStream longStream = LongStream.rangeClosed(5, 10); /*Inclusive of las element*/
        longStream.forEach(longValue -> System.out.print(longValue+"\t"));
        System.out.println();

        IntStream chars = "abcdefgr".chars();
        chars.forEach(ch -> System.out.print((char) ch+"\t"));
        System.out.println();

        Stream<String> stringStream = Pattern.compile(",").splitAsStream("a, b, c");
        stringStream.forEach(ch -> System.out.print(ch+"\t"));

    }

    private static void streamGenrationMethods() {
        int n = 5;
        /*Must limit the size*/
        Stream<Integer> generatedStream = Stream.generate(() -> n * 2).limit(10);
        generatedStream.forEach(integer -> System.out.print(integer+"\t"));
        System.out.println();

        Stream<Integer> iteratedStream = Stream.iterate(2, m -> m * 5).limit(10);
        iteratedStream.forEach(integer -> System.out.print(integer+"\t"));
        System.out.println();
    }
}
