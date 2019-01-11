package main.practice.manisharana.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.testng.Assert.*;

public class StreamExampleTest {

    @Test
    public void shouldReturnAnyElementWhenFindAnyIsUsed(){
        List<Integer> list = Arrays.asList(5, 10, 15, 2, 7, 11, 13);
        Optional<Integer> result = list.stream().filter(num -> num % 5 == 0).findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is(5), is(10),is(15)));
    }

    @Test
    public void shouldReturnFirstElementWhenFindFirstIsUsed(){
        List<Integer> list = Arrays.asList(5, 10, 15, 2, 7, 11, 13);
        Optional<Integer> result = list.stream().filter(num -> num % 5 == 0).findFirst();

        assertTrue(result.isPresent());
        assertThat(result.get(), is(5));
    }

}