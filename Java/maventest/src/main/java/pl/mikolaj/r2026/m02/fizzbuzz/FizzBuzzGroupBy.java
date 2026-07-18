package pl.mikolaj.r2026.m02.fizzbuzz;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FizzBuzzGroupBy {

	private final Map<Integer, String> customMap = new LinkedHashMap<>();
	{
		customMap.put(3, "Fizz");
		customMap.put(5, "Buzz");
		customMap.put(7, "Woof");
	}

	public Map<String, List<Integer>> groupBy2(IntStream input) {
		Map<String, List<Integer>> result = new LinkedHashMap<>();

		input.forEach(i -> {
			addNewValueToMultipleKeys(result, getCustomMapValues(i), i);
		});
		return result;
	}

	private <K,V> void addNewValueToMultipleKeys(Map<K, List<V>> multiValueMap, List<K> keys, V newValue) {
		keys.forEach(key ->
				multiValueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(newValue)
		);
	}

	private List<String> getCustomMapValues(int i) {
		List<String> result = new ArrayList<>();
		customMap.forEach((key, value) -> {
			if (i % key == 0) {
				result.add(value);
			}
		});
		return result;
	}

	public Map<String, List<Integer>> groupBy1(IntStream input) {
		Map<String, List<Integer>> result = new LinkedHashMap<>();

		input.forEach(i -> {
			for (Integer key : customMap.keySet()) {
				if (i % key == 0) {
					result.computeIfAbsent(customMap.get(key),s -> new ArrayList<>()).add(i);
				}
			}
		});
		return result;
	}
}
