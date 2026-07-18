package pl.mikolaj.r2026.m07.fizzbuzz;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FizzBuzzGroupBy {

    private static final Map<Integer, String> fizzBuzzMap = new LinkedHashMap<>();
    static {
        fizzBuzzMap.put(3, "Fizz");
        fizzBuzzMap.put(5, "Buzz");
        fizzBuzzMap.put(7, "Woof");
    }
    
    public Map<String, List<Integer>> groupBy3a(IntStream intStream) {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        intStream.forEach(i -> {
            StringBuilder keyBuilder = new StringBuilder();
            fizzBuzzMap.forEach((key, value) -> {
                if (i % key == 0) {
                    keyBuilder.append(value);
                }
            });

            if (!keyBuilder.isEmpty()) {
                result.computeIfAbsent(keyBuilder.toString(), s -> new ArrayList<>()).add(i);
            }
        });
        return result;
    }

    public Map<String, List<Integer>> groupBy3(IntStream intStream) {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        intStream.forEach(i -> {
            fizzBuzzMap.forEach((key, value) -> {
                if (i % key == 0) {
                    result.computeIfAbsent(value, s -> new ArrayList<>()).add(i);
                }
            });
        });
        return result;
    }

    public Map<String, List<Integer>> groupBy2(IntStream intStream) {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        for (int i : intStream.toArray()) {
            for (int fizzBuzzMapKey : fizzBuzzMap.keySet()) {
                if (i % fizzBuzzMapKey == 0) {
                    String resultMapKey = fizzBuzzMap.get(fizzBuzzMapKey);
                    result.computeIfAbsent(resultMapKey,s -> new ArrayList<>()).add(i);
                }
            }
        }
        return result;
    }
    
    public Map<String, List<Integer>> groupBy1() {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        IntStream.rangeClosed(1, 105).forEach(i -> {
            if (i % 3 == 0) {
                result.computeIfAbsent("Fizz",key -> new ArrayList<>()).add(i);
            }

            if (i % 5 == 0) {
                result.computeIfAbsent("Buzz", key -> new ArrayList<>()).add(i);
            }

            if (i % 7 == 0) {
                result.computeIfAbsent("Woof", key -> new ArrayList<>()).add(i);
            }
        });

        return result;
    }

    public Map<String, List<Integer>> groupByCopilot(IntStream intStream) {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        intStream.forEach(i -> {
            StringBuilder keyBuilder = new StringBuilder();
            fizzBuzzMap.forEach((key, value) -> {
                if (i % key == 0) {
                    keyBuilder.append(value);
                }
            });
            String key = !keyBuilder.isEmpty() ? keyBuilder.toString() : "None";
            result.computeIfAbsent(key, s -> new ArrayList<>()).add(i);
        });
        return result;
    }
}
