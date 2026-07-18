package pl.mikolaj.r2025.fizzbuz;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2025.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FizzBuzzGroupByTest {

	FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
	Supplier<Stream<Integer>> exampleInputSupplier = () -> IntStream.rangeClosed(1,105).boxed();

	@Test
	void groupBy1() {
		Map<String, List<Integer>> groupedBy = fizzBuzzGroupBy.groupBy1(exampleInputSupplier.get());

		printGroupedByMap(groupedBy);
	}

	@Test
	void groupBy1Reversed() {
		Map<String, List<Integer>> groupedBy = fizzBuzzGroupBy.groupBy1(exampleInputSupplier.get());

		printGroupedByReversed(groupedBy);
	}

	private void printGroupedByMap(Map<String, List<Integer>> groupedBy) {
		Utils.printMultiValueMap(groupedBy);
	}

	private void printGroupedByReversed(Map<String, List<Integer>> groupedBy) {
		Map<Integer, List<String>> groupedByReversed = Utils.reverseMultiValueMapV2(groupedBy);

		exampleInputSupplier.get().forEach(i -> {
			List<String> tokens = groupedByReversed.get(i);
			System.out.println(tokens == null ? i : Utils.concatToString(tokens));
		});

	}
}