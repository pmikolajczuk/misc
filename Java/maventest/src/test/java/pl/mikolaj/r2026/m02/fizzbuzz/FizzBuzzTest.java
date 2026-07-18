package pl.mikolaj.r2026.m02.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

	FizzBuzz fizzBuzz = new FizzBuzz();
	Supplier<IntStream> intStreamSupplier = () -> IntStream.rangeClosed(1,105);

	@Test
	void usingCustomMapperVersion2() {
		System.out.println(fizzBuzz.usingCustomMapperVersion2(intStreamSupplier.get()));
	}

	@Test
	void usingCustomMapperVersion1() {
		System.out.println(fizzBuzz.usingCustomMapperVersion1(intStreamSupplier.get()));
	}

	@Test
	void streamInput1() {
		System.out.println(fizzBuzz.streamInput1(intStreamSupplier.get()));
	}

	@Test
	void simpleForLoop1() {
		fizzBuzz.simpleForLoop1();
	}

	@Test
	void simpleForLoop2() {
		fizzBuzz.simpleForLoop2();
	}
}