package pl.mikolaj.old.misc.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapReduceExamples {
    public static class Example1 {

        public static void main(String[] args) {
            List<Integer> numbers = List.of(3, 7, 8, 1, 5, 9);
            List<String> words = List.of("corejava", "spring", "hibernate", "spring");

            int sum = 0;
            for(Integer n : numbers) {
                sum+= n;
            }
            System.out.println(sum);

            Integer sumStream = numbers.stream().reduce(0, Integer::sum);
            System.out.println(sumStream);

            Integer maxValue = numbers.stream().reduce(Integer::max).get();
            System.out.println(maxValue);

            String longest = words
                    .stream()
                    .reduce((s, s2) -> s.length() >= s2.length() ? s : s2)
                    .get();
            System.out.println(longest);

            Comparator<String> byLength = Comparator.comparing(String::length);
            String longestV2 = words
                    .stream()
                    .reduce(BinaryOperator.maxBy(byLength))
                    .get();
            System.out.println(longestV2);

            Map<String, List<String>> words2words = words.stream().collect(Collectors.groupingBy(s -> s));
            System.out.println(words2words);

            Map<String, Integer> words2count = words
                    .stream()
                    .collect(Collectors.groupingBy(s -> s, Collectors.reducing(0, s -> 1, Integer::sum)));
            System.out.println(words2count);

            Map<String, Integer> words2length = words
                    .stream()
                    .collect(Collectors.toMap(s -> s, String::length, (l1, l2) -> l1));
            System.out.println(words2length);
        }
    }

    public static class Example2 {
        public static void main(String[] args) {
            int[] numbers = {1, 3, 5, 7, 8, 9};

            int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
            System.out.println("Sum 1: " + sum);

            ArrayList<Integer> identity = new ArrayList<>();
            List<Integer> collected1 = Arrays.stream(numbers)
                    .parallel()
                    .boxed()
                    .reduce(identity,
                            (integers, i) -> {
                                integers = new ArrayList<>(integers);
                                integers.add(i);
                                return integers;
                            },
                            (integers1, integers2) -> {
                                integers1 = new ArrayList<>(integers1);
                                integers1.addAll(integers2);
                                return integers1;
                            }
                    );

            collected1.forEach(System.out::print);
            System.out.println();

            List<Integer> collected2 = Arrays.stream(numbers)
                    .parallel()
                    .boxed()
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            collected2.forEach(System.out::print);
            System.out.println();


            String concatenation0 = Arrays.stream(numbers)
                    .parallel()
                    .mapToObj(i1 -> i1 + "")
                    .reduce("", (s1, s2) -> s1 + s2);

            System.out.println(concatenation0);

            String concatenation1 = Arrays.stream(numbers)
                    .parallel()
                    .boxed()
                    .reduce("", (s, integer) -> s + integer,(s, s2) -> s + s2);

            System.out.println(concatenation1);

            String concatenations2 = Arrays.stream(numbers)
                    .parallel()
                    .boxed()
                    .collect(Collectors.reducing("", i1 -> i1 + "", (s, s2) -> s + s2));

            System.out.println(concatenations2);

            String concatenations3 = Arrays.stream(numbers)
                    .parallel()
                    .boxed()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();

            System.out.println(concatenations3);

            @SuppressWarnings("replace")
            String concatenations4 = Arrays.stream(numbers)
                    .parallel()
                    .boxed()
                    .collect(Collectors.mapping(
                            String::valueOf,
                            Collector.of(
                                    () -> new StringJoiner(""),
                                    StringJoiner::add,
                                    StringJoiner::merge,
                                    StringJoiner::toString
                            )
                    ));

            System.out.println(concatenations4);
        }
    }

}
