package pl.mikolaj.r2026.m07.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FizzBuzz {

    Map<Integer, String> customMap = new LinkedHashMap<>();
    {
        customMap.put(3, "Fizz");
        customMap.put(5, "Buzz");
        customMap.put(7, "Woof");
    }

    public void usingIntStream1() {
        IntStream
                .rangeClosed(1, 105)
                .mapToObj(this::customMapper)
                .forEach(System.out::println);
    }

    private String customMapper(int i) {
        CustomMapEntryConsumer customMapEntryConsumer = new CustomMapEntryConsumer(i);
        customMap.forEach(customMapEntryConsumer::consume);
        customMapEntryConsumer.handleNoMatch();
        return customMapEntryConsumer.toString();
    }

    public void usingCustomMap3() {
        for (int i = 1; i <= 105; i++) {
            CustomMapEntryConsumer customMapEntryConsumer = new CustomMapEntryConsumer(i);
            customMap.forEach(customMapEntryConsumer::consume);
            customMapEntryConsumer.handleNoMatch();
            System.out.println(customMapEntryConsumer);
        }
    }

    private static class CustomMapEntryConsumer {
        private final StringBuilder sb = new StringBuilder();
        private final int i;

        public CustomMapEntryConsumer(int i) {
            this.i = i;
        }

        public void consume(Integer key, String value) {
            if (i % key == 0) {
                sb.append(value);
            }
        }

        public void handleNoMatch() {
            if (sb.isEmpty()) {
                sb.append(i);
            }
        }

        @Override
        public String toString() {
            return sb.toString();
        }

    }

    public void usingCustomMap2() {
        for (int i = 1; i <= 105; i++) {
            final int j = i;
            StringBuilder sb = new StringBuilder();
            customMap.forEach((key, value) -> {
                if (j % key == 0) {
                    sb.append(value);
                }
            });

            if (sb.isEmpty()) {
                sb.append(j);
            }

            System.out.println(sb);
        }
    }

    public void usingCustomMap1() {
        for (int i = 1; i <= 105; i++) {
            StringBuilder sb = new StringBuilder();
            for (Integer j : customMap.keySet()) {
                if (i % j == 0) {
                    sb.append(customMap.get(j));
                }
            }
            if (sb.isEmpty()) {
                sb.append(i);
            }
            System.out.println(sb);
        }
    }

    public void simpleForLoop3() {

        for (int i = 1; i <= 105; i++) {
            StringBuilder result = new StringBuilder();
            if (i % 3 == 0) {
                result.append("Fizz");
            }
            if (i % 5 == 0) {
                result.append("Buzz");
            }
            if (i % 7 == 0) {
                result.append("Woof");
            }

            if (result.isEmpty()) {
                result.append(i);
            }

            System.out.println(result);
        }
    }



    public void simpleForLoop2() {
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                System.out.print("Fizz");

                if (i % 5 == 0) {
                    System.out.print("Buzz");
                }
            } else if (i % 5 == 0) {
                System.out.print("Buzz");

            } else {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public void simpleForLoop1() {
        for (int i = 1; i <= 30; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
