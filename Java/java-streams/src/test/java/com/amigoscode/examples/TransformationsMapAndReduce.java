package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(PersonDTO::map)
                .collect(Collectors.toList());

        assertThat(people.size()).isEqualTo(personDTOS.size());
        personDTOS.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        Double avgPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElseGet(() -> -1.0);
        System.out.println(avgPrice);

    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        System.out.println(sum);

    }
}

