package pl.mikolaj.r2025.utils;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

	@Test
	void reverseMultiValueMap() {
		Map<String, List<Integer>> input = new LinkedHashMap<>();

		input.put("Fizz", Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30));
		input.put("Buzz", Arrays.asList(5, 10, 15, 20, 25, 30));
		input.put("Woof", Arrays.asList(7, 14, 21, 28));

		System.out.println("Before: ");
		Utils.printMultiValueMap(input);

		Map<Integer, List<String>> output = Utils.reverseMultiValueMapV2(input);

		System.out.println("After: ");

		Utils.printMultiValueMap(output);

		Map<Integer, List<String>> outputByCopilot = Utils.reverseMultiValueMapByCopilot(input);

		System.out.println("After (by Copilot): ");

		Utils.printMultiValueMap(output);

		assertEquals(outputByCopilot, output);
	}

	@Test
	void reverseMap() {
		Map<String, Integer> input = new HashMap<>();

		input.put("Fizz", 3);
		input.put("Buzz", 5);
		input.put("Woof", 3);
		input.put("Puff", 11);

		System.out.println("Before: ");
		for (Map.Entry<String, Integer> entry : input.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println();

		Map<Integer, List<String>> output = Utils.reverseMapV2(input);
		System.out.println("After: ");
		Utils.printMultiValueMap(output);
	}

	@Test
	void addValueToMultiValueMap() {
	}
}