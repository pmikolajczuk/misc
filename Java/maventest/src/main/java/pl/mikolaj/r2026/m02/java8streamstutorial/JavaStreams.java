package pl.mikolaj.r2026.m02.java8streamstutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
	public static void main(String[] args) throws IOException {

		// 2. Integer Stream with Skip
		IntStream
				.range(1, 10)
				.skip(5)
				.forEach(x -> System.out.print(x));
		System.out.println();

		// 3. Integer Stream with Sum
		System.out.println(
				IntStream
						.range(1, 5)
						.sum()
		);
		System.out.println();

		// 4. Stream.of sorted and findFirst
		Stream.of("Ava", "Aneri", "Alberto")
				.sorted()
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println();

		// 5. Stream of Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Stream.of(names)
				.filter(x -> x.startsWith("S"))
				.sorted()
				.forEach(System.out::println);
		System.out.println();

		// 6. average of squares of an int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
				.map(x -> x * x)
				.average()
				.stream()
				.boxed()
				.map(Double::intValue)
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println();

		// 7. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people
				.stream()
				.map(String::toLowerCase)
				.filter(x -> x.startsWith("a"))
				.forEach(System.out::println);
		System.out.println();

		// 8. Stream rows from text file, sort filter and print
		Stream<String> bands = Files.lines(Paths.get("src/main/resources/bands.txt"));
		bands
				.sorted()
				.filter(x -> x.length() > 13)
				.forEach(System.out::println);
		bands.close();
		System.out.println();

		// 9. Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("src/main/resources/bands.txt"))
				.filter(x -> x.contains("ee"))
				.toList();
		bands2.forEach(System.out::println);
		bands.close();
		System.out.println();

		// 10. Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("src/main/resources/data.txt"));
		List<String[]> arrays = rows1
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.toList();
		rows1.close();

		arrays.stream().map(Arrays::toString).forEach(System.out::println);

		Stream<String> rows1a = Files.lines(Paths.get("src/main/resources/data.txt"));

		int rowCount = (int)rows1a
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.count();
		rows1a.close();
		System.out.println(rowCount + " rows.");
		System.out.println();

		//11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("src/main/resources/data.txt"));
		rows2.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows2.close();
		System.out.println();

		// 12. Stream rows from CSV file, store fields in a HashMap
		Stream<String> rows3 = Files.lines(Paths.get("src/main/resources/data.txt"));
		Map<String, Integer> map = rows3.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(
						x -> x[0],
						x -> Integer.parseInt(x[1])
						)
				);
		rows3.close();
		map.forEach((s, integer) -> System.out.println(s + " " + integer));
		System.out.println();

		// 13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
				.reduce(0.0, (a, b) -> a + b);
		System.out.println("Total = " + total);
		System.out.println();

		// 14. Reduction - summary statistics
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
				.summaryStatistics();
		System.out.println(summary);
		System.out.println();

	}
}
