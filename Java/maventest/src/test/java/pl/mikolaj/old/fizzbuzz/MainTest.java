package pl.mikolaj.old.fizzbuzz;

import org.junit.jupiter.api.Test;
import pl.mikolaj.old.misc.fizzbuzz.Main;

import java.util.*;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fizzBuzzGroupBy() {
        Map<String, List<Integer>> expectedResult = Map.of(
                "Fizz", Arrays.asList(3, 6, 9, 12, 18, 21, 24, 27),
                "Buzz", Arrays.asList(5, 10, 20, 25),
                "FizzBuzz", List.of(15, 30)
                );

        checkResult(expectedResult, Main::fizzBuzzGroupBy1);
        checkResult(expectedResult, Main::fizzBuzzGroupBy1a);
        checkResult(expectedResult, Main::fizzBuzzGroupBy2);
    }

    private <T> void checkResult(Object expectedResult, Supplier<T> func) {
        Object actualResult = func.get();
        System.out.println(actualResult);
        assertEquals(expectedResult, actualResult);
    }
}