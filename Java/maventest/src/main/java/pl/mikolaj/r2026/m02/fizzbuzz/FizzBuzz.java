package pl.mikolaj.r2026.m02.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FizzBuzz {

	private final Map<Integer, String> customMap = new LinkedHashMap<>();
	{
		customMap.put(3, "Fizz");
		customMap.put(5, "Buzz");
		customMap.put(7, "Woof");
	}

	public String usingCustomMapperVersion2(IntStream input) {
		return map(input, this::customMapper1);
	}

	private String customMapper2(int i) {
		StringBuilder sb = new StringBuilder();
		customMap.forEach((key, value) ->
				sb.append(
						i % key == 0 ? value : ""
				)
		);

		if(sb.isEmpty()) {
			sb.append(i);
		}

		return sb.toString();
	}

	public String usingCustomMapperVersion1(IntStream input) {
		return map(input, this::customMapper1);
	}


	private String customMapper1(int i) {
		StringBuilder sb = new StringBuilder();
		for (Integer key : customMap.keySet()) {
			if (i % key == 0) {
				sb.append(customMap.get(key));
			}
		}

		if(sb.isEmpty()) {
			sb.append(i);
		}

		return sb.toString();
	}

	public String streamInput1(IntStream input) {
		return map(input, this::hardCodedMapper);
	}

	private String map(IntStream input, Function<Integer, String> mapper) {
		StringBuilder sb = new StringBuilder();
		input.forEach(i -> {
			sb.append(mapper.apply(i));
			sb.append("\n");
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
		}
		else {
			result = Integer.toString(i);
		}
		return result;
	}

	public void simpleForLoop2() {
		for(int i = 1; i <= 30; i++) {
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

	public void simpleForLoop1() {
		for (int i = 1; i <= 30; i++) {
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			}  else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
