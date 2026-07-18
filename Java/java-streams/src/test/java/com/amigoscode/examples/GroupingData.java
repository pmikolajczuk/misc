package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        List<Car> cars = MockData.getCars();
        Map<String, List<Car>> make2Cars = cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

        for(String key : make2Cars.keySet()) {
            System.out.print(key + "=" + make2Cars.get(key).size() + ", ");
        }
        System.out.println();

        Map<String, Long> make2Count1 = cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake, Collectors.counting()));

        System.out.println(make2Count1);

        Map<String, Integer> make2Count2 = cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake, Collectors.reducing(0, car -> 1, Integer::sum)));

        System.out.println(make2Count2);
    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Integer> names2Count = names
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0,s -> 1, Integer::sum)));
        System.out.println(names2Count);
    }

}