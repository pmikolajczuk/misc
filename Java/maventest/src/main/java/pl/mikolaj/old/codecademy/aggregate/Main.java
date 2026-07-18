package pl.mikolaj.old.codecademy.aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = List.of(5, 4, 1, 3, 7, 8);

        for (Integer x : doubleEvenList(intList)) {
            System.out.print(x + ", ");
        }
        System.out.println();

        List<String> words = new ArrayList<>();
        words.add("Tree");
        words.add("Race");
        words.add("Hello");
        words.add("World");
        words.add("Race");
        words.add("Game");
        words.add("Numbers");
        words.add("Ride");
        words.add("Race");
        words.add("Numbers");

        List<String> specialWordsWithForLoop = getSpecialWordsWithForLoop(words);
        List<String> specialWordsWithPipeline = getSpecialWordsWithPipeline(words);
        System.out.println("Special Words retrieved from for loop: " + specialWordsWithForLoop);
        System.out.println("Special Words retrieved from pipeline: " + specialWordsWithPipeline);

        Map<String, Integer> wordCount = countWords(words);
        for (String word : wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }
    }

    private static Map<String, Integer> countWords(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.reducing(0, w -> 1, (sum, x) -> sum + 1))
                );
    }

    private static List<String> getSpecialWordsWithForLoop(List<String> words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 4) {
                result.add(word.toUpperCase());
            }
        }
        return result;
    }

    private static List<String> getSpecialWordsWithPipeline(List<String> words) {
        return words.stream()
                .filter(s -> s.length() == 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<Integer> doubleEvenList(List<Integer> intList) {
        return intList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .toList();
    }

    public static List<Integer> doubleEvenList2(List<Integer> intList) {
        List<Integer> evenList = new ArrayList<>();
        for (Integer x : intList) {
            if (x % 2 == 0) {
                evenList.add(x * 2);
            }
        }
        return evenList;
    }
}
