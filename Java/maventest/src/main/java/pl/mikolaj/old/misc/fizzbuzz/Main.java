package pl.mikolaj.old.misc.fizzbuzz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //fizzBuzz1();
        //fizzBuzz2();
        //fizzBuzz3();
        //fizzBuzz4();
        //fizzBuzz5();
        //fizzBuzz6();

        //fizzBuzzGroupBy2a();
    }

//    public static Map<String, List<Integer>> fizzBuzzGroupBy3() {
//        return IntStream.rangeClosed(1, 30)
//                .boxed()
//                .reduce((integer, integer2) -> )
//    }




    public static Map<String, List<Integer>> fizzBuzzGroupBy2() {
        return IntStream.rangeClosed(1, 30)
                .boxed()
                .filter(i -> classifier(i) != null)
                .collect(Collectors.groupingBy(Main::classifier));
    }

    private static String classifier(Integer i) {
        Map<Integer, String> int2String = new LinkedHashMap<>();
        int2String.put(15, "FizzBuzz");
        int2String.put(3, "Fizz");
        int2String.put(5, "Buzz");

        return int2String.entrySet()
                .stream()
                .filter(entry -> i % entry.getKey() == 0)
                .max(Map.Entry.comparingByKey())
                .orElseGet(() -> new AbstractMap.SimpleEntry<Integer, String>(null, null))
                .getValue();
    }

    public static Map<String, List<Integer>> fizzBuzzGroupBy1a() {
        Map<String, List<Integer>> result = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            final int finalI = i;
            if (finalI % 15 == 0) {
                result.compute("FizzBuzz", (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            } else if (finalI % 3 == 0) {
                result.merge("Fizz", new ArrayList<>(), (integers, integers2) -> integers).add(i);
            } else if (finalI % 5 == 0) {
                result.computeIfAbsent("Buzz", k -> new ArrayList<>()).add(i);
            }
        }
        return result;
    }

    public static Map<String, List<Integer>> fizzBuzzGroupBy1() {
        Map<String, List<Integer>> result = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            final int finalI = i;
            if (finalI % 15 == 0) {
                result.compute("FizzBuzz", (k, v) -> v == null ? new ArrayList<>(List.of(finalI)) : addAll(v, List.of(finalI)));
            } else if (finalI % 3 == 0) {
                result.merge("Fizz", new ArrayList<>(List.of(finalI)), Main::addAll);
            } else if (finalI % 5 == 0) {
                result.computeIfAbsent("Buzz", k -> new ArrayList<>()).add(i);
            }
        }
        return result;
    }

    private static <E> List<E> addAll(List<E> list, Collection<E> values) {
        list.addAll(values);
        return list;
    }

    public static void fizzBuzz6() {
        for (int i = 1; i <= 200; i++) {
            printFizzOrBuzz(i);
        }
    }

    private static void printFizzOrBuzz(int x) {
        Map<Integer, String> int2String = new LinkedHashMap<>();
        int2String.put(3, "Fizz");
        int2String.put(5, "Buzz");
        int2String.put(7, "Woof");

        FizzBuzzPrinter printer = new FizzBuzzPrinter();
        int2String.forEach((k, v) -> {
            if (x % k == 0) printer.print(v);
        });

        if (!printer.printed) {
            System.out.print(x);
        }
        System.out.println();
    }

    private static class FizzBuzzPrinter {
        boolean printed = false;

        private void print(String v) {
            System.out.print(v);
            printed = true;
        }
    }

    public static void fizzBuzz5() {
        for (int i = 1; i <= 200; i++) {
            System.out.println(fizzOrBuzz2(i));
        }
    }

    private static String fizzOrBuzz2(int x) {
        Map<Integer, String> int2String = new LinkedHashMap<>();
        int2String.put(3, "Fizz");
        int2String.put(5, "Buzz");
        int2String.put(7, "Woof");

        final String[] result = {""};

        int2String.forEach((k, v) -> result[0] += x % k == 0 ? v : "");
        return result[0].isEmpty() ? x + "" : result[0];
    }

    public static void fizzBuzz4() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzOrBuzz1(i));
        }

    }

    private static String fizzOrBuzz1(int x) {
        Map<Integer, String> int2String = new LinkedHashMap<>();
        int2String.put(21, "FizzBuzz");
        int2String.put(15, "FizzBuzz");
        int2String.put(3, "Fizz");
        int2String.put(5, "Buzz");
        int2String.put(7, "Buzz");

        for (Integer key : int2String.keySet()) {
            if (x % key == 0) {
                return int2String.get(key);
            }
        }
        return x + "";
    }

    public static void fizzBuzz3() {
        IntStream.iterate(1, x -> x <= 100, x -> ++x)
                .mapToObj(x -> {
                    if (x % 15 == 0) return "FizzBuzz";
                    else if (x % 3 == 0) return "Fizz";
                    else if (x % 5 == 0) return "Buzz";
                    else return String.valueOf(x);
                })
                .forEach(System.out::println);
    }

    public static void fizzBuzz2() {
        for (int i = 1; i <= 100; i++) {
            String result = "";
            if (i % 3 == 0) {
                result += "Fizz";
            }
            if (i % 5 == 0 || i % 7 == 0) {
                result += "Buzz";
            }
            if (result.isEmpty()) {
                result = String.valueOf(i);
            }
            System.out.println(result);
        }
    }

    public static void fizzBuzz1() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0 || i % 3 == 0 && i % 7 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0 || i % 7 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
