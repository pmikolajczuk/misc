package pl.mikolaj.r2025.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

	public static <K, V> Map<V, List<K>> reverseMultiValueMapByCopilot(Map<K, List<V>> multiValueMap) {
		Map<V, List<K>> reversedMap = new HashMap<>();

		for (Map.Entry<K, List<V>> entry : multiValueMap.entrySet()) {
			K originalKey = entry.getKey();
			for (V value : entry.getValue()) {
				reversedMap
						.computeIfAbsent(value, k -> new ArrayList<>())
						.add(originalKey);
			}
		}
		return reversedMap;
	}

	public static <K, V> Map<V, List<K>> reverseMultiValueMap(Map<K, List<V>> multiValueMap) {
		Map<V, List<K>> reversedMap = new HashMap<>();

		multiValueMap.forEach((k, vs) -> {
			vs.forEach(v -> addValueToMultiValueMapV2(reversedMap, v, k));
		});

		return reversedMap;
	}

	public static <K, V> Map<V, List<K>> reverseMultiValueMapV2(Map<K, List<V>> multiValueMap) {
		Map<V, List<K>> reversedMap = new HashMap<>();

		for(Map.Entry<K, List<V>> entry: multiValueMap.entrySet()) {
			K originalKey = entry.getKey();
			for(V originalValue : entry.getValue()) {
				reversedMap.computeIfAbsent(originalValue, newKey -> new ArrayList<>()).add(originalKey);
			}
		}

		return reversedMap;
	}

	public static <K, V> Map<V, List<K>> reverseMapV1(Map<K, V> inputMap) {
		Map<V, List<K>> reversedMap = new HashMap<>();

		inputMap.forEach((k, v) -> addValueToMultiValueMapV2(reversedMap, v, k));

		return reversedMap;
	}

	public static <K, V> Map<V, List<K>> reverseMapV2(Map<K, V> inputMap) {
		Map<V, List<K>> reversedMap = new HashMap<>();

		inputMap.forEach(
			(k1, v) -> reversedMap.computeIfAbsent(v, k2 -> new ArrayList<>()).add(k1)
		);
		return reversedMap;
	}
		public static <K, V> void addValueToMultiValueMapV1(Map<K, List<V>> multiValueMap, K key, V newValue) {

		if (multiValueMap.get(key) == null) {
			List<V> values = new ArrayList<>();
			values.add(newValue);

			multiValueMap.put(key, values);
		} else {
			multiValueMap.get(key).add(newValue);
		}
	}

	public static <K, V> void addValueToMultiValueMapV2(Map<K, List<V>> multiValueMap, K key, V newValue) {
		multiValueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(newValue);
	}

	public static <K, V> void printMultiValueMap(Map<K, List<V>> multiValueMap) {
		multiValueMap.forEach(Utils::printMultiValueMapEntry);
	}

	private static <K, V> void printMultiValueMapEntry(K key, List<V> values) {
		System.out.print(key + ": ");
		String valuesString = Optional
				.ofNullable(values)
				.orElse(Collections.emptyList())
				.stream()
				.filter(Objects::nonNull)
				.map(String::valueOf)
				.collect(Collectors.joining(","));

		System.out.println(valuesString);
	}

	public static <T> String concatToString(Collection<T> items) {
		return Optional.ofNullable(items)
				.orElse(Collections.emptyList())
				.stream()
				.filter(Objects::nonNull)
				.map(String::valueOf)
				.collect(Collectors.joining());
	}
}
