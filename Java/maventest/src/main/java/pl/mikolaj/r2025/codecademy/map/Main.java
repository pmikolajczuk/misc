package pl.mikolaj.r2025.codecademy.map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Integer> myInts = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			myInts.add(random.nextInt(5));
		}

		myInts.forEach(x -> System.out.print(x + " "));
		System.out.println();

		Map<Integer, Integer> intCount = countInts1(myInts);
		printCountedInts(intCount);
		System.out.println();

		intCount = countInts2(myInts);
		printCountedInts(intCount);
		System.out.println();

		intCount = countInts3(myInts);
		printCountedInts(intCount);
	}

	private static Map<Integer, Integer> countInts1(List<Integer> myInts) {
		Map<Integer, Integer> result = new HashMap<>();
		for (Integer i : myInts) {
			result.compute(
				i, (key, currentValue) -> currentValue == null ? 1 : currentValue + 1
			);
		}

		return result;
	}

	private static Map<Integer, Integer> countInts2(List<Integer> myInts) {
		Map<Integer, Integer> result = new HashMap<>();
		myInts.forEach(i -> result.merge(i, 1, Integer::sum));

		return result;
	}

	private static Map<Integer, Integer> countInts3(List<Integer> myInts) {
		return myInts.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
	}

	private static void printCountedInts(Map<Integer, Integer> intCount) {
		intCount.forEach((key, value) ->
			System.out.println("Integer: " + key + " appears " + value + " times")
		);
	}
}
