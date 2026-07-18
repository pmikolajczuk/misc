package pl.mikolaj.r2025.fizzbuz;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;

class FizzBuzzTest {

	FizzBuzz fizzBuzz = new FizzBuzz();
	Supplier<IntStream> intStreamSupplier = () -> IntStream.rangeClosed(1,70);

	@Test
	void testUsingCustomMapper1() {
		String result = fizzBuzz.usingCustomMapperVersion1(intStreamSupplier.get());
		System.out.println(result);
	}

	@Test
	void testUsingCustomMapper2() {
		String result = fizzBuzz.usingCustomMapperVersion2(intStreamSupplier.get());
		System.out.println(result);
	}

	@Test
	void testStreamInput1() {
		String result = fizzBuzz.streamInput1(intStreamSupplier.get());
		System.out.println(result);
	}

	@Test
	void testSimple1() {
		fizzBuzz.simpleForLoop1();
	}

	@Test
	void testSimple2() {
		fizzBuzz.simpleForLoop2();
	}
}