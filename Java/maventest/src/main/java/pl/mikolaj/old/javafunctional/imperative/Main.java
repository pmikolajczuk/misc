package pl.mikolaj.old.javafunctional.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static pl.mikolaj.old.javafunctional.imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // Imperative approach

        long femalesCount = 0;
        for(Person person : people) {
            if(FEMALE.equals(person.gender)) {
                femalesCount++;
            }
        }
        System.out.println("Females count: " + femalesCount);
        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if(person.gender == FEMALE) {
                females.add(person);
            }
        }

        for(Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        femalesCount = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .count();

        System.out.println("Females count: " + femalesCount);

        Predicate<Person> personPredicate = person -> person.gender == FEMALE;
        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .toList();

        females2.forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender {
        MALE, FEMALE
    }
}
