package pl.mikolaj.r2026.m02.fizzbuzz;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

class FizzBuzzGroupByTest {

	FizzBuzzGroupBy fizzBuzzGroupBy = new FizzBuzzGroupBy();
	Supplier<IntStream> intStreamSupplier = () -> IntStream.rangeClosed(1,105);

	@Test
	void groupBy2() {
		Map<String, List<Integer>> result = fizzBuzzGroupBy.groupBy2(intStreamSupplier.get());
		Utils.printMultiValueMap(result);
	}

	@Test
	void groupBy1() {
		Map<String, List<Integer>> result = fizzBuzzGroupBy.groupBy1(intStreamSupplier.get());
		Utils.printMultiValueMap(result);
	}

//	@Test
//	void groupBy1Reversed() {
//		Map<String, List<Integer>> groupedBy = fizzBuzzGroupBy.groupBy1(exampleInputSupplier.get());
//
//		printGroupedByReversed(groupedBy);
//	}
}