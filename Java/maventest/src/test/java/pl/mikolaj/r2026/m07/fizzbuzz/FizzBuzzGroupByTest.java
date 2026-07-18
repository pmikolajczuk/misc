package pl.mikolaj.r2026.m07.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzGroupByTest {


    @Test
    void groupBy1HandlesDivisors() {
        FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
        Map<String, List<Integer>> result = fizzBuzzGroupBy.groupBy1();

        assertEquals(List.of(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 102, 105), result.get("Fizz"));
        assertEquals(List.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105), result.get("Buzz"));
        assertEquals(List.of(7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98, 105), result.get("Woof"));
    }

    @Test
    void groupBy2HandlesStreamInput() {
        FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
        Map<String, List<Integer>> result = fizzBuzzGroupBy.groupBy2(IntStream.rangeClosed(1, 15));

        assertEquals(List.of(3, 6, 9, 12, 15), result.get("Fizz"));
        assertEquals(List.of(5, 10, 15), result.get("Buzz"));
        assertEquals(List.of(7, 14), result.get("Woof"));
    }

    @Test
    void groupBy3HandlesStreamInput() {
        FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
        Map<String, List<Integer>> result = fizzBuzzGroupBy.groupBy3(IntStream.rangeClosed(1, 15));

        assertEquals(List.of(3, 6, 9, 12, 15), result.get("Fizz"));
        assertEquals(List.of(5, 10, 15), result.get("Buzz"));
        assertEquals(List.of(7, 14), result.get("Woof"));
    }

    @Test
    void groupBy3aHandlesCombinedKeys() {
        FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
        Map<String, List<Integer>> result = fizzBuzzGroupBy.groupBy3a(IntStream.rangeClosed(1, 21));

        printMultiValueMap(result);

        assertEquals(List.of(3, 6, 9, 12, 18), result.get("Fizz"));
        assertEquals(List.of(5, 10, 20), result.get("Buzz"));
        assertEquals(List.of(7, 14), result.get("Woof"));
        assertEquals(List.of(15), result.get("FizzBuzz"));
        assertEquals(List.of(21), result.get("FizzWoof"));
    }

    @Test
    void groupByCopilotHandlesNoneKey() {
        FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
        Map<String, List<Integer>> result = fizzBuzzGroupBy.groupByCopilot(IntStream.rangeClosed(1, 10));

        assertEquals(List.of(1, 2, 4, 8), result.get("None"));
        assertEquals(List.of(3, 6, 9), result.get("Fizz"));
        assertEquals(List.of(5, 10), result.get("Buzz"));
    }

    private <K, V> void printMultiValueMap(Map<K, List<V>> map) {
        map.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }

}