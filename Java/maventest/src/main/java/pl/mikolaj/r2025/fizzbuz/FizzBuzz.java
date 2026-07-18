package pl.mikolaj.r2025.fizzbuz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FizzBuzz {

	Map<Integer, String> customMap = new LinkedHashMap<>();
	{
		customMap.put(3, "Fizz");
		customMap.put(5, "Buzz");
		customMap.put(7, "Woof");
	}

	public String usingCustomMapperVersion1(IntStream input) {
		return usingCustomMapper(input, this::customMapper1);
	}


	private String customMapper1(int x) {
		StringBuilder result = new StringBuilder(1);

		for (Integer key : customMap.keySet()) {
			if (x % key == 0) {
				result.append(customMap.get(key));
			}
		}

		if(result.isEmpty()) {
			result.append(x);
		}

		return result.toString();
	}

	public String usingCustomMapperVersion2(IntStream input) {
		return usingCustomMapper(input, this::customMapper2);
	}

	private String customMapper2(int x) {
		final StringBuilder result = new StringBuilder(); //needs to be effectively final to be used in lambda expression
		customMap.forEach(
			(k, v) -> result.append(x % k == 0 ? v : "")
		);

		if(result.isEmpty()) {
			result.append(x);
		}

		return result.toString();
	}

	public String usingCustomMapper(IntStream input, Function<Integer, String> mapper) {
		StringBuilder sb = new StringBuilder();

		input.forEach(i -> {
			sb.append(
				mapper.apply(i)
			);
			sb.append(System.lineSeparator());
		});

		return sb.toString();
	}

	//---------------------------------------
	public String streamInput1(IntStream input) {
		StringBuilder sb = new StringBuilder();

		input.forEach(i -> {
			sb.append(
					hardCodedMapper(i)
			);
		});

		return sb.toString();
	}

	private String hardCodedMapper(int i) {
		String result;
		if (i % 15 == 0) {
			result = "FizzBuzz";
		} else if (i % 3 == 0) {
			result = "Fizz";
		} else if (i % 5 == 0) {
			result = "Buzz";
		} else {
			result = String.valueOf(i);
		}

		result = result + System.lineSeparator();
		return result;
	}

	public void simpleForLoop1() {
		for (int i = 1; i <= 30; i++) {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public void simpleForLoop2() {
		for (int i = 1; i <= 30; i++) {
			if (i % 3 == 0) {
				System.out.print("Fizz");
				if (i % 5 == 0) {
					System.out.print("Buzz");
				}
			} else if (i % 5 == 0) {
				System.out.print("Buzz");

			} else {
				System.out.print(i);
			}

			System.out.println();
		}
	}
}
