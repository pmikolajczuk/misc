package pl.mikolaj.old.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // imperative approach
        //filter
        List<Person> females = new ArrayList<>();
        for(Person person : getPeople()) {
            if(Gender.FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }
        //females.forEach(System.out::println);
        //System.out.println();

        //sort
        List<Person> sortedPeople = new ArrayList<>(getPeople());
        sortedPeople.sort((o1, o2) -> o1.getAge() - o2.getAge());

//        sortedPeople.forEach(System.out::println);
//        System.out.println();


        // declarative approach
        //filter
        females = getPeople()
                .stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()))
                .toList();

        //females.forEach(System.out::println);
        //System.out.println();

        //sort
        sortedPeople = getPeople()
                .stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();

        //sortedPeople.forEach(System.out::println);

        //All match
        boolean allOlderThen5 = getPeople().stream()
                .allMatch(person -> person.getAge() > 5);

        //System.out.println("All older then 5: " + allOlderThen5);

        //max
//        getPeople().stream()
//                .max(Comparator.comparing(Person::getName))
//                .ifPresent(System.out::println);

        //group
        Map<Gender, Person> gender2Person = getPeople().stream()
                .collect(Collectors.toMap(Person::getGender, Function.identity(),(person, person2) -> person));

        //gender2Person.forEach((gender, person) -> System.out.println(gender + ": " + person));

        Map<Gender, List<String>> gender2NamesList = getPeople().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));

        //System.out.println(gender2NamesList);

        //reduce
        Integer ageSum1 = getPeople().stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println("Age Sum 1: " + ageSum1);

        Integer ageSum2 = getPeople().parallelStream()
                .reduce(0, (ageSum, person) -> ageSum + person.getAge(), Integer::sum);
        System.out.println("Age Sum 2: " + ageSum2);

        Integer ageSum3 = getPeople().parallelStream()
                .collect(Collectors.reducing(0, Person::getAge, Integer::sum));
        System.out.println("Age Sum 3: " + ageSum3);


    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE)
        );
    }
}
