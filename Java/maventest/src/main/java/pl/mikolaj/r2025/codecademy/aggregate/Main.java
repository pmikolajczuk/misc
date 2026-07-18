package pl.mikolaj.r2025.codecademy.aggregate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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

		System.out.println(countAllLetters1(words));
		System.out.println(countAllLetters2(words));
		System.out.println(countAllLetters3(words));

		printCountedWords(countWords1(words));
		printCountedWords(countWords2(words));
		printCountedWords(countWords3(words));
		printCountedWords(countWords4(words));
		printCountedWords(countWords5(words));
	}

	private static Integer[] doubleEvenList(List<Integer> intList) {
		return intList.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * 2)
				.toArray(Integer[]::new);
	}

	private static List<String> getSpecialWordsWithForLoop(List<String> words) {
		List<String> result = new ArrayList<>();
		for (String w : words) {
			if(w.length() == 4) {
				result.add(w);
			}
		}
		return result;
	}

	private static List<String> getSpecialWordsWithPipeline(List<String> words) {
		return words
				.stream()
				.filter(w -> w.length() == 4)
				.toList();
	}

	private static int countAllLetters1(List<String> words) {
		return words
				.stream()
				.map(String::length)
				.reduce(0, Integer::sum);
	}

	private static int countAllLetters2(List<String> words) {
		return words
				.stream()
				.reduce((s, s2) -> s + s2)
				.orElse("")
				.length();
	}

	private static int countAllLetters3(List<String> words) {
		return words
				.stream()
				.reduce(0, (sum, w) -> sum + w.length(), Integer::sum);
	}

	private static Map<String, Integer> countWords1(List<String> words) {
		Map<String, Integer> result = new HashMap<>();
		for (String w : words) {
			Integer currentCount = result.get(w);
			if (currentCount == null) {
				result.put(w, 1);
			} else {
				result.put(w, currentCount + 1);
			}
		}
		return result;
	}

	private static Map<String, Integer> countWords2(List<String> words) {
		Map<String, Integer> result = new HashMap<>();
		for (String w: words) {
			result.merge(w, 1, Integer::sum);
		}
		return result;
	}

	private static Map<String, Integer> countWords3(List<String> words) {
		return words
				.stream()
				.collect(
						groupingBy(w -> w, summingInt(w -> 1))
				);
	}

	private static Map<String, Integer> countWords4(List<String> words) {
		return words
				.stream()
				.collect(
						groupingBy(
								w -> w,
								reducing(0, w -> 1, Integer::sum)
						)
				);
	}

	private static Map<String, Integer> countWords5(List<String> words) {
		return words
				.stream()
				.collect(
						groupingBy(w -> w, Collectors.mapping(w -> 1, Collectors.summingInt(x ->x)))
				);
	}

	private static void printCountedWords(Map<String, Integer> countedWords) {
		countedWords
				.forEach((key, value) -> System.out.print(
						key + ": " + value + "; "
				));
		System.out.println();
	}
}
