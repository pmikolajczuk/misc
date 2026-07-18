package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> result = new ArrayList<>();
        for(Person person : people) {
            if(person.getAge() <= 18) {
                result.add(person);
                if(result.size() == 10) {
                    break;
                }
            }
        }
        for(Person person : result) {
            System.out.println(person);
        }
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        System.out.println("Declarative approach");
        List<Person> people = MockData.getPeople();
        List<Person> result = people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
