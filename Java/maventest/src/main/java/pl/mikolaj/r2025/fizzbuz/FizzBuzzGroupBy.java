package pl.mikolaj.r2025.fizzbuz;

import pl.mikolaj.r2025.utils.Utils;

import java.util.*;
import java.util.stream.Stream;

public class FizzBuzzGroupBy {
	Map<Integer, String> customMap = new LinkedHashMap<>();

	{
		customMap.put(3, "Fizz");
		customMap.put(5, "Buzz");
		customMap.put(7, "Woof");
	}

	public Map<String, List<Integer>> groupBy1(Stream<Integer> input) {
		Map<String, List<Integer>> result = new LinkedHashMap<>();
		input.forEach(i -> addNewValueToMultipleKeys(result, getCustomMapValues(i), i));
		return result;
	}

	private List<String> getCustomMapValues(Integer x) {
		List<String> result = new ArrayList<>();

		customMap.forEach((key, value) -> {
			if (x % key == 0) {
				result.add(value);
			}
		});

		return result;
	}

	private <K, V> void addNewValueToMultipleKeys(Map<K, List<V>> multiValueMap, Collection<K> keys, V newValue) {
		keys.forEach(k -> Utils.addValueToMultiValueMapV2(multiValueMap, k, newValue));
	}
}
