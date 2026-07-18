package pl.mikolaj.r2026.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {
	public static String intArrayToString(int[] input) {
		Integer[] boxed = IntStream.of(input).boxed().toArray(Integer[]::new);
		return arrayToString(boxed);
	}

	public static <T> String arrayToString(T[] input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			sb.append(input[i]);
			if (i < input.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	public static <K, V> void printMultiValueMap(Map<K, List<V>> result) {
		result.forEach(Utils::printMultiValueMapEntry);
	}

	private static <K, V> void printMultiValueMapEntry(K k, List<V> vs) {
		System.out.print(k + ": ");
		String integersString = Optional.ofNullable(vs)
				.orElse(Collections.emptyList())
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
		System.out.println(integersString);
	}
}
